package com.example.puppiesss.composable

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun PuppiesTopBar(title: String) {
    TopAppBar(title = {
        Text(title)
    })
}
