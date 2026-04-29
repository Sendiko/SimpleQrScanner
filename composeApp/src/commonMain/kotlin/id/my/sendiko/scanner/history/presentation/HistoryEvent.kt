package id.my.sendiko.scanner.history.presentation

import id.my.sendiko.scanner.history.presentation.components.HistoryFilterType

sealed interface HistoryEvent {
    data class DeleteScanResult(val id: Long) : HistoryEvent
    data class ChangeDeleteDialog(val show: Boolean) : HistoryEvent
    data class OnFilterChange(val filter: HistoryFilterType) : HistoryEvent
}