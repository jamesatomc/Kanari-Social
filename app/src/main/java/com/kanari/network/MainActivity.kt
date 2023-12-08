package com.kanari.network

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kanari.network.ui.theme.KariSocialTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KariSocialTheme {

                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Login()
                }
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun Login() {

        Scaffold(
            modifier = Modifier.fillMaxSize(),
        ) {
            Box(
                Modifier
                    .fillMaxSize(),
                Alignment.BottomEnd
            ) {
                Card(
                    Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .clip(
                            RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                        ),
                ) {
                    Column {
                        TextInput()
                        ButtonKey()
                    }
                }
            }
        }
    }

    @Preview
    @Composable
    fun TextInput(
    ) {
        val textState = remember {
            mutableStateOf( value = "" )
        }


        TextField(
            value = textState.value,
            onValueChange = {
                textState.value = it
            },
            Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            label =  { Text(text = "Key", fontSize = 20.sp) },
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.baseline_key_24), contentDescription = "key")
            },
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
            )

        )
    }

    @Preview
    @Composable
    fun ButtonKey() {

        Box(
            Modifier.fillMaxWidth(),
            Alignment.Center
        ) {
            Button(
                onClick = {
                    val navigate = Intent(this@MainActivity, RootActivity::class.java)
                    startActivity(navigate)
                },
                modifier = Modifier
                    .width(100.dp)
            ) {
                Text(text = "Login")
            }
        }

    }
}



