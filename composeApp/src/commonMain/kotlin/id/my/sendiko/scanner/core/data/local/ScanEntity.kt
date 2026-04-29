package id.my.sendiko.scanner.core.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "scan_results")
data class ScanEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val result: String,
    val type: String,
    val timestamp: Long
)
