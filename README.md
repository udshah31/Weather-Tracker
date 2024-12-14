/**
 * Weather Tracker App Description:
 *
 * Weather Tracker is a simple and intuitive weather application built using Kotlin and Jetpack Compose.
 * The app enables users to search for and view the current weather of a city, including key details:
 * - City Name
 * - Current Temperature
 * - Weather Condition with an Icon
 * - Humidity Percentage
 * - UV Index Value
 * - "Feels like" Temperature
 *
 * The selected city's weather data is persisted locally using SharedPreferences or DataStore,
 * ensuring that users see the saved city's weather upon relaunching the app.
 *
 * Key Features:
 * 1. **Home Screen**: Displays weather details for a single saved city with a search bar to update the city.
 * 2. **Search Functionality**: Allows users to search for a city's weather using WeatherAPI.com.
 * 3. **Error Handling**: Gracefully handles invalid inputs and network issues.
 * 4. **Persistence**: Saves the selected city and reloads its weather on app startup.
 *
 * The app adheres to modern development principles:
 * - **MVVM Architecture** for clean separation of concerns.
 * - **Dependency Injection** using Hilt or Koin.
 * - **Modular Code** ensuring testability and maintainability.
 *
 * Weather Tracker delivers a user-friendly experience with a clean UI closely aligned to provided Figma designs,
 * offering users accurate and reliable weather information.
 */
