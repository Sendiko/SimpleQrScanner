package id.my.sendiko.scanner.history.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.my.sendiko.scanner.history.domain.HistoryRepository
import id.my.sendiko.scanner.history.presentation.components.HistoryFilterType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HistoryViewModel(
    private val repository: HistoryRepository
) : ViewModel() {

    private val _state = MutableStateFlow(HistoryState())
    private val _historyList = repository.getAllScanResults()

    val state = combine(_state, _historyList) { state, history ->
        val filteredHistory = when (state.selectedFilter) {
            HistoryFilterType.ALL -> history
            HistoryFilterType.URL -> history.filter { it.type.equals("LINK", true) }
            HistoryFilterType.TEXT -> history.filter { it.type.equals("TEXT", true) }
            HistoryFilterType.CONTACT -> history.filter { it.type.equals("CONTACT", true) }
        }
        state.copy(history = filteredHistory)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), HistoryState())

    fun onEvent(event: HistoryEvent) {
        when (event) {
            is HistoryEvent.ChangeDeleteDialog -> {
                _state.update { it.copy(deleteDropDown = event.show) }
            }

            is HistoryEvent.DeleteScanResult -> {
                viewModelScope.launch {
                    repository.deleteScanResult(event.id)
                }
            }

            is HistoryEvent.OnFilterChange -> {
                _state.update { it.copy(selectedFilter = event.filter) }
            }
        }
    }
}