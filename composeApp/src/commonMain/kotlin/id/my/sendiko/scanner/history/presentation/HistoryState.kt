package id.my.sendiko.scanner.history.presentation

import id.my.sendiko.scanner.history.domain.model.History
import id.my.sendiko.scanner.history.presentation.components.HistoryFilterType

data class HistoryState(
    val history: List<History> = emptyList(),
    val deleteDropDown: Boolean = false,
    val selectedFilter: HistoryFilterType = HistoryFilterType.ALL,
)
