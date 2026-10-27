package com.example.microspotify.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.microspotify.R

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    HomeScreenContent()
}

@Composable
fun HomeScreenContent() {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        item {
            HomeScreenHeader()
        }
    }
}

@Composable
fun HomeScreenHeader() {
    Column {
        Text(
            text = stringResource(id = R.string.menu_home),
            style = MaterialTheme.typography.h4,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}
