# microSpotify

A reproduction of a project I built before.

## Tech stack

- Kotlin 1.9.25 on JDK 21
- Ktor 2.3.12 (Netty engine, ContentNegotiation, kotlinx.serialization JSON)
- Gradle with the Kotlin DSL

## Project structure

```
.
├── backend/                  Ktor server
│   └── src/main/resources/   feed.json, playlists.json, static/songs/*.mp3
├── practice/
│   └── kotlin-101/           Standalone Kotlin basics exercise
└── README.md
```

## Getting started

### Requirements

- JDK 21
- Gradle 8.x, only for the exercises under `practice/` (the backend ships its
  own Gradle wrapper)

### Run the backend

```bash
cd backend
./gradlew build
./gradlew run
```

The server listens on `http://0.0.0.0:8080`. Song URLs in the JSON files point
to `http://10.0.2.2:8080`, which is how the Android emulator reaches the host
machine.

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
- [ ] Android app skeleton, lifecycle and Compose basics
- [ ] Bottom navigation
- [ ] Retrofit and Hilt
- [ ] Home screen
- [ ] Playlist screen
- [ ] Favorites with Room
- [ ] Player
