package com.example.characterlist10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.characterlist10.characterList.presentation.CharacterListScreen
import com.example.characterlist10.characterList.presentation.CharacterViewModel
import com.example.characterlist10.ui.theme.CharacterList10Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CharacterList10Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val viewModel: CharacterViewModel = hiltViewModel()
                    val state by viewModel.state.collectAsStateWithLifecycle()

                    LaunchedEffect(Unit) {
                        viewModel.fetchCharacters()
                    }

                    CharacterListScreen(
                        modifier = Modifier.padding(innerPadding),
                        characterListState = state
                    )
                }
            }
        }
    }
}