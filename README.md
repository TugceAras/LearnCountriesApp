# <p align="center"> Learn Countries :earth_africa: </p>

<!-- Screenshot -->
<p align="center">
  <img src="https://user-images.githubusercontent.com/79931228/211907292-6e59c2fd-c0f4-49b8-9284-ab8b18fab52a.png"/>
  <img src="https://user-images.githubusercontent.com/79931228/211907296-d4623862-02db-4e66-bc62-6882b4e0a572.png"/>
  <img src="https://user-images.githubusercontent.com/79931228/211907303-b7db8278-2731-422e-94bc-cba5010928ff.png"/> <br>
</p>
<br><br>

<!-- Technologies -->
## 👇 Used Technologies
#### - Navigation
#### - ViewModel
#### - Retrofit
#### - Room
#### - Databinding
#### - RxJava
#### - Glide
#### - Coroutine

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

