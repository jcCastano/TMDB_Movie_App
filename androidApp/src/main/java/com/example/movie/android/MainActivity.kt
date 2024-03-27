package com.example.movie.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.ui.platform.LocalLifecycleOwner
import com.bumble.appyx.navigation.integration.NodeActivity
import com.bumble.appyx.navigation.integration.NodeHost
import com.bumble.appyx.navigation.platform.AndroidLifecycle
import com.example.movie.di.KoinInstance
import com.example.movie.di.sharedModule
import com.example.movie.ui.App
import com.example.movie.ui.navigation.RootNode
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainActivity : NodeActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoinInstance.start {
                startKoin {
                    androidLogger()
                    androidContext(this@MainActivity)
                    modules(listOf(sharedModule))
                }
            }
            App().Content(darkTheme = isSystemInDarkTheme()) {
                NodeHost(
                    lifecycle = AndroidLifecycle(LocalLifecycleOwner.current.lifecycle),
                    integrationPoint = appyxV2IntegrationPoint
                ) {
                    RootNode(nodeContext = it)
                }
            }
        }
    }
}
