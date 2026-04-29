package id.my.sendiko.scanner.history.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import id.my.sendiko.scanner.core.ui.theme.AppTheme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import androidx.compose.ui.tooling.preview.Preview
import simpleqrscanner.composeapp.generated.resources.Res
import simpleqrscanner.composeapp.generated.resources.contact_icon_desc
import simpleqrscanner.composeapp.generated.resources.filter_all
import simpleqrscanner.composeapp.generated.resources.filter_contact
import simpleqrscanner.composeapp.generated.resources.filter_text
import simpleqrscanner.composeapp.generated.resources.filter_url
import simpleqrscanner.composeapp.generated.resources.ic_contact
import simpleqrscanner.composeapp.generated.resources.ic_link
import simpleqrscanner.composeapp.generated.resources.ic_text
import simpleqrscanner.composeapp.generated.resources.link_icon_desc
import simpleqrscanner.composeapp.generated.resources.text_icon_desc

enum class HistoryFilterType {
    ALL, URL, TEXT, CONTACT
}

private data class FilterItem(
    val type: HistoryFilterType,
    val labelRes: StringResource,
    val iconRes: DrawableResource? = null,
    val contentDescriptionRes: StringResource? = null
)

@Composable
fun HistoryFilterChips(
    selectedFilter: HistoryFilterType,
    onFilterSelected: (HistoryFilterType) -> Unit,
    modifier: Modifier = Modifier
) {
    val filters = listOf(
        FilterItem(HistoryFilterType.ALL, Res.string.filter_all),
        FilterItem(HistoryFilterType.URL, Res.string.filter_url, Res.drawable.ic_link, Res.string.link_icon_desc),
        FilterItem(HistoryFilterType.TEXT, Res.string.filter_text, Res.drawable.ic_text, Res.string.text_icon_desc),
        FilterItem(HistoryFilterType.CONTACT, Res.string.filter_contact, Res.drawable.ic_contact, Res.string.contact_icon_desc)
    )

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(filters) { item ->
            val isSelected = item.type == selectedFilter
            FilterChip(
                selected = isSelected,
                onClick = { onFilterSelected(item.type) },
                label = {
                    Text(
                        text = stringResource(item.labelRes),
                        style = MaterialTheme.typography.labelLarge
                    )
                },
                leadingIcon = item.iconRes?.let {
                    {
                        Icon(
                            painter = painterResource(it),
                            contentDescription = item.contentDescriptionRes?.let { res -> stringResource(res) },
                            modifier = Modifier.size(18.dp)
                        )
                    }
                },
                shape = MaterialTheme.shapes.extraLarge,
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                    labelColor = MaterialTheme.colorScheme.primary,
                    iconColor = MaterialTheme.colorScheme.primary,
                    selectedContainerColor = MaterialTheme.colorScheme.primary,
                    selectedLabelColor = MaterialTheme.colorScheme.onPrimary,
                    selectedLeadingIconColor = MaterialTheme.colorScheme.onPrimary
                ),
                border = null
            )
        }
    }
}

@Preview
@Composable
fun HistoryFilterChipsPreview() {
    AppTheme {
        HistoryFilterChips(
            selectedFilter = HistoryFilterType.ALL,
            onFilterSelected = {}
        )
    }
}
