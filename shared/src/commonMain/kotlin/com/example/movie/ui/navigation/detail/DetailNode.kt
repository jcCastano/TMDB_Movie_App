package com.example.movie.ui.navigation.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumble.appyx.components.backstack.BackStack
import com.bumble.appyx.navigation.modality.NodeContext
import com.bumble.appyx.navigation.node.LeafNode
import com.example.movie.ui.component.MovieScaffold
import com.example.movie.ui.navigation.NavTarget

class DetailNode(
    nodeContext: NodeContext,
    private val backStack: BackStack<NavTarget>
): LeafNode(
    nodeContext = nodeContext
) {
    @Composable
    override fun Content(modifier: Modifier) {
        MovieScaffold(
            title = "Details",
            backStack = backStack,
            enableCloseButton = true,
            modifier = Modifier
        ) {
            Text("Movie Details")
        }
    }
}