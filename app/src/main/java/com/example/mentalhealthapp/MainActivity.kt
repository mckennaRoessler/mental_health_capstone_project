package com.example.mentalhealthapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mentalhealthapp.ui.theme.MentalHealthAppTheme
import android.net.Uri
import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity

class MainActivity : ComponentActivity() {
    lateinit var msgTextView: TextView

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // on below line we are initializing
        // our variable with their ids.
        //msgTextView = findViewById(R.id.idTVMsg)

        // getting the data from our
        // intent in our uri.
        val uri: Uri? = intent.data

        // checking if the uri is null or not.
        if (uri != null) {
            // if the uri is not null then we are getting the
            // path segments and storing it in list.
            val parameters: List<String> = uri.pathSegments

            // after that we are extracting string from that parameters.
            val param = parameters[parameters.size - 1]

            // on below line we are setting
            // that string to our text view
            // which we got as params.
            msgTextView.text = param
        setContent {
            MentalHealthAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),

                topBar = {
                    TopAppBar(
                        title = { Text("Mental Health App") },

                        actions = {
                            IconButton(onClick = {
                                // TODO: open profile screen
                            }) {
                                Icon(
                                    imageVector = Icons.Default.AccountCircle,
                                    contentDescription = "Profile"
                                )
                            }
                        }
                    )
                })

                { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
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
    MentalHealthAppTheme {
        Greeting("Android")
    }
}}