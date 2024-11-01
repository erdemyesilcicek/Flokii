package com.erdemyesilcicek.flokii.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoFixHigh
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.erdemyesilcicek.flokii.bar.AppBar
import com.erdemyesilcicek.flokii.datas.Card
import com.erdemyesilcicek.flokii.datas.ExtendedFAB

@Composable
fun MyTalesScreen(navController: NavController) {
    var cards = listOf(
        Card(navController), Card(navController),
        Card(navController), Card(navController),
        Card(navController), Card(navController)
    )

    Scaffold(
        topBar = { AppBar(isHomeScreen = true, "My Tales", navController) },
        modifier = Modifier.fillMaxSize(),

        floatingActionButton = {
            ExtendedFAB(
                MaterialTheme.colorScheme.primary,
                Icons.Rounded.AutoFixHigh,
                "Create a tale icon",
                " Create Tale",
                onClick = {
                    navController.navigate("CreateTaleScreen")
                })
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LazyColumn(
                modifier = Modifier.padding(10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(cards.size) { card ->
                    Card(navController)
                }
            }
        }
    }
}
