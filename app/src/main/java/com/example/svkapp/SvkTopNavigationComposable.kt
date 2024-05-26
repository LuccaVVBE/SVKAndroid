package com.example.svkapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.svk.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SvkTopNavigationComposable(
    modifier: Modifier = Modifier,
    title: String = "",
    onLogin: () -> Unit = { },
    onBackButton: (() -> Unit)? = null,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(
                text = title,
                modifier = modifier.padding(start = 15.dp)
            )
        },
        navigationIcon = {
            if (onBackButton != null) {

                IconButton(modifier = Modifier.size(60.dp), onClick = { onBackButton() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null,
                        modifier = modifier.size(size = 60.dp),
                    )
                }
            } else {
                IconButton(modifier = Modifier.size(120.dp), onClick = { }) {
                    Image(
                        painter = painterResource(R.drawable.svk_logo),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                    )
                }
            }
        },
        actions = {
            IconButton(modifier = Modifier.size(60.dp), onClick = { onLogin() }) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = null,
                    modifier = modifier.size(size = 60.dp),
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}