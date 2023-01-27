package com.example.weatherapp.ui.widget

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.nikhilchaudhari.library.neumorphic
import me.nikhilchaudhari.library.shapes.Pressed

@Composable
fun WeeklyForeCastCard() {

    Card(
        modifier = Modifier
            .height(64.dp)
            .padding(start = 8.dp),
        backgroundColor = Color.Transparent
           // .clip(RoundedCornerShape(16.dp)),
       // shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column() {
                Text(
                    text = "27-Jan",
                    color = Color.LightGray,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.body2
                )
                Text(
                    text = "Mostly Cloudy",
                    color = Color.LightGray,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.body2
                )
            }

            Icon(
                Icons.Rounded.Add,
                contentDescription=null,
                tint=Color.LightGray
            )

            Column() {
                Text(
                    text = "21",
                    color = Color.LightGray,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.body2
                )

                Text(
                    text = "8",
                    color = Color.LightGray,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}