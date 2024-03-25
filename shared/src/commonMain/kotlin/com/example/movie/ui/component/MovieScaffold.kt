package com.example.movie.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.bumble.appyx.components.backstack.BackStack
import com.bumble.appyx.components.backstack.operation.pop
import com.example.movie.ui.navigation.NavTarget

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieScaffold(
    title: String,
    backStack: BackStack<NavTarget>,
    enableCloseButton: Boolean = false,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                        Row {
                            if (!enableCloseButton)
                                Spacer(modifier = Modifier.padding(20.dp))
                            Text(
                                text =  title,
                                style = MaterialTheme.typography.headlineLarge
                            )
                        }
                },
                navigationIcon = if (enableCloseButton) {
                    {
                        IconButton(onClick = {backStack.pop()}) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                                contentDescription = "Go Back"
                            )
                        }
                    }
                } else {
                    {}
                },
                modifier = Modifier.shadow(
                    elevation = 16.dp,
                    ambientColor = MaterialTheme.colorScheme.onBackground,
                    spotColor = MaterialTheme.colorScheme.onBackground
                )
            )
        },
        modifier = modifier
    ) {
        Column {
            Spacer(modifier = Modifier.padding(top = 64.dp))
            content()
        }
    }
}