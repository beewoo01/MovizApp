package com.example.movizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.movizapp.repository.Repository
import com.example.movizapp.room.MoviesDB
import com.example.movizapp.screens.MovieScreen
import com.example.movizapp.ui.theme.MovizAppTheme
import com.example.movizapp.viewmodel.MovieViewModel
import com.example.movizapp.viewmodel.MovieViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val repository = Repository(context = applicationContext)

        val viewModelFactory = MovieViewModelFactory(repository)

        val movieViewModel = ViewModelProvider(
            this,
            viewModelFactory
        )[MovieViewModel::class.java]

        setContent {
            MovizAppTheme {
                Column {
                    HeaderComposable()
                    MovieScreen(viewModel = movieViewModel)
                }
            }
        }
    }
}

@Composable
fun HeaderComposable() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 12.dp)
    ) {
        Text(
            text = "The Moviz App",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

    }
}