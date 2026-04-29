package id.my.sendiko.scanner.history.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import id.my.sendiko.scanner.core.ui.theme.AppTheme
import id.my.sendiko.scanner.history.domain.model.History
import id.my.sendiko.scanner.history.presentation.components.HistoryFilterChips
import id.my.sendiko.scanner.history.presentation.components.HistoryFilterType
import id.my.sendiko.scanner.history.presentation.components.ScanHistoryCard
import org.jetbrains.compose.resources.stringResource
import androidx.compose.ui.tooling.preview.Preview
import simpleqrscanner.composeapp.generated.resources.Res
import simpleqrscanner.composeapp.generated.resources.history_subtitle
import simpleqrscanner.composeapp.generated.resources.history_title

@Composable
fun HistoryScreen(
    state: HistoryState,
    onEvent: (HistoryEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 24.dp)
        ) {
            Text(
                text = stringResource(Res.string.history_title),
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(Res.string.history_subtitle),
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
        }

        HistoryFilterChips(
            selectedFilter = state.selectedFilter,
            onFilterSelected = { onEvent(HistoryEvent.OnFilterChange(it)) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(state.history) { history ->
                ScanHistoryCard(
                    history = history,
                    onMoreClick = { /* Handle more click */ }
                )
            }
        }
    }
}

@Preview
@Composable
fun HistoryScreenPreview() {
    val sampleHistory = listOf(
        History(
            id = 1,
            result = "https://example.com/design-system/tokens",
            type = "LINK",
            timestamp = 1715424000000
        ),
        History(
            id = 2,
            result = "Eleanor Shellstrop",
            type = "CONTACT",
            timestamp = 1715424000000
        ),
        History(
            id = 3,
            result = "Gate code: 8492#",
            type = "TEXT",
            timestamp = 1715424000000
        ),
        History(
            id = 4,
            result = "Studio_Guest_5G",
            type = "WIFI",
            timestamp = 1715424000000
        ),
        History(
            id = 5,
            result = "EAN: 084192008321",
            type = "BARCODE",
            timestamp = 1715424000000
        )
    )
    AppTheme {
        HistoryScreen(
            state = HistoryState(
                history = sampleHistory,
                selectedFilter = HistoryFilterType.ALL
            ),
            onEvent = {}
        )
    }
}
