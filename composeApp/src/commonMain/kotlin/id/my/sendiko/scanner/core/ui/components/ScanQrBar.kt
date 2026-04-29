package id.my.sendiko.scanner.core.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import id.my.sendiko.scanner.core.ui.theme.AppTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import androidx.compose.ui.tooling.preview.Preview
import simpleqrscanner.composeapp.generated.resources.Res
import simpleqrscanner.composeapp.generated.resources.ic_info
import simpleqrscanner.composeapp.generated.resources.ic_qr_code
import simpleqrscanner.composeapp.generated.resources.info_icon_desc
import simpleqrscanner.composeapp.generated.resources.qr_code_icon_desc
import simpleqrscanner.composeapp.generated.resources.scan_qr

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScanQrBar(
    modifier: Modifier = Modifier,
    isScanning: Boolean = false
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(Res.string.scan_qr),
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            )
        },
        navigationIcon = {
            if (!isScanning) {
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(Res.drawable.ic_qr_code),
                        contentDescription = stringResource(Res.string.qr_code_icon_desc),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(Res.drawable.ic_info),
                    contentDescription = stringResource(Res.string.info_icon_desc),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    )
}

@Preview
@Composable
fun ScanQrBarPreview() {
    AppTheme {
        ScanQrBar()
    }
}
