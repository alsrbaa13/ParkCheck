package com.example.parkcheck

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parkcheck.ui.theme.ParkCheckTheme
import kotlin.jvm.internal.Intrinsics.Kotlin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ParkCheckTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    login()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun login() {
    var context = LocalContext.current
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {
        OutlinedTextField(
            value = text1,
            onValueChange = { text1 = it },
            label = { Text("ID") }
        )
        OutlinedTextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("PW") }
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                          context.startActivity(Intent(context,Kotlin::class.java))
                },
                modifier = Modifier.wrapContentSize(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xff8b00ff))
            ) {
                Text(text = "Login")
            }
            Button(
                onClick = {},
                modifier = Modifier.wrapContentSize(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xff8b00ff))
            ) {
                Text(text = "Sign up")
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun IdPreview() {
    ParkCheckTheme {
        login()
    }
}
