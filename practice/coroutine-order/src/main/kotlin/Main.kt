package com.example.microspotify.practice.coroutineorder

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

// The same shape as HomeViewModel and HomeRepository in the Android app, without Android.
// There is no Main dispatcher on a plain JVM, so:
// - runBlocking is the "main thread"
// - CoroutineStart.UNDISPATCHED plays the role of Dispatchers.Main.immediate (what
//   viewModelScope uses): the coroutine starts running at once, on the calling thread,
//   until its first suspension point
// - the network request is replaced by a fixed list that arrives after delay(3000)

data class Section(val title: String)

data class HomeUiState(val feed: List<Section>, val isLoading: Boolean)

class HomeRepository {

    suspend fun getHomeSections(): List<Section> = withContext(Dispatchers.IO) {
        log("3")
        delay(3000)
        listOf(Section("Section A"), Section("Section B"))
    }
}

class HomeViewModel(
    private val viewModelScope: CoroutineScope,
    private val repository: HomeRepository
) {
    private val _uiState = MutableStateFlow(HomeUiState(feed = emptyList(), isLoading = true))
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun fetchHomeScreen() {
        log("1")
        viewModelScope.launch(start = CoroutineStart.UNDISPATCHED) {
            log("2")
            // fetch home sections from repository
            val sections = repository.getHomeSections()
            log("4")
            _uiState.value = HomeUiState(feed = sections, isLoading = false)
            println("HomeViewModel: ${_uiState.value}")
        }

        log("6")

        viewModelScope.launch(start = CoroutineStart.UNDISPATCHED) {
            delay(2000)
            val temp = 0
            log("5")
        }
    }
}

private fun log(step: String) {
    println("Coroutine: ${Thread.currentThread().name} $step")
}

fun main() = runBlocking {
    HomeViewModel(this, HomeRepository()).fetchHomeScreen()
}
