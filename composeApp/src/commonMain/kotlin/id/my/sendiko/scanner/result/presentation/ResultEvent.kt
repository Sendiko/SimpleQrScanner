package id.my.sendiko.scanner.result.presentation

sealed interface ResultEvent {
    data object OnSave: ResultEvent
}