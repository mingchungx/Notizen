package dev.mingchungx.notizen.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.mingchungx.notizen.viewmodel.ContentViewModel
import dev.mingchungx.notizen.viewmodel.UiState
import dev.mingchungx.notizen.Greeting
import kotlinx.coroutines.flow.collectLatest

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContentScreen()
                }
            }
        }
    }
}

@Composable
fun ContentScreen(
    viewModel: ContentViewModel = remember { ContentViewModel() },
    greeting: Greeting = Greeting()
) {
    // Collect StateFlow<UiState> as Compose state
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = greeting.greet(), style = MaterialTheme.typography.titleLarge)

        if (!uiState.isLoading) {
            Text(text = uiState.title, style = MaterialTheme.typography.bodyLarge)
        }

        Text(text = "Count: ${uiState.count}", style = MaterialTheme.typography.bodyLarge)

        Button(onClick = { viewModel.increment() }) {
            Text("Increment!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentScreenPreview() {
    MyApplicationTheme {
        // Preview with a fake UiState
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Hello from Greeting()", style = MaterialTheme.typography.titleLarge)
            Text("Preview Title", style = MaterialTheme.typography.bodyLarge)
            Text("Count: 42", style = MaterialTheme.typography.bodyLarge)
            Button(onClick = {}) { Text("Increment!") }
        }
    }
}