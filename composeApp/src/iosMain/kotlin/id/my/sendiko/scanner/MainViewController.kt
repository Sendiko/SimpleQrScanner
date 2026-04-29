package id.my.sendiko.scanner

import androidx.compose.ui.window.ComposeUIViewController
import id.my.sendiko.scanner.core.App
import id.my.sendiko.scanner.core.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}
