package com.ph32395.lap5_ph32395

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.ph32395.lap5_ph32395.ui.theme.Lap5_ph32395Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                Bai1Screen()
        }
    }
}


@Composable
fun Bai1Screen() {
    LoginApp()
}


@Composable
fun LoginApp() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray),
        contentAlignment = Alignment.Center
    ) {
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            LoginScreen()
        }
    }
}



//Login Screen
@Composable
fun LoginScreen() {
//    LocalContext truy xuat context hien tai
//    current tra ve vi tri hien tai cua Composable

    var userName by remember { mutableStateOf("") }
    var passWord by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }

    if (showDialog) {
        DialogComponent(onConfirmation = { showDialog = false },
            dialogTitle = "Notification",
            dialogMessage = dialogMessage)
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {

        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .clip(CircleShape))

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(value = userName,
            onValueChange = {userName = it},
            label = { Text(text = "Username")},

            )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = passWord,
            onValueChange = {passWord = it},
            label = { Text(text = "Password")},
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(10.dp))
//        Goi ham Remember
        RememberMeSwitch()

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            if (userName.isNotBlank() && passWord.isNotBlank()) {
                dialogMessage = "Login successful"
            } else {
                dialogMessage = "Please enter userName and passWord"
            }
            showDialog = true
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray,
                contentColor = Color.White))
        {
            Text(text = "Login")
        }
    }
}

//Create Dialog
@Composable
fun DialogComponent (
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogMessage: String
) {
    Dialog(onDismissRequest = {  }) {
        Card (
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier.padding(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ) {
            Column (
                modifier = Modifier.padding(10.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = dialogTitle,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = dialogMessage,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(onClick = onConfirmation,
                    modifier = Modifier.align(Alignment.End),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.DarkGray,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Okay")
                }
            }
        }
    }
}

//Ham Remember tao Switch luu thong tin
@Composable
fun RememberMeSwitch() {
    var isChecked by remember { mutableStateOf(false) }

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Switch(checked = isChecked,
            onCheckedChange = {isChecked = it}
        )
        Text(text = "Remember me?", modifier = Modifier.padding(start = 12.dp))
    }
}