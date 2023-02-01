# WeatherApp

## :scroll: Description
 * This App enables users to get weather information for the specific location.
 * Based on [Jetpack Compose](https://developer.android.com/jetpack/compose) and [accuWeather API](https://developer.accuweather.com/apis)
 
## :bulb: Motivation and Context
<img
    src="app/src/main/res/drawable-nodpi/icons8_weather_48.png"
    align="left"
    width="190"
    hspace="10"
    vspace="10" />

**What am I proud of?**
- Split UI and logic
- "Useful" app
   - -> Real data forecast
   - -> Persistence of the forecast
   - -> Change your City 


#### Brief overview:

The App contains below mentioned screens.

* Home Screen:
   * You can find search field in Home screen.
   * You can search for any location by typing it in search field.
   * It will show you suggestions as per your input and you will able to select your location from suggestion.

* Weather Screen:
   * User can find different weather details in this screen.

* ForeCast Screen:
   * User can find forecast for next 5 days in this screen.

   
# Technologies

* Kotlin - %100 Kotlin, No XML
* Jetpack Compose for Declarative UI
* Coroutines for asynchronous operations
* ViewModel
* Dagger Hilt for Dependency Injection
* OkHttp and Retrofit for network operations
