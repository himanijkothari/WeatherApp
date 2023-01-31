package com.example.weatherapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weatherapp.WeatherViewModel
import com.example.weatherapp.data.model.City
import com.example.weatherapp.ui.theme.Darktheme
import kotlinx.coroutines.launch

@Composable
fun MenuScreen(
    navController: NavController,
    weatherViewModel: WeatherViewModel
) {

    var textState by remember { mutableStateOf("") }
    val coroutinescope = rememberCoroutineScope()
    val cities = remember {
        mutableStateOf(emptyList<City>())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Darktheme)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp,end = 16.dp)
        ) {

            TextField(
                value = textState,
                onValueChange = { value ->
                    textState = value
                    coroutinescope.launch {
                        cities.value = weatherViewModel.getSuggestedCities(textState)!!
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .clip(RoundedCornerShape(8.dp)),
                textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(15.dp)
                            .size(24.dp),
                        tint = Color.Black
                    )
                },
                trailingIcon = {
                    if (textState != "") {
                        IconButton(
                            onClick = {
                                textState =
                                    ""// Remove text from TextField when you press the 'X' icon
                                cities.value = emptyList()
                            }
                        ) {
                            Icon(
                                Icons.Default.Close,
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(15.dp)
                                    .size(24.dp)
                            )
                        }
                    }
                },
                singleLine = true,
                shape = RoundedCornerShape(16.dp), // The TextFiled has rounded corners top left and right by default
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    cursorColor = Color.Black,
                    leadingIconColor = Color.Black,
                    trailingIconColor = Color.Black,
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )

            cities.let { CityList(it.value , navController) }
        }
    }
}


@Composable
fun CityList( cities : List<City> , navController: NavController){

    LazyColumn(modifier = Modifier.fillMaxWidth()) {

        items(cities) { filteredCites ->
            CityListItem(
                cityText = "${filteredCites.name}, ${filteredCites.adminArea.englishName}, ${filteredCites.country.englishName}",
                onItemClick = { selectedCountry ->
                    navController.navigate("Weather/${filteredCites.Key}")
                }
            )
        }
    }
}
@Composable
fun CityListItem(cityText: String, onItemClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = { onItemClick(cityText) })
            .background(Color.White)
            .height(57.dp)
            .fillMaxWidth()
            .padding(PaddingValues(8.dp, 16.dp))
    ) {
        Text(text = cityText, fontSize = 18.sp, color = Color.Black)
    }
}


