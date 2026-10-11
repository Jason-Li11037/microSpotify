package com.example.microspotify

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.microspotify.ui.theme.MicroSpotifyTheme

// customized extend AppCompatActivity
class MainActivity : AppCompatActivity() {

    private val TAG = "lifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        setContent {
            MicroSpotifyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "We are at onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "We are at onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "We are at onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "We are at onStop()")
    }

    override fun onDestroy() {
        Log.d(TAG, "We are at onDestroy()")
        super.onDestroy()
    }
}

// @Composable == react Component
@Composable
fun Greeting(name: String) {
    // react: return { jsx }
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(24.dp)
            .background(Color.Green)
    ) {
        Text(text = "Hello")
        Text(text = "$name!")
    }
}

@Composable
fun ArtistCardBox() {
    Box {
        Text("Alfred Sisley")
        Text("3 minutes ago")
    }
}

@Composable
fun ArtistCardRow() {
    Row {
        Text("Alfred Sisley")
        Text("3 minutes ago")
    }
}

@Composable
fun ArtistCardColumn() {
    Column {
        Text("Alfred Sisley")
        Text("3 minutes ago")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MicroSpotifyTheme {
        Surface {
            Greeting("Android")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewArtistCardBox() {
    MicroSpotifyTheme {
        Surface {
            ArtistCardBox()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewArtistCardColumn() {
    MicroSpotifyTheme {
        Surface {
            ArtistCardColumn()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewArtistCardRow() {
    MicroSpotifyTheme {
        Surface {
            ArtistCardRow()
        }
    }
}
