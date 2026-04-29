package id.my.sendiko.scanner.history.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.my.sendiko.scanner.history.domain.model.History
import id.my.sendiko.scanner.result.presentation.ResultType
import org.jetbrains.compose.resources.painterResource
import simpleqrscanner.composeapp.generated.resources.Res
import simpleqrscanner.composeapp.generated.resources.ic_contact
import simpleqrscanner.composeapp.generated.resources.ic_link
import simpleqrscanner.composeapp.generated.resources.ic_qr_code
import simpleqrscanner.composeapp.generated.resources.ic_text

@Composable
fun ScanHistoryCard(
    history: History,
    onMoreClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val resultType = try {
        ResultType.valueOf(history.type.uppercase())
    } catch (e: Exception) {
        ResultType.OTHERS
    }

    val icon: Painter = when (resultType) {
        ResultType.LINK -> painterResource(Res.drawable.ic_link)
        ResultType.CONTACT -> painterResource(Res.drawable.ic_contact)
        ResultType.TEXT -> painterResource(Res.drawable.ic_text)
        // For WIFI and BARCODE we use ic_qr_code or similar as placeholder if specific ones are missing
        // or just use ic_qr_code as a fallback
        else -> painterResource(Res.drawable.ic_qr_code)
    }

    val typeLabel = when (resultType) {
        ResultType.LINK -> "Web Link"
        ResultType.CONTACT -> "vCard"
        ResultType.TEXT -> "Plain Text"
        ResultType.WIFI -> "Network"
        ResultType.BARCODE -> "Barcode"
        ResultType.OTHERS -> "Others"
    }

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = history.result,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                
                Text(
                    text = "${getRelativeTime(history.timestamp)} • $typeLabel",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 12.sp
                    )
                )
            }

            IconButton(onClick = onMoreClick) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More options",
                )
            }
        }
    }
}

private fun getRelativeTime(timestamp: Long): String {
    // Simplified for mockup purposes
    return "Just now"
}
