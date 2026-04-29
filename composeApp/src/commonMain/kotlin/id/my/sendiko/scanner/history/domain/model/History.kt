package id.my.sendiko.scanner.history.domain.model

data class History(
    val id: Long = 0,
    val result: String,
    val type: String,
    val timestamp: Long
)
