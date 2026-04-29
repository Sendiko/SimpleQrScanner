package id.my.sendiko.scanner.core.navigation

import kotlinx.serialization.Serializable

@Serializable
data object RootGraph

@Serializable
data object BottomNavGraph

@Serializable
data object ScannerDestination

@Serializable
data object HistoryDestination

@Serializable
data object SettingsDestination

@Serializable
data class ResultDestination(val result: String)

@Serializable
data object AboutDestination