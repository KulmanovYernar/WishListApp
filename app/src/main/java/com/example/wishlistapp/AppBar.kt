package com.example.wishlistapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    title: String,
    onBackClick: () -> Unit
) {
    TopAppBar(
        modifier = Modifier
            .padding(start = 4.dp)
            .heightIn(max = 24.dp)
            .background(
                color = colorResource(
                    id = R.color.app_bar_color
                )
            ),
        title = {
            Text(
                text = title,
                color = colorResource(id = R.color.white)
            )
        },
        navigationIcon = {

        }
    )
}