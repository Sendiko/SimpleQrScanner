package id.my.sendiko.scanner.history.data

import id.my.sendiko.scanner.history.data.datasource.HistoryLocalDataSource
import id.my.sendiko.scanner.history.domain.HistoryRepository
import id.my.sendiko.scanner.history.domain.model.History
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HistoryRepositoryImpl(
    private val dataSource: HistoryLocalDataSource
) : HistoryRepository {
    override suspend fun insertScanResult(result: String, type: String) {
        dataSource.insertScanResult(result, type)
    }

    override fun getAllScanResults(): Flow<List<History>> {
        return dataSource.getAllScanResults().map { entities ->
            entities.map { entity ->
                History(
                    id = entity.id,
                    result = entity.result,
                    type = entity.type,
                    timestamp = entity.timestamp
                )
            }
        }
    }

    override suspend fun deleteScanResult(id: Long) {
        dataSource.deleteScanResult(id)
    }
}