package com.example.wishlistapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    title: String,
    onBackClick: () -> Unit
) {
    val navigationIcon: (@Composable () -> Unit) = {
        IconButton(onClick = onBackClick) {
            Icon(
                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                contentDescription = null,
                tint = Color.White
            )
        }
    }

    TopAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        title = {
            Text(
                text = title,
                color = Color.White,
                fontSize = 18.sp,
                lineHeight = 22.sp
            )
        },
        colors = TopAppBarDefaults.topAppBarColors().copy(containerColor = colorResource(
            id = R.color.app_bar_color
        )),
        navigationIcon = navigationIcon,
    )
}