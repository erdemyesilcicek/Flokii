package com.erdemyesilcicek.flokii.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erdemyesilcicek.flokii.R
import com.erdemyesilcicek.flokii.datas.DataCardSection
import com.erdemyesilcicek.flokii.datas.myFont

val familyCards = listOf(
    DataCardSection(
        R.drawable.familydad,
        "Dad"
    ),
    DataCardSection(
        R.drawable.familymom,
        "Mom"
    ),
    DataCardSection(
        R.drawable.familysis,
        "Sis"
    )
)

@Preview
@Composable
fun FamilySection() {
    LazyRow {
        items(familyCards.size) { index ->
            FamilyCardItem(index)
        }
    }
}

@Composable
fun FamilyCardItem(index: Int) {
    val card = familyCards[index]

    val image = card.image
    val text = card.text

    val myButtonColor = colorScheme.primary
    var buttonColor by remember { mutableStateOf(Color.White) }

    val myTextColor = colorScheme.primary
    var textColor by remember { mutableStateOf(Color.Gray) }

    Column(
        modifier = Modifier
            .padding(start = 10.dp, 5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(start = 10.dp, 5.dp)
        ) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .width(100.dp)
                    .height(100.dp)
                    .background(buttonColor),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(image),
                    contentDescription = "logos",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clickable(
                            enabled = true,
                            onClickLabel = "Clickable Image",
                            onClick = {
                                if (text == "Dad") {
                                    buttonColor =
                                        if (buttonColor == Color.White) myButtonColor else Color.White
                                    textColor =
                                        if (textColor == Color.Gray) myTextColor else Color.Gray
                                    println("Dad Clicked")
                                } else if (text == "Mom") {
                                    buttonColor =
                                        if (buttonColor == Color.White) myButtonColor else Color.White
                                    textColor =
                                        if (textColor == Color.Gray) myTextColor else Color.Gray
                                    println("Mom Clicked")
                                } else if (text == "Sis") {
                                    buttonColor =
                                        if (buttonColor == Color.White) myButtonColor else Color.White
                                    textColor =
                                        if (textColor == Color.Gray) myTextColor else Color.Gray
                                    println("Sis Clicked")
                                }
                            }
                        )
                )
            }
        }
        Text(
            modifier = Modifier.padding(start = 10.dp),
            text = text,
            color = textColor,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            fontFamily = myFont
        )
    }
}