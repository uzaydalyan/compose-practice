package com.example.compose_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column {
                val color = remember {
                    mutableStateOf(Color.Yellow)
                }

                ColorBox(
                    modifier = Modifier
                        .weight(1f)
                ){
                    color.value = it
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                        .background(color.value)
                )
            }

        }
    }
}

@Composable
fun ColorBox(
    modifier : Modifier = Modifier,
    changeColor : (Color) -> Unit
){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Blue)
            .clickable {
                val color = Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
                changeColor(color)
            }
    ) {
        Text(
            text = "Click me to change color!",
            color = Color.White,
            style = TextStyle(
                textAlign = TextAlign.Center
            ),
            modifier = Modifier
                .fillMaxSize()
        )
    }

}

