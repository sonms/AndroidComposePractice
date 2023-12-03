package com.example.mycomposepracticeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycomposepracticeproject.ui.theme.MyComposePracticeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposePracticeProjectTheme {
                val clickCnt : MutableState<Int> = remember { mutableStateOf(0) }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android", clickCnt.value, onClicked = {
                        clickCnt.value = clickCnt.value + 1
                    })
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, clickCnt : Int, onClicked:() -> Unit) {
    Text(text = "Hello $name!")
    Column(
        modifier = Modifier.fillMaxSize()

    ) {
        Text(text = "클릭 카운트 : $clickCnt")
        Button(onClicked) { //디자인 안에는 디자인을 구성하는 요소
            Text(text = "클릭",
                Modifier.fillMaxSize()
            )

        }
    }
}

/*
@Preview(showBackground = true) //구성 가능한 함수를 미리 보기 가능, preview주석은 매개변수를 사용하지 않는 구성가능한 함수에 사용해야함
@Composable
fun DefaultPreview() {
    MyComposePracticeProjectTheme {
        Greeting("Android")
    }
}*/
