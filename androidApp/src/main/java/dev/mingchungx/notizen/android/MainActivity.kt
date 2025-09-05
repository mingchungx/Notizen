package dev.mingchungx.notizen.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import dev.mingchungx.notizen.SharedRes
import dev.mingchungx.notizen.Greeting
import dev.mingchungx.notizen.viewmodel.ContentViewModel
import org.koin.compose.koinInject

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
    viewModel: ContentViewModel = koinInject(),
    greeting: Greeting = Greeting()
) {
    val count by viewModel.countFlow.collectAsState()
    val text by viewModel.textFlow.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = greeting.greet(), style = MaterialTheme.typography.titleLarge)

        Image(
            painter = painterResource(SharedRes.images.cat),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )

        Text(text = "Count: $count", style = MaterialTheme.typography.bodyLarge)
        Button(onClick = { viewModel.onAction(ContentViewModel.Action.Increment) }) {
            Text("Increment!")
        }

        Text(text = "Text: $text", style = MaterialTheme.typography.bodyLarge)
        Button(onClick = { viewModel.onAction(ContentViewModel.Action.FetchGreeting) }) {
            Text("Fetch Greeting")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentScreenPreview() {
    MyApplicationTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Hello from Greeting()", style = MaterialTheme.typography.titleLarge)
            Image(
                painter = painterResource(SharedRes.images.cat),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
            Text("Count: 42")
            Button(onClick = {}) { Text("Increment!") }
        }
    }
}