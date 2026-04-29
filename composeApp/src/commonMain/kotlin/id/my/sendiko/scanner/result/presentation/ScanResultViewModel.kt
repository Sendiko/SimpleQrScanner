package id.my.sendiko.scanner.result.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.my.sendiko.scanner.history.domain.HistoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ScanResultViewModel(
    private val repository: HistoryRepository
) : ViewModel() {

    private val _state = MutableStateFlow(ResultState())
    val state = _state.asStateFlow()

    fun setResult(result: String) {
        val type = when {
            result.startsWith("http://") || result.startsWith("https://") ||
                    result.startsWith("www.") -> ResultType.LINK

            result.startsWith("BEGIN:VCARD") || result.startsWith("MECARD:") -> ResultType.CONTACT
            else -> ResultType.TEXT
        }
        _state.update {
            it.copy(
                result = result,
                type = type
            )
        }
        saveResult(result, type.name)
    }

    fun saveResult(result: String, type: String) {
        viewModelScope.launch {
            repository.insertScanResult(result, type)
        }
    }
}