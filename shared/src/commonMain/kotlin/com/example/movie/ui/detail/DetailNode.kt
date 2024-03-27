package com.example.movie.ui.detail

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumble.appyx.components.backstack.BackStack
import com.bumble.appyx.navigation.modality.NodeContext
import com.bumble.appyx.navigation.node.LeafNode
import com.example.movie.domain.model.Movie
import com.example.movie.ui.component.MovieScaffold
import com.example.movie.ui.navigation.NavTarget
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class DetailNode(
    nodeContext: NodeContext,
    private val movie: Movie,
    private val backStack: BackStack<NavTarget>
): LeafNode(
    nodeContext = nodeContext
), KoinComponent {

    private val viewModel by inject<DetailViewModel> { parametersOf(movie.id) }

    @Composable
    override fun Content(modifier: Modifier) {
        MovieScaffold(
            title = "Details",
            backStack = backStack,
            enableCloseButton = true,
            modifier = Modifier
        ) {
            DetailScreen(uiState = viewModel.uiState)
        }
    }
}