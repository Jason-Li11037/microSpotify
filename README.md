# microSpotify

A reproduction of a project I built before.

## Tech stack

- Android app: Kotlin 1.7.0, Android Gradle Plugin 7.4.2, Jetpack Compose (UI 1.3.2,
  Material 1.2.0), Material Components 1.7.0, Navigation 2.5.3, Coil 2.2.2,
  Retrofit 2.9.0 with Gson, Hilt 2.44, ViewModel with coroutines and StateFlow (lifecycle 2.5.1);
  compileSdk 33, minSdk 23
- Backend: Kotlin 1.9.25 on JDK 21, Ktor 2.3.12 (Netty engine, ContentNegotiation,
  kotlinx.serialization JSON)
- Gradle (Groovy DSL for the Android app, Kotlin DSL for the backend and the exercises)

## Project structure

```
.
├── android/                  Android app (Gradle project with one app module)
├── backend/                  Ktor server
│   └── src/main/resources/   feed.json, playlists.json, static/songs/*.mp3
├── practice/
│   ├── kotlin-101/           Standalone Kotlin basics exercise
│   └── coroutine-order/      Standalone exercise about the order coroutines run in
└── README.md
```

## Getting started

### Requirements

- JDK 21 for the backend and the exercises
- JDK 17 and the Android SDK (platform 33, build-tools 30.0.3) for the Android app. A newer JDK
  such as 21 does not work: the annotation processing step (kapt, used by Hilt) fails with an
  `IllegalAccessError`. In Android Studio, set Settings > Build, Execution, Deployment > Build
  Tools > Gradle > Gradle JDK to a JDK 17
- Gradle 8.x, only for the exercises under `practice/` (the backend and the Android
  app ship their own Gradle wrapper)

### Run the backend

```bash
cd backend
./gradlew build
./gradlew run
```

The server listens on `http://0.0.0.0:8080`. Song URLs in the JSON files point
to `http://10.0.2.2:8080`, which is how the Android emulator reaches the host
machine.

### Build the Android app

```bash
cd android
echo "sdk.dir=/path/to/android/sdk" > local.properties
JAVA_HOME=/path/to/jdk-17 ./gradlew assembleDebug
```

The APK is written to `android/app/build/outputs/apk/debug/app-debug.apk`. You can
also open the `android/` folder in Android Studio and run the app on an emulator.
At this stage the app shows a bottom navigation bar with the Home screen and a placeholder
Favorite screen. When it starts it also requests the home feed from the backend
(`GET /feed` through `10.0.2.2:8080`) and writes the response to Logcat with the tag
`lifecycle`. The Home tab is written with Jetpack Compose (a `ComposeView` inside
`HomeFragment`, dark colors). It loads the same feed through `HomeViewModel` and
`HomeRepository`, logs the resulting state with the tag `HomeViewModel`, shows "Screen is
loading..." and then one row of album covers per section. The repository waits 3 seconds
before the request on purpose, so the loading text is visible. The covers are downloaded from
the internet, so the emulator needs network access. Start the backend before the app: the
requests have no error handling, so the app crashes when the server is not running. Plain
HTTP is allowed for `10.0.2.2` only (`network_security_config.xml`).

### Run the exercises

```bash
cd practice/kotlin-101
gradle run

cd ../coroutine-order
gradle run
```

`coroutine-order` prints the steps of a view model and a repository in the order they run;
see its README for the expected output.

## API

| Method | Path | Description |
|---|---|---|
| GET | `/` | Plain text `Hello World!` |
| GET | `/feed` | Home feed: a list of sections, each with its albums |
| GET | `/playlists` | All playlists |
| GET | `/playlist/{id}` | The playlist with the given id, or the JSON literal `null` |
| GET | `/songs/{file}` | A placeholder mp3 file (short sine tones) |

## Progress

- [x] Backend: routes, feed, playlists and songs
- [x] Kotlin 101 exercise
- [x] Android app skeleton, lifecycle and Compose basics
- [x] Bottom navigation
- [x] Retrofit and Hilt
- [x] Home repository and view model
- [x] Home screen
- [ ] Playlist screen
- [ ] Favorites with Room
- [ ] Player
