package com.example.weatherapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.theme.Blue100
import com.example.weatherapp.ui.theme.Darktheme

@Composable
fun WeatherScreen(){
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Darktheme)
    ) {
        Column(
            modifier = Modifier
                .padding(top = 32.dp, start = 16.dp, end = 16.dp, bottom = 32.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row() {
                    Icon(
                        Icons.Filled.LocationOn,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = Color.White
                    )
                    Text(
                        text = "Secunderabad, Telangana",
                        color = Color.LightGray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.subtitle2
                    )
                }

               /* Canvas(modifier = Modifier.size(50.dp), onDraw = {
                    drawCircle(color = Color.Yellow)
                })*/
            }

            Row() {
                Column(
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Text(
                        text = "28",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h1

                    )
                    Text(
                        text = "Sunny",
                        color = Color.Blue
                    )
                    Text(
                        text = "Last updated : 9:00 PM",
                        color = Color.White
                    )
                }
            }
        }

        Divider(
            color = Blue100,
            modifier = Modifier
                .height(1.dp)
        )

        Column(
            modifier = Modifier
                .padding(top = 32.dp, start = 32.dp, end = 16.dp, bottom = 32.dp)
                .fillMaxWidth()
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column() {
                    Text(
                        text = "Chances of rain:",
                        color = Color.LightGray,
                        style = MaterialTheme.typography.subtitle2
                    )
                    Text(
                        text = "16%",
                        color = Color.White,
                        style = MaterialTheme.typography.h5
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(
                        text = "Wind:",
                        color = Color.LightGray,
                        style = MaterialTheme.typography.subtitle2
                    )
                    Text(
                        text = "1.2 km/hr",
                        color = Color.White,
                        style = MaterialTheme.typography.h5
                    )
                }
                
                Spacer(modifier = Modifier.width(80.dp))

                Column() {
                    Text(
                        text = "Precipitation",
                        color = Color.LightGray,
                        style = MaterialTheme.typography.subtitle2
                    )
                    Text(
                        text = "28%",
                        color = Color.White,
                        style = MaterialTheme.typography.h5
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(
                        text = "Humidity:",
                        color = Color.LightGray,
                        style = MaterialTheme.typography.subtitle2
                    )
                    Text(
                        text = "52%",
                        color = Color.White,
                        style = MaterialTheme.typography.h5
                    )
                }
            }
        }
        
    }
}