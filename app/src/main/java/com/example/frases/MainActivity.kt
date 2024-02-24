package com.example.frases

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.frases.ui.theme.FrasesTheme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FrasesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}



@Composable
fun QuoteScreen(){
    /*Fondo naranja, logo iest esquina superior derecha
    en el centro, textos iest y abajo la frase "Por la fe
    y la razon*/

    val quoteOne = "Vince In Bono Malum"
    val quoteTwo = "Por la Fe y la Razon"
    var newQuote by remember{ mutableStateOf("Vince In Bono Malum")}
    var haveToChange by remember{ mutableStateOf(false)}
    //= "Vince In Bono Malum"


    val imageOne = painterResource(id = R.drawable.iest_logo)
    val imageTwo = painterResource(id = R.drawable.anahuac_logo)
    var newImage by remember{ mutableStateOf(imageOne)}
    var haveToChangeImage by remember{ mutableStateOf(false)}

    var hideImage by remember {mutableStateOf(false)}

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFF9800))
    ){
        if(!hideImage){
            Image(
                painter = newImage,
                contentDescription = "Logo de la Escuela",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 8.dp, end = 8.dp)
                    .height(180.dp)
                    .width(150.dp)
                    .clickable {
                        hideImage = true
                        Toast.makeText(context, "Hola este es un mensaje rapido",
                        Toast.LENGTH_LONG).show()
                    }
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        ){
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    text="IEST",
                    fontSize = 54.sp,
                    color = Color.White
                )
                Text(
                    text=newQuote,
                    fontSize = 30.sp,
                    color = Color.White
                )
            }
            }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Button(
                    modifier = Modifier
                        .padding(top = 10.dp,
                                bottom = 35.dp,
                                end = 10.dp,
                                start = 10.dp
                        ),
                    onClick = {
                    if(!haveToChange){
                        newQuote = quoteTwo
                    }else{
                        newQuote = quoteOne
                    }
                    haveToChange = !haveToChange
                },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    ),
                    enabled = true
                    ){
                    Text(text = "Cambiar Frase")
                }
                Button(
                    modifier = Modifier
                        .padding(top = 10.dp,
                                bottom = 35.dp,
                                end = 10.dp,
                                start = 10.dp),
                    onClick = {
                    if(!haveToChangeImage){
                        newImage = imageTwo
                    }else{
                        newImage = imageOne
                    }
                        haveToChangeImage = !haveToChangeImage
                },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    ),
                    enabled = true
                ){
                    Text(text = "Cambiar Imagen")
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
    FrasesTheme {
        QuoteScreen()
    }
}