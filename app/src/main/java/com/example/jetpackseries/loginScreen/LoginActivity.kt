package com.example.jetpackseries.loginScreen

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackseries.loginScreen.ui.theme.JetpackSeriesTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackSeriesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

private fun login(username: String, password: String, context: Context) {

    if (username == "deepak" && password == "1234") {
        Toast.makeText(context, "login", Toast.LENGTH_SHORT).show()
    } else {
        Toast.makeText(context, "wrong username or password", Toast.LENGTH_SHORT).show()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {

    val context = LocalContext.current
    val text = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val state = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(state)
            .fillMaxSize()
    ) {

        Text(
            text = "Welcome!",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 150.dp),
            textAlign = TextAlign.Center
        )

        Column(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 30.dp),
            verticalArrangement = Arrangement.Center
        ) {

            OutlinedTextField(
                value = text.value,
                onValueChange = {
                    text.value = it
                },
                label = {
                    Text(text = "Username")
                },
                placeholder = { Text(text = "enter username") },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Person,
                        contentDescription = "username",
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = password.value,
                onValueChange = {
                    password.value = it
                },
                label = {
                    Text(text = "Password")
                },
                placeholder = { Text(text = "enter password") },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Info,
                        contentDescription = "info",
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(60.dp))

            OutlinedButton(
                onClick = { login(text.value, password.value, context) },
                colors = ButtonDefaults.outlinedButtonColors(MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    text = "Login",
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 19.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    JetpackSeriesTheme {

    }
}