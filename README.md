# microSpotify

A reproduction of a project I built before.

## Tech stack

- Android app: Kotlin 1.7.0, Android Gradle Plugin 7.4.2, Jetpack Compose (UI 1.3.2,
  Material 1.2.0), Coil 2.2.2; compileSdk 33, minSdk 23
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
│   └── kotlin-101/           Standalone Kotlin basics exercise
└── README.md
```

## Getting started

### Requirements

- JDK 21 for the backend and the exercises
- JDK 17 and the Android SDK (platform 33, build-tools 30.0.3) for the Android app
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
At this stage the app shows one album cover loaded from the web and does not call the
backend yet.

### Run the Kotlin 101 exercise

```bash
cd practice/kotlin-101
gradle run
```

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
- [ ] Bottom navigation
- [ ] Retrofit and Hilt
- [ ] Home screen
- [ ] Playlist screen
- [ ] Favorites with Room
- [ ] Player
