package com.example.svkapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.svk.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeItemCard(
    modifier: Modifier = Modifier,
    name: String = "",
    description: String = "",
    icon: Painter,
    onClick: () -> Unit = {},
) {
    Card(
        modifier = Modifier.fillMaxWidth(), border = BorderStroke(1.dp, Color.Black),
        onClick = onClick

    ) {
        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(2f)) {
                Text(
                    text = name,
                    modifier = modifier,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = description, modifier = modifier, fontSize = 16.sp)
            }
            Icon(
                icon,
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .size(64.dp)
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    onNewControlClick: () -> Unit = {},
    onHistoryClick: () -> Unit = {},
    onLogin: () -> Unit = {},
) {
    Scaffold(
        topBar = {
            SvkTopNavigationComposable(
                modifier = Modifier,
                onLogin = onLogin
            )
        },
    ) { innerPadding ->
        Box(Modifier.padding(innerPadding)) {
            Column(modifier = Modifier.padding(24.dp)) {
                Spacer(modifier = Modifier.height(64.dp))
                Text(text = "Welkom Nico", fontSize = 32.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(120.dp))

                HomeItemCard(
                    name = "Nieuwe Controle",
                    description = "Voer een nieuwe controle uit.",
                    icon = painterResource(id = R.drawable.baseline_edit_note_24),
                    onClick = onNewControlClick
                )
                Spacer(modifier = Modifier.height(32.dp))
                HomeItemCard(
                    name = "Controle historiek",
                    description = "Bekijk voorgaande controles.",
                    icon = painterResource(id = R.drawable.baseline_history_24),
                    onClick = onHistoryClick
                )
            }
        }
    }

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeApp() {
    HomePage()
}