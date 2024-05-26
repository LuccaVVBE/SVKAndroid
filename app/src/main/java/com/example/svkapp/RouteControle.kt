package com.example.layout1


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.svkapp.RouteControleViewModel
import com.example.svkapp.SvkTopNavigationComposable
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
private fun BottomBar(
    onSave: () -> Unit = { },
) {
    BottomAppBar {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        )
        {
            ElevatedButton(
                onClick = { onSave() },

                modifier = Modifier
                    .padding(16.dp),

                ) {
                Text(text = "Opslaan")
                Icon(
                    Icons.Filled.Check,
                    contentDescription = "Opslaan",
                )
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListCard(
    list: List<String>,
    onEdit: (id: String) -> Unit = {},
    //onShowLaadbon: (id: String) -> Unit= {},
    //list<String> -> List<laadbon>
)                //list<String> -> List<laadbon>
{

    for (laadbon in list) {
        ListItem(
            headlineText = { Text(laadbon) },
            trailingContent = {
                Icon(
                    Icons.Filled.Delete,
                    contentDescription = "Delete",
//                        modifier = Modifier
//                            .clickable { onEdit(laadbon) }
                )
            },

            //TODO ask if this is the right way to do this - Als het werkt is het ok
            modifier = Modifier.clickable { onEdit(laadbon) }
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ControllePage(

    routeControleVM: RouteControleViewModel = viewModel(),
    onAddLaadbon: () -> Unit = {},
    onShowLaadbon: (id: String) -> Unit = {},
    onSave: () -> Unit = { },
    onBack: () -> Unit = {}
) {
    val routeControleState by routeControleVM.uiState.collectAsState()
    Scaffold(
        topBar = {
            SvkTopNavigationComposable(onBackButton = onBack)
        },
        bottomBar = {
            BottomBar(onSave)
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding))
        {
            Column(
                verticalArrangement = Arrangement.spacedBy(14.dp),
                modifier = Modifier.padding(35.dp),
            ) {

                OutlinedTextField(
                    value = routeControleState.routeNummer,
                    onValueChange = { routeControleVM.setRouteNummer(it)  },
                    label = { Text("RouteNummer") },

                    singleLine = true
                )
                OutlinedTextField(
                    value = routeControleState.transporteur,
                    onValueChange = { routeControleVM.setTransporteur(it) },
                    label = { Text("Transporteur") },
                    singleLine = true
                )
                OutlinedTextField(
                    value = routeControleState.nummerPlaat,
                    onValueChange = { routeControleVM.setNummerplaat(it)},
                    label = { Text("NummerPlaat") },
                    singleLine = true
                )
            }

            OutlinedCard(
                border = BorderStroke(1.dp, Color.Gray),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
            ) {
                Text(
                    text = "Laadbonnen",
                    modifier = Modifier
                        .padding(16.dp),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                )
                ListCard(routeControleState.laadbonnen, onEdit = onShowLaadbon)
                Column(
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    ElevatedButton(
                        onClick = onAddLaadbon,
                        modifier = Modifier
                            .padding(4.dp),

                        ) {

                        Icon(
                            Icons.Filled.Add,
                            contentDescription = "Add",
                        )
                    }
                }

            }
        }
    }


}

