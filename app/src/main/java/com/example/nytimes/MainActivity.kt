package com.example.nytimes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.core.ui.theme.NYTimesTheme
import com.example.nytimes.navigation.NavigationSystem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NYTimesTheme {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        NavigationSystem()
                    }

//                NYTimesScaffold(
//                    content = {
//                    Column(
//                        modifier = Modifier
//                            .padding(it)
//                            .fillMaxSize()
//                    ) {
//                        NavigationSystem()
//                    }
//                }, icon = {
//                    Icon(
//                        imageVector = Icons.Filled.Settings,
//                        tint = Color.White,
//                        contentDescription = "Settings",
//                        modifier = Modifier.padding(8.dp)
//                    )
//                }
//                )

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
    com.example.core.ui.theme.NYTimesTheme {
        Greeting("Android")
    }
}