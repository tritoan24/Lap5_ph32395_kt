package com.ph32395.lap5_ph32395
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


class Bai_2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Bai2Screen()
        }
    }
}

@Composable
fun Bai2Screen() {
    LightSwitch()
}

@Composable
fun LightSwitch() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val isChecked = remember {
            mutableStateOf(false)
        }

        if (isChecked.value) {
            Image(painter = painterResource(id = R.drawable.light_on),
                contentDescription = "Light is on",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(550.dp),
                contentScale = ContentScale.FillWidth
            )
        } else {
            Image(painter = painterResource(id = R.drawable.light_off),
                contentDescription = "Light is off",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(550.dp),
                contentScale = ContentScale.FillWidth
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Switch(checked = isChecked.value,
            onCheckedChange = {isChecked.value = it},
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Green,
                uncheckedThumbColor = Color.Gray,
                checkedTrackColor = Color.Green.copy(0.5f),
                uncheckedTrackColor = Color.Gray.copy(0.5f),
                checkedBorderColor = Color.Green.copy(0.75f)
            )
        )
    }
}