package com.example.weatherapp

fun IconMapping(weatherIcon : Int) : Int {

    val iconType = when(weatherIcon){
        1-> R.drawable.day
        2-> R.drawable.day
        3-> R.drawable.day
        4-> R.drawable.day
        5-> R.drawable.day
        6-> R.drawable.mostly_cloudy
        7-> R.drawable.cloudy
        8-> R.drawable.cloudy
        11-> R.drawable.cloudy
        12-> R.drawable.rainy
        13-> R.drawable.rainy
        14-> R.drawable.rainy_1
        15-> R.drawable.rainy
        16-> R.drawable.rainy_1
        17-> R.drawable.rainy_1
        18-> R.drawable.rainy
        19-> R.drawable.rainy
        20-> R.drawable.rainy_1
        21-> R.drawable.rainy_1
        22-> R.drawable.snowy
        23-> R.drawable.snowy
        24-> R.drawable.snowy
        25-> R.drawable.snowy
        26-> R.drawable.snowy
        29-> R.drawable.snowy
        30-> R.drawable.day
        31-> R.drawable.snowy
        32-> R.drawable.cloudy
        33-> R.drawable.night
        34-> R.drawable.night
        35-> R.drawable.cloudy
        36-> R.drawable.cloudy
        37-> R.drawable.cloudy
        38-> R.drawable.cloudy
        39-> R.drawable.rainy
        40-> R.drawable.rainy
        41-> R.drawable.rainy
        42-> R.drawable.rainy
        43-> R.drawable.rainy
        44-> R.drawable.rainy

        else -> {
            R.drawable.weather
        }
    }
    return iconType
}