package com.erdemyesilcicek.flokii.pages.settingspages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.erdemyesilcicek.flokii.R
import com.erdemyesilcicek.flokii.bar.AppBar
import com.erdemyesilcicek.flokii.createtalesections.TextSection
import com.erdemyesilcicek.flokii.customitems.ExtendedFAB
import com.erdemyesilcicek.flokii.customitems.RadioButtonGroup
import com.erdemyesilcicek.flokii.customitems.TextInputExample
import com.erdemyesilcicek.flokii.datas.font.myFont

@Composable
fun FamilyInformation(
    navController: NavController
) {
    Scaffold(
        topBar = {
            AppBar(
                isEnableBackButton = false,
                isEnableBarButton = true,
                "",
                navController
            )
        },
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            ExtendedFAB(
                MaterialTheme.colorScheme.primary,
                //Icons.Rounded.SaveAlt,
                "Button that saves of the main character",
                "Save",
                onClick = {
                    println("Save fab clicked")
                })
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logoapp),
                contentDescription = "",
                contentScale = ContentScale.Fit
            )
            Text(
                modifier = Modifier.padding(5.dp),
                text = "Family Information",
                fontFamily = FontFamily.Default,
                fontSize = 22.sp
            )
            LazyColumn(
                modifier = Modifier,
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(1) {
                    //TextInputExample("Language", "Enter Language")
                    TextSection(title = "Language")
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        var selectedOption by remember { mutableStateOf("Option 1") }
                        val options = listOf("English", "German", "Turkish")

                        RadioButtonGroup(
                            options = options,
                            selectedOption = selectedOption,
                            onOptionSelected = { selectedOption = it }
                        )
                    }
                    TextInputExample("Name", "Enter Name", true)
                    TextInputExample("Age", "Enter Age", true)
                    TextInputExample("Gender", "Enter Gender", true)
                    TextInputExample("Dad's Name", "Enter Dad's Name", true)
                    TextInputExample("Mom's Name", "Enter Mom's Name", true)
                    TextInputExample("Sis's Name", "Enter Sis's Name", true)

                    Spacer(modifier = Modifier.padding(40.dp))

                    Row(
                        modifier = Modifier.fillParentMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Created by Erdem",
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = myFont,
                            color = Color.LightGray
                        )
                    }
                }
            }
        }
    }
}