package com.example.movie


import androidx.compose.ui.window.ComposeUIViewController
import com.bumble.appyx.navigation.integration.IosNodeHost
import com.bumble.appyx.navigation.integration.MainIntegrationPoint
import com.example.movie.ui.App
import com.example.movie.ui.navigation.RootNode
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceStyle

val backEvents: Channel<Unit> = Channel()
private val integrationPoint = MainIntegrationPoint()
val isDarkTheme = UIScreen.mainScreen.traitCollection.userInterfaceStyle == UIUserInterfaceStyle.UIUserInterfaceStyleDark

fun MainViewController() = ComposeUIViewController {
    App().Content(darkTheme = isDarkTheme) {
        IosNodeHost(
            onBackPressedEvents = backEvents.receiveAsFlow(),
            integrationPoint = integrationPoint
        ) {
            RootNode(
                nodeContext = it
            )
        }
    }
}.also { uiViewController ->
    integrationPoint.setViewController(uiViewController)
}
