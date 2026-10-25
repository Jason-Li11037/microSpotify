# Coroutine order

A small standalone exercise about the order in which coroutines run. It has the same
shape as `HomeViewModel` and `HomeRepository` in the Android app, but runs on a plain JVM.

It is independent of the Android app and the backend and has no Gradle wrapper.

## Requirements

- JDK 21
- Gradle 8.x

## Run

```bash
cd practice/coroutine-order
gradle run
```

## What it prints

Every line shows the thread name and a step number. The typical output is:

```
Coroutine: main 1
Coroutine: main 2
Coroutine: main 6
Coroutine: DefaultDispatcher-worker-1 3
Coroutine: main 5
Coroutine: main 4
HomeViewModel: HomeUiState(feed=[Section(title=Section A), Section(title=Section B)], isLoading=false)
```

The steps run in the order 1, 2, 6, 3, 5, 4:

- `1` and `2` run straight away on the main thread. The first coroutine starts running at
  once and stops at `withContext(Dispatchers.IO)`.
- `6` runs next on the main thread, because the first coroutine is suspended while its work
  moves to an IO thread.
- `3` runs on an IO thread. It runs about at the same time as `6`, so their order depends on
  thread scheduling; `6` first is the usual result.
- `5` appears after 2 seconds, `4` after 3 seconds, because `4` waits for the work in
  `getHomeSections()` to finish.

## Differences from the Android code

- There is no `Dispatchers.Main` on a plain JVM. `runBlocking` stands in for the main thread
  and `CoroutineStart.UNDISPATCHED` stands in for `Dispatchers.Main.immediate`.
- `println` replaces `Log.d`.
- The network request is replaced by a fixed list that is returned after `delay(3000)`.
