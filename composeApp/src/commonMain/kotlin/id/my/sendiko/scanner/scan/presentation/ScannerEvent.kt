package id.my.sendiko.scanner.scan.presentation

sealed interface ScannerEvent {
    data class OnScanningChanged(val scanning: Boolean): ScannerEvent
    data class OnTorchToggled(val torch: Boolean): ScannerEvent
    data class OnScanned(val result: String): ScannerEvent
}