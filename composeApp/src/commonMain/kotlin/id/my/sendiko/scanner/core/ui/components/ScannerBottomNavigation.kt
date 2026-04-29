package id.my.sendiko.scanner.core.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import id.my.sendiko.scanner.core.navigation.HistoryDestination
import id.my.sendiko.scanner.core.navigation.ScannerDestination
import id.my.sendiko.scanner.core.navigation.SettingsDestination
import id.my.sendiko.scanner.core.ui.theme.AppTheme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import simpleqrscanner.composeapp.generated.resources.Res
import simpleqrscanner.composeapp.generated.resources.ic_history
import simpleqrscanner.composeapp.generated.resources.ic_qr_code
import simpleqrscanner.composeapp.generated.resources.ic_settings
import simpleqrscanner.composeapp.generated.resources.nav_history
import simpleqrscanner.composeapp.generated.resources.nav_scan
import simpleqrscanner.composeapp.generated.resources.nav_settings

@Composable
fun ScannerBottomNavigation(
    currentDestination: Any?,
    onNavigate: (Any) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
            .fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.surface,
    ) {
        val items = listOf(
            NavigationItem(
                label = Res.string.nav_scan,
                icon = Res.drawable.ic_qr_code,
                destination = ScannerDestination
            ),
            NavigationItem(
                label = Res.string.nav_history,
                icon = Res.drawable.ic_history,
                destination = HistoryDestination
            ),
            NavigationItem(
                label = Res.string.nav_settings,
                icon = Res.drawable.ic_settings,
                destination = SettingsDestination
            )
        )

        items.forEach { item ->
            val isSelected = currentDestination == item.destination
            NavigationBarItem(
                selected = isSelected,
                onClick = { onNavigate(item.destination) },
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = stringResource(item.label)
                    )
                },
                label = {
                    Text(
                        text = stringResource(item.label),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            )
        }
    }
}

private data class NavigationItem(
    val label: StringResource,
    val icon: DrawableResource,
    val destination: Any
)

@Preview
@Composable
fun ScannerBottomNavigationPreview() {
    AppTheme {
        ScannerBottomNavigation(
            currentDestination = ScannerDestination,
            onNavigate = {}
        )
    }
}