package com.example.movie.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumble.appyx.components.backstack.BackStack
import com.bumble.appyx.components.backstack.BackStackModel
import com.bumble.appyx.components.backstack.ui.fader.BackStackFader
import com.bumble.appyx.navigation.composable.AppyxNavigationContainer
import com.bumble.appyx.navigation.modality.NodeContext
import com.bumble.appyx.navigation.node.Node
import com.example.movie.ui.detail.DetailNode
import com.example.movie.ui.home.HomeNode
import com.example.movie.ui.home.HomeViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RootNode(
    nodeContext: NodeContext,
    private val backStack: BackStack<NavTarget> = BackStack(
        model = BackStackModel(
            initialTarget = NavTarget.Home,
            savedStateMap = nodeContext.savedStateMap
        ),
        visualisation = { BackStackFader(it) }
    )
): Node<NavTarget>(
    nodeContext = nodeContext,
    appyxComponent = backStack
), KoinComponent {

    private val homeViewModel by inject<HomeViewModel>()

    @Composable
    override fun Content(modifier: Modifier) {
        AppyxNavigationContainer(
            appyxComponent = backStack
        )
    }

    override fun buildChildNode(navTarget: NavTarget, nodeContext: NodeContext): Node<*> =
        when(navTarget) {
            NavTarget.Home -> HomeNode(viewModel = homeViewModel, nodeContext = nodeContext, backStack = backStack)
            is NavTarget.Detail ->  DetailNode(nodeContext = nodeContext, movie = navTarget.movie, backStack = backStack)
        }
}