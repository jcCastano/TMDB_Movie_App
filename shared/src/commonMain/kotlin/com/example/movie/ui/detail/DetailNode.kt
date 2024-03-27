package com.example.movie.ui.navigation.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumble.appyx.components.backstack.BackStack
import com.bumble.appyx.navigation.modality.NodeContext
import com.bumble.appyx.navigation.node.LeafNode
import com.example.movie.data.remote.KtorApi
import com.example.movie.data.remote.MovieService
import com.example.movie.domain.usecase.GetMoviesUseCase
import com.example.movie.ui.component.MovieScaffold
import com.example.movie.ui.navigation.NavTarget
import kotlinx.coroutines.runBlocking
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DetailNode(
    nodeContext: NodeContext,
    private val backStack: BackStack<NavTarget>
): LeafNode(
    nodeContext = nodeContext
), KoinComponent {

    val useCase: GetMoviesUseCase by inject<GetMoviesUseCase>()

    @Composable
    override fun Content(modifier: Modifier) {
        MovieScaffold(
            title = "Details",
            backStack = backStack,
            enableCloseButton = true,
            modifier = Modifier
        ) {
            var text = ""
            runBlocking {
                text = useCase(1)[0].toString()
            }
            SelectionContainer {
                Text(text)
            }
        }
    }
}