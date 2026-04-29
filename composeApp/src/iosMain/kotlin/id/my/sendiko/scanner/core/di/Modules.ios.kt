package id.my.sendiko.scanner.core.di

import id.my.sendiko.scanner.core.data.local.AppDatabase
import id.my.sendiko.scanner.core.data.local.getDatabaseBuilder
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single { getDatabaseBuilder().build() }
    single { get<AppDatabase>().scanDao() }
}
