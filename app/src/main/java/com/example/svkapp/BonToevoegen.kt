package com.example.svkapp

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier, title: String, onSave: () -> Unit = { },
    onCancel: () -> Unit = { }
) {
    CenterAlignedTopAppBar(title = {
        Text(
            text = title,
            fontSize = 24.sp
        )

    },
        navigationIcon = {
            Icon(Icons.Filled.Close, null,
                Modifier
                    .padding(start = 4.dp)
                    .clickable { onCancel() })
        },
        actions = {
            OpslaanButton(onSave)
        }

    )
}

@Composable
fun OpslaanButton(onSave: () -> Unit) {
    val context = LocalContext.current
    TextButton(onClick = { ShowToastOpslaan(context, "Laadbaan is opgeslagen!"); onSave() }) {
        Text(
            text = stringResource(com.example.svk.R.string.opslaan),
            color = Color.Red
        )
    }
}

fun ShowToastOpslaan(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LaadbonInputField(
    name: String = "",
    icon: Painter,
    startValue: String = "",
    modifier: Modifier = Modifier,
    isNew: Boolean
) {
    var text by remember { mutableStateOf(startValue) }


    Row {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text(name) },
                trailingIcon = {
                    if (isNew)
                        Icon(
                            icon, contentDescription = null, modifier = Modifier
                                .weight(1f)
                                .size(40.dp)

                        )
                    else null
                }
            )


        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdresInputField(
    name: String,
    modifier: Modifier = Modifier,
    value: String = ""
) {
    var text by remember { mutableStateOf(value) }


    Row {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text(name) }
            )

        }
    }


}

@Composable
fun Pictures(icon: Painter, modifier: Modifier = Modifier) {
    Row(modifier = Modifier.height(150.dp)) {
        Column {
            Icon(
                icon,
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .size(200.dp)

            )
        }
        Column {
            Icon(
                icon,
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .size(200.dp)

            )
        }
    }
    Row(modifier = Modifier.height(150.dp)) {
        Column {
            Icon(
                icon,
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .size(200.dp)

            )
        }
        Column {
            Icon(
                icon,
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .size(200.dp)

            )
        }
    }

}

fun ShowToastFoto(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Composable
fun AddPictureButton(modifier: Modifier = Modifier, icon: Painter) {
    val context = LocalContext.current

    Button(
        onClick = { ShowToastFoto(context, "foto's succesvol toegevoegd!") },
        colors = ButtonDefaults.buttonColors(Color.Red),
        modifier = modifier
            .height(80.dp)
            .width(80.dp),
        shape = RoundedCornerShape(
            topStart = 20.dp,
            topEnd = 20.dp,
            bottomStart = 20.dp,
            bottomEnd = 20.dp
        )
    ) {
        Icon(
            icon,
            contentDescription = null,
            modifier = Modifier
                .weight(1f)
                .size(80.dp)

        )
    }
}

@Composable
fun BonToevoegen(
    modifier: Modifier = Modifier,
    isNew: Boolean,
    laabonNumber: String,
    Adres: String,
) {
    Column(modifier) {
        Spacer(modifier = Modifier.height(20.dp))
        LaadbonInputField(
            name = stringResource(com.example.svk.R.string.laadbonnummer),
            icon = painterResource(id = com.example.svk.R.drawable.barcode),
            isNew = isNew,
            startValue = laabonNumber

        )
        Spacer(modifier = Modifier.height(20.dp))
        AdresInputField(
            name = stringResource(com.example.svk.R.string.adres),
            value = Adres
        )
        Spacer(modifier = Modifier.height(60.dp))
        Pictures(icon = painterResource(id = com.example.svk.R.drawable.placeholder))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom
        ) {
            AddPictureButton(icon = painterResource(id = com.example.svk.R.drawable.add_image_photo_icon))
        }

    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun RouteBonPage(
    onSave: () -> Unit = { },
    onCancel: () -> Unit = { },
    isNew: Boolean = false,
) {
    Scaffold(
        topBar = {
            TopBar(
                title = if (isNew) stringResource(com.example.svk.R.string.edit_laadbon) else stringResource(
                    com.example.svk.R.string.voeg_laadbon_toe
                ), onSave = onSave, onCancel = onCancel
            )
        },
    ) { paddingValues ->
        BonToevoegen(
            isNew = isNew,
            laabonNumber = "1919191",
            Adres = "sdfsdfqs",
            modifier = Modifier.padding(paddingValues)
        )

    }
}
