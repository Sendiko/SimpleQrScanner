package id.my.sendiko.scanner.history.data.datasource

import id.my.sendiko.scanner.core.data.local.ScanDao
import id.my.sendiko.scanner.core.data.local.ScanEntity
import kotlinx.coroutines.flow.Flow
import kotlin.time.Clock

class HistoryLocalDataSourceImpl(
    private val dao: ScanDao
) : HistoryLocalDataSource {
    override suspend fun insertScanResult(result: String, type: String) {
        dao.insertScan(
            ScanEntity(
                result = result,
                type = type,
                timestamp = Clock.System.now().toEpochMilliseconds()
            )
        )
    }

    override fun getAllScanResults(): Flow<List<ScanEntity>> {
        return dao.getAllScans()
    }

    override suspend fun deleteScanResult(id: Long) {
        dao.deleteScanById(id)
    }
}