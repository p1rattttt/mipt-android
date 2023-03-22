package com.p1rat.android

import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.p1rat.android.ui.theme.MiptandroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiptandroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    SignUp()
                }
            }
        }
    }
}

@Composable
fun SignUp() {
    Column(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val username = remember {
            mutableStateOf(TextFieldValue())
        }

        val email = remember {
            mutableStateOf(TextFieldValue())
        }

        val password = remember {
            mutableStateOf(TextFieldValue())
        }

        Logo()

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Sign Up For Free",
            style = TextStyle(fontSize = 20.sp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            label = { Text(text = "Username") },
            value = username.value,
            onValueChange = { username.value = it },
            placeholder = {
                Text(
                    text = "p1rattttt",
                    color = Color.Gray
                )
            }
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            label = { Text(text = "Email") },
            value = email.value,
            onValueChange = { email.value = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            placeholder = {
                Text(
                    text = "lolkek@gmail.com",
                    color = Color.Gray
                )
            }
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            label = { Text(text = "Password") },
            value = password.value,
            onValueChange = { password.value = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )

        Spacer(modifier = Modifier.height(15.dp))

        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {},
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "SignUp")
            }
        }

        ClickableText(
            text = AnnotatedString("already have an account?"),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(20.dp),
            onClick = {},
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.Default,
                textDecoration = TextDecoration.Underline,
                color = Color(0xFF53E88B),
            )
        )
    }
}

@Composable
fun Logo() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "our logo",
            modifier = Modifier
                .size(200.dp)
        )
        Text(
            "FoodNinja",
            fontStyle = FontStyle.Italic,
            fontSize = 40.sp,
            color = Color(0xFF53E88B)
        )
        Text(
            "Deliever Favorite Food",
            fontSize = 15.sp,
            color = Color(0xFF09051C)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MiptandroidTheme {
        Logo()
    }
}