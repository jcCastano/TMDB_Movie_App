package com.example.movie


import androidx.compose.ui.window.ComposeUIViewController
import com.bumble.appyx.navigation.integration.IosNodeHost
import com.bumble.appyx.navigation.integration.MainIntegrationPoint
import com.example.movie.di.KoinInstance
import com.example.movie.di.sharedModule
import com.example.movie.ui.App
import com.example.movie.ui.navigation.RootNode
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import org.koin.core.context.startKoin
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceStyle

val backEvents: Channel<Unit> = Channel()
private val integrationPoint = MainIntegrationPoint()

fun MainViewController() = ComposeUIViewController {
    KoinInstance.start {
        startKoin {
            modules(listOf(sharedModule))
        }
    }
    App().Content(darkTheme = UIScreen.mainScreen.traitCollection.userInterfaceStyle == UIUserInterfaceStyle.UIUserInterfaceStyleDark) {
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
