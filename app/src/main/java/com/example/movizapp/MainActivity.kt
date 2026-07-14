package com.example.movizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.movizapp.repository.Repository
import com.example.movizapp.screens.MovieScreen
import com.example.movizapp.ui.theme.MovizAppTheme
import com.example.movizapp.viewmodel.MovieViewModel
import com.example.movizapp.viewmodel.MovieViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val repository = Repository()

        val viewModelFactory = MovieViewModelFactory(repository)

        val movieViewModel = ViewModelProvider(
            this,
            viewModelFactory
        )[MovieViewModel::class.java]

        setContent {
            MovizAppTheme {
                MovieScreen(viewModel = movieViewModel)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovizAppTheme {
        Greeting("Android")
    }
}