package id.my.sendiko.scanner.core

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import id.my.sendiko.scanner.core.navigation.NavGraph
import id.my.sendiko.scanner.core.ui.theme.AppTheme

@Composable
@Preview
fun App() {
    AppTheme {
        val navController = rememberNavController()
        NavGraph(
            navController = navController
        )
    }
}
