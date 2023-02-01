package com.example.weatherapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.ui.Navigation.WeatherNavGraph

@Composable
fun WeatherAppContent(weatherViewModel: WeatherViewModel) {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val bottomTabRoutes = listOf(Weather, Menu)
    
    Scaffold(
       /* bottomBar = { BottomAppBar(
            modifier = Modifier
                // .padding(vertical = 4.dp, horizontal = 24.dp)
                .height(88.dp)
                .clip(RoundedCornerShape(16.dp)),
            elevation = 0.dp,
            backgroundColor = Darktheme
        ){
            bottomTabRoutes.forEach { screen ->
                NavButton(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    screens = screen,
                    selected = screen.route == currentRoute
                ) {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                }
            }
        } }*/
    ) {
        WeatherNavGraph(navController, weatherViewModel)
    }
}

@Composable
fun NavButton(
    modifier: Modifier = Modifier,
    screens: Screens,
    selected : Boolean = false,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .padding(8.dp)
            .size(82.dp)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = onClick
            )
    ) {
        Column(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 4.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val color = if (selected) Color.Blue else Color.DarkGray
            Icon(
                Icons.Filled.LocationOn,
                null,
                tint = color,
                modifier = Modifier.size(24.dp, 24.dp)
            )
            Text(
                text = stringResource(id = screens.resourceId),
                color = color,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.button.copy(fontSize = 12.sp, color = color)
            )
        }
    }
}