package id.my.sendiko.scanner.history.data.datasource

import id.my.sendiko.scanner.core.data.local.ScanEntity
import kotlinx.coroutines.flow.Flow

interface HistoryLocalDataSource {

    suspend fun insertScanResult(result: String, type: String)

    fun getAllScanResults(): Flow<List<ScanEntity>>

    suspend fun deleteScanResult(id: Long)

}