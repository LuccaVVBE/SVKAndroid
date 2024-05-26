@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.svkapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.svk.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SvkLoginComposable(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextField(
            value = "",
            onValueChange = {},
            label = {
                Text(stringResource(R.string.login_user))
            },
            placeholder = {
                Text(stringResource(R.string.login_placeholder_user))
            },
            modifier = modifier
                .requiredWidth(350.dp)
                .heightIn(min = 56.dp)
        )
        Spacer(modifier = Modifier.height(48.dp))
        TextField(
            value = "",
            onValueChange = {},
            label = {
                Text(stringResource(R.string.login_password))
            },
            modifier = modifier
                .requiredWidth(350.dp)
                .heightIn(min = 56.dp)
        )
        Spacer(modifier = Modifier.height(48.dp))
        Button(
            onClick = { },
            modifier = modifier.requiredWidth(350.dp)
        ) {
            Text(text = stringResource(R.string.login_naam))
        }
    }
}

@Composable
fun SvkLoginScreen(modifier: Modifier = Modifier) {
    SvkLoginComposable()
}

@ExperimentalMaterial3Api
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview()
fun LoginPage(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { SvkTopNavigationComposable(modifier, "") }
    ) { padding ->
        SvkLoginScreen(Modifier.padding(padding))
    }
}

