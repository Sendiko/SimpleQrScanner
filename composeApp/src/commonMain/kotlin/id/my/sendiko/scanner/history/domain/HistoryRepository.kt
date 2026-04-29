package id.my.sendiko.scanner.history.domain

import id.my.sendiko.scanner.history.domain.model.History
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {

    suspend fun insertScanResult(result: String, type: String)

    fun getAllScanResults(): Flow<List<History>>

    suspend fun deleteScanResult(id: Long)

}