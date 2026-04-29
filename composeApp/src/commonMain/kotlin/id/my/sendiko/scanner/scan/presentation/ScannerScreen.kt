package id.my.sendiko.scanner.scan.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemGesturesPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import id.my.sendiko.scanner.core.navigation.ResultDestination
import org.jetbrains.compose.resources.painterResource
import org.publicvalue.multiplatform.qrcode.CameraPosition
import org.publicvalue.multiplatform.qrcode.CodeType
import org.publicvalue.multiplatform.qrcode.ScannerWithPermissions
import simpleqrscanner.composeapp.generated.resources.Res
import simpleqrscanner.composeapp.generated.resources.scanner_outline

@Composable
fun ScannerScreen(
    state: ScannerState,
    onEvent: (ScannerEvent) -> Unit,
    onNavigate: (Any) -> Unit,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(state.result) {
        if (state.result.isNotEmpty()) {
            onNavigate(ResultDestination(state.result))
            onEvent(ScannerEvent.OnScanned(""))
        }
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        ScannerWithPermissions(
            modifier = modifier,
            onScanned = { onEvent(ScannerEvent.OnScanned(it)); true },
            types = listOf(CodeType.QR),
            cameraPosition = CameraPosition.BACK,
            enableTorch = state.usingTorch,
            permissionDeniedContent = {

            }
        )
        Image(
            modifier = Modifier.align(Alignment.Center).fillMaxSize(.5f),
            painter = painterResource(Res.drawable.scanner_outline),
            contentDescription = null
        )
    }
}