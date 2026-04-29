package id.my.sendiko.scanner.scan.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ScannerViewModel : ViewModel() {

    private val _state = MutableStateFlow(ScannerState())
    val state = _state.asStateFlow()

    override fun onCleared() {
        super.onCleared()
        _state.update { ScannerState() }
    }

    fun onEvent(event: ScannerEvent) {
        when (event) {
            is ScannerEvent.OnScanned -> saveResult(event.result)
            is ScannerEvent.OnScanningChanged -> changeScan(event.scanning)
            is ScannerEvent.OnTorchToggled -> toggleTorch(event.torch)
        }
    }

    private fun toggleTorch(torch: Boolean) {
        _state.update { it.copy(usingTorch = torch) }
    }

    private fun changeScan(scanning: Boolean) {
        _state.update { it.copy(isScanning = scanning) }
    }

    private fun saveResult(result: String) {
        _state.update { it.copy(result = result) }
    }

}