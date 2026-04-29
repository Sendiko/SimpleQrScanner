package id.my.sendiko.scanner.core.di

import id.my.sendiko.scanner.history.data.HistoryRepositoryImpl
import id.my.sendiko.scanner.history.data.datasource.HistoryLocalDataSource
import id.my.sendiko.scanner.history.data.datasource.HistoryLocalDataSourceImpl
import id.my.sendiko.scanner.history.domain.HistoryRepository
import id.my.sendiko.scanner.history.presentation.HistoryViewModel
import id.my.sendiko.scanner.result.presentation.ScanResultViewModel
import id.my.sendiko.scanner.scan.presentation.ScannerViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    singleOf(::HistoryLocalDataSourceImpl) bind HistoryLocalDataSource::class
    singleOf(::HistoryRepositoryImpl) bind HistoryRepository::class

    viewModelOf(::ScannerViewModel)
    viewModelOf(::ScanResultViewModel)
    viewModelOf(::HistoryViewModel)
}
