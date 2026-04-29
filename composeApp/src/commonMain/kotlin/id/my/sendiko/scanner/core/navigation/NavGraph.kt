package id.my.sendiko.scanner.core.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import id.my.sendiko.scanner.core.ui.components.ScanQrBar
import id.my.sendiko.scanner.core.ui.components.ScannerBottomNavigation
import id.my.sendiko.scanner.result.presentation.ScanResultScreen
import id.my.sendiko.scanner.result.presentation.ScanResultViewModel
import id.my.sendiko.scanner.scan.presentation.ScannerScreen
import id.my.sendiko.scanner.scan.presentation.ScannerViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavGraph,
        modifier = modifier
    ) {
        composable<BottomNavGraph> {
            BottomNavScreen(
                onNavigateToRoot = { destination ->
                    navController.navigate(destination) {
                        popUpTo(destination) { inclusive = true }
                    }
                }
            )
        }

        composable<ResultDestination> { backStackEntry ->
            val result = backStackEntry.toRoute<ResultDestination>().result
            val viewModel = viewModel<ScanResultViewModel>()
            val state by viewModel.state.collectAsStateWithLifecycle()
            
            LaunchedEffect(result) {
                viewModel.setResult(result)
            }

            ScanResultScreen(
                state = state,
                onScanAnother = {
                    navController.popBackStack(BottomNavGraph, inclusive = false)
                }
            )
        }

        composable<AboutDestination> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("About Screen")
            }
        }
    }
}

@Composable
fun BottomNavScreen(
    onNavigateToRoot: (Any) -> Unit
) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination

    Scaffold(
        topBar = {
            if (currentDestination?.hasRoute<ScannerDestination>() == true) {
                val viewModel = viewModel<ScannerViewModel>()
                val state by viewModel.state.collectAsStateWithLifecycle()
                ScanQrBar(isScanning = state.isScanning)
            } else { ScanQrBar() }
        },
        bottomBar = {
            val selectedItem = when {
                currentDestination?.hasRoute<ScannerDestination>() == true -> ScannerDestination
                currentDestination?.hasRoute<HistoryDestination>() == true -> HistoryDestination
                currentDestination?.hasRoute<SettingsDestination>() == true -> SettingsDestination
                else -> ScannerDestination
            }
            ScannerBottomNavigation(
                currentDestination = selectedItem,
                onNavigate = { destination ->
                    navController.navigate(destination) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = ScannerDestination,
            modifier = Modifier.padding(padding)
        ) {
            composable<ScannerDestination> {
                val viewModel = viewModel<ScannerViewModel>()
                val state by viewModel.state.collectAsStateWithLifecycle()
                ScannerScreen(
                    state = state,
                    onEvent = viewModel::onEvent,
                    onNavigate = onNavigateToRoot
                )
            }

            composable<HistoryDestination> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("History Screen")
                }
            }

            composable<SettingsDestination> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Settings Screen")
                }
            }
        }
    }
}
