package com.example.movie.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumble.appyx.components.backstack.BackStack
import com.bumble.appyx.components.backstack.operation.push
import com.bumble.appyx.navigation.modality.NodeContext
import com.bumble.appyx.navigation.node.LeafNode
import com.example.movie.ui.component.MovieScaffold
import com.example.movie.ui.navigation.NavTarget
import org.koin.core.component.KoinComponent

class HomeNode(
    private val viewModel: HomeViewModel,
    nodeContext: NodeContext,
    private val backStack: BackStack<NavTarget>
): LeafNode(
    nodeContext = nodeContext
), KoinComponent {

    @Composable
    override fun Content(modifier: Modifier) {
        MovieScaffold(
            title = "Movies",
            backStack = backStack
        ) {
            HomeScreen(
                uiState = viewModel.uiState,
                loadNextMovies = {
                    viewModel.loadMovies(it)
                },
                navigateToDetail = {
                    backStack.push(NavTarget.Detail(it))
                }
            )
        }
    }
}