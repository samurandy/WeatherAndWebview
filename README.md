<h1 align="center">WeatherAndWebview</h1>

<p align="center">  
WeatherAndWebview is an application based on modern Android application tech-stacks using MVVM pattern and Clean Architecture.<br>
</p>
</br>


## Functionality
- Ask for the current weather and the next three days.
- Navigate through a website.


## Tech stack & Open-source libraries
- Minimum SDK level 23
- [Kotlin](https://kotlinlang.org/) based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) for asynchronous.
- JetPack
  - StateFlows - dispose of observing data when lifecycle state changes.
  - ViewModel - UI related data holder, lifecycle aware.
- Architecture
  - MVVM Pattern (View - ViewBinding - ViewModel - Model)
  - Clean Architecture
  - [DaggerHilt](https://github.com/google/dagger/tree/master/java/dagger/hilt) - dependency injection.
  - Navigation Component
- [Retrofit2 & Gson](https://github.com/square/retrofit) - construct the REST APIs.
- [Glide](https://github.com/bumptech/glide) - loading images.
- ViewPager - slide between fragments.
- Tablayout - provides a horizontal layout to display tabs.


# License
```xml
Designed and developed by samurandy (Andrés Carrasco) 2022
