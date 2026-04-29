package id.my.sendiko.scanner.core.data.local

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor

@Database(entities = [ScanEntity::class], version = 1)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun scanDao(): ScanDao
}

// The following is required for Room KMP
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase>

internal const val DB_FILE_NAME = "scanner.db"
