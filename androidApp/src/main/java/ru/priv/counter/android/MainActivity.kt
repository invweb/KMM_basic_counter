package ru.priv.counter.android

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.priv.counter.Greeting

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val greeting = Greeting()
        setContent {
            val count = remember{ mutableIntStateOf(0) }
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        GreetingView(greeting.greet())
                        ButtonView(
                            buttonText = getString(R.string.increment)
                        ) {
                            count.intValue += greeting.increment()
                            Toast.makeText(
                                this@MainActivity,
                                count.intValue.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        CounterValueView(count.intValue.toString())
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Composable
fun CounterValueView(value: String) {
    Text(text = value)
}

@Composable
fun ButtonView(buttonText: String, onClick: () -> Unit) {
    Button(onClick = { onClick() }) {
        Text(buttonText)
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
