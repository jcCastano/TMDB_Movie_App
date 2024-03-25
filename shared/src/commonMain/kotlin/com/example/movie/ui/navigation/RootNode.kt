package com.example.movie.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumble.appyx.components.backstack.BackStack
import com.bumble.appyx.components.backstack.BackStackModel
import com.bumble.appyx.components.backstack.ui.fader.BackStackFader
import com.bumble.appyx.navigation.composable.AppyxNavigationContainer
import com.bumble.appyx.navigation.modality.NodeContext
import com.bumble.appyx.navigation.node.Node
import com.example.movie.ui.navigation.detail.DetailNode
import com.example.movie.ui.navigation.home.HomeNode

class RootNode(
    nodeContext: NodeContext,
    private val backStack: BackStack<NavTarget> = BackStack(
        model = BackStackModel(
            initialTarget = NavTarget.Movie,
            savedStateMap = nodeContext.savedStateMap
        ),
        visualisation = { BackStackFader(it) }
    )
): Node<NavTarget>(
    nodeContext = nodeContext,
    appyxComponent = backStack
) {
    @Composable
    override fun Content(modifier: Modifier) {
        AppyxNavigationContainer(
            appyxComponent = backStack
        )
    }

    override fun buildChildNode(navTarget: NavTarget, nodeContext: NodeContext): Node<*> =
        when(navTarget) {
            NavTarget.Movie -> HomeNode(nodeContext = nodeContext, backStack = backStack)
            NavTarget.Detail -> DetailNode(nodeContext = nodeContext, backStack = backStack)
        }
}