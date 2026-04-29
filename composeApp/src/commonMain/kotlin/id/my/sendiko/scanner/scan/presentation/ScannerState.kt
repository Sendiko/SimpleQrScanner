package id.my.sendiko.scanner.scan.presentation

data class ScannerState(
    val isScanning: Boolean = true,
    val result: String = "",
    val usingTorch: Boolean = false,
)