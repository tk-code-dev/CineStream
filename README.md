# CineStream

### This is a demo application built with the goal to create a fun and challenging application using TMDB api.

- Clean Architecture + MVVM: This refers to the overall architecture pattern used in the app, which follows the Clean Architecture principles and implements the Model-View-ViewModel (MVVM) design pattern.

- Single Activity Pattern: The UI of the app consists of a single Activity and multiple Fragments.

- The App gets Movie info via a RESTful API https://www.themoviedb.org/documentation/api?language=en-CA

# ![image](https://user-images.githubusercontent.com/54562350/234645048-3deb40a4-098a-4953-923b-0d84540f0ab7.png)  How to use 

Users can obtain a list of the latest movies, TV shows, and popular actors through the bottom navigation. The detail screen includes release date, length, rating, overview, and site link.

***
# Screenshots
<p float="left">  
 sorting by name, population, area
  
<img src="https://user-images.githubusercontent.com/54562350/234634077-98db4274-f081-4b95-94f9-77d6ad2b1b37.png"  width="200" height="400"/>

<img src="https://user-images.githubusercontent.com/54562350/234633884-9c785e83-0c81-48ba-92a0-1ee4342f5f4d.png"  width="200" height="400"/>

<img src="https://user-images.githubusercontent.com/54562350/234634057-77cfcfaa-b874-47ea-9c13-2a9d4eabd646.png"  width="200" height="400"/>
   
</p>

<p float="left">
detail page, bookmarked countries
  
<img src="https://user-images.githubusercontent.com/54562350/234633485-f9da2088-0659-4394-b724-f3a340008424.png"  width="200" height="400"/>
  
<img src="https://user-images.githubusercontent.com/54562350/234639540-470e9910-9a7a-4276-8359-733241bac84d.png"  width="200" height="400"/>
  
<img src="https://user-images.githubusercontent.com/54562350/234628939-84dc9ab0-8e99-4802-8b1b-485fa116bdaa.png" width="200" height="400"/>
  
</p>

***
# ![image](https://user-images.githubusercontent.com/54562350/234645282-c050da5e-c71c-4484-b589-c4aac61aa811.png) Development Frameworks and Libraries
  - Hilt:  Dependency injection library for Android that is built on top of Dagger 2. 
  
  - Coroutines: Managing asynchronous tasks
  
  - Data Binding: Binding UI elements directly to data sources in a declarative manner.

  - LiveData: Observable data holder class that is part of the Android Architecture Components and is used to notify views when the underlying data changes.

  - Navigation: Moving between different screens and handling back button presses.

  - ViewModel: Storing and managing UI-related data in a lifecycle-conscious way.
 
  - Material Design: A set of guidelines for designing Android apps. 

  - Animations & Transitions: Moving UI widgets and transition between screens in a smooth and visually appealing manner.

***

- Retrofit2 - A type-safe HTTP client for Android and Java
- Gson - A Java serialization/deserialization library to convert Java Objects into JSON and back
- Glide - A powerful image downloading and caching library for Android
- okhttp3:logging-interceptor - Logs HTTP requests and responses for debugging purposes
