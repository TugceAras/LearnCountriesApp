# <p align="center"> Learn Countries :earth_africa: </p>

<!-- Screenshot -->
<p align="center">
  <img src="https://user-images.githubusercontent.com/79931228/211910257-648808c1-6ef1-47f6-ad63-ae629904eba8.png"/>
  <img src="https://user-images.githubusercontent.com/79931228/211910262-8b74a605-168b-4ae8-ae06-1c3f046f56ce.png"/>
  <img src="https://user-images.githubusercontent.com/79931228/211910263-4e6ff8ee-fd2b-4337-ab53-9f38158f48e4.png"/> <br>
</p>
<br><br>

<!-- Technologies -->
## 👇 Used Technologies
#### - Navigation
#### - Retrofit
#### - Room
#### - Databinding
#### - RxJava
#### - Glide
#### - Coroutine
(MVVM architecture is used)

<!-- Dependencies -->
## :pencil2: Dependency
```
    // Navigation
    def nav_version = "2.5.3"
    implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
    implementation "androidx.navigation:navigation-ui-ktx:$nav_version"

    // Retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.squareup.retrofit2:adapter-rxjava3:2.9.0'

    // Coroutine
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4'

    // Glide
    implementation 'com.github.bumptech.glide:glide:4.14.2'

    // RxJava
    implementation 'io.reactivex.rxjava3:rxandroid:3.0.2'
    implementation 'io.reactivex.rxjava3:rxjava:3.1.5'

    // Room
    def room_version = "2.4.3"
    implementation "androidx.room:room-runtime:$room_version"
    annotationProcessor "androidx.room:room-compiler:$room_version"
    kapt "androidx.room:room-compiler:$room_version"
    implementation "androidx.room:room-rxjava3:$room_version"
    implementation "androidx.room:room-ktx:$room_version"

    // SwipeRefreshLayout
    implementation "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"

    // Lifecycle
    implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'

    // Preference
    implementation "androidx.preference:preference-ktx:1.2.0"
```

app build.gradle:

```
plugins {
    id 'kotlin-kapt'
    id 'androidx.navigation.safeargs.kotlin'
}

buildFeatures {
     dataBinding true
 }
```
project build.gradle

```
id 'androidx.navigation.safeargs' version '2.5.3' apply false
```

<!-- Manifest File -->
## :exclamation: Manifest File
```
<uses-permission android:name="android.permission.INTERNET" />
```

