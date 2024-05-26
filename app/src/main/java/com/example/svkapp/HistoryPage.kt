@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.svkapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.svkapp.ui.theme.TemplateApplicationTheme
import java.util.Date


@Composable
fun HistoryListItem(
    modifier: Modifier = Modifier,
    routeNumber: String,
    date: Date,
    canEdit: Boolean = true,
    onShow: (id: String) -> Unit = {},
    onEdit: (id: String) -> Unit = {},
) {


//        ListItem(
//            colors = ListItemDefaults.colors(
//                containerColor = MaterialTheme.colorScheme.surfaceVariant,
//            ),
//            headlineText = { Text(text = routeNumber) },
//            supportingText = { Text(text = date.toString()) },
//            trailingContent = { Icon(Icons.Default.Edit, contentDescription = null) },
//        )
    Card(modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(1.dp, Color.Black),
        onClick = { onShow(routeNumber) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier) {
                Text(
                    text = "Route number:",
                    modifier = modifier,
                    fontSize = MaterialTheme.typography.labelSmall.fontSize,
                    fontWeight = MaterialTheme.typography.headlineMedium.fontWeight
                )
                Text(
                    text = routeNumber,
                    modifier = modifier,
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                    fontWeight = MaterialTheme.typography.headlineMedium.fontWeight
                )
                //TODO better to string
                Text(text = date.toString(), modifier = modifier)
            }
            Icon(
                Icons.Default.Edit,
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
                    .clickable { onEdit(routeNumber) },
                tint = if (canEdit) Color.Black else Color.Gray
            )
        }

    }

}


//TODO replace class
class HistoryItem(
    val routeNumber: String,
    val date: Date,
    val canEdit: Boolean = true,
);

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryPage(
    modifier: Modifier = Modifier,
    historieItems: List<HistoryItem>,
    onSHowHistoryItem: (id: String) -> Unit = {},
    onEditHistoryItem: (id: String) -> Unit = {},
) {
    Scaffold(
        topBar = {
            SvkTopNavigationComposable()
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                fontWeight = FontWeight.Bold,
                text = "History items",


                )
            Spacer(modifier = Modifier.height(8.dp))
            Column(
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),

                ) {
                historieItems.forEach { historyItem ->
                    HistoryListItem(
                        routeNumber = historyItem.routeNumber,
                        date = historyItem.date,
                        canEdit = historyItem.canEdit,
                        onShow = { onSHowHistoryItem(historyItem.routeNumber) },
                        onEdit = { onEditHistoryItem(historyItem.routeNumber) },
                    )
                }
            }
        }
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HistoryPreview() {
    TemplateApplicationTheme {
        HistoryPage(
            historieItems = listOf<HistoryItem>(
                HistoryItem("1211145364", Date()),
                HistoryItem("12111445664", Date()),
                HistoryItem("121114231264", Date(), canEdit = false),
            )
        )
    }
}


