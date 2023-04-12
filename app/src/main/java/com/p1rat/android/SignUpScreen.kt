package com.p1rat.android

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource

@Composable
fun SignUpScreen(loginViewModel: SignUpScreenViewModel = viewModel()) {
    Column(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val state by loginViewModel.viewState.observeAsState()
        val viewState = state ?: return

        Logo()

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = stringResource(R.string.sign_up_label),
            style = TextStyle(fontSize = 20.sp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            label = { Text(text = stringResource(R.string.username_label)) },
            value = viewState.username,
            onValueChange = { SignUpEvent.ChangeUsername(it) },
            placeholder = {
                Text(
                    text = stringResource(R.string.username_placeholder),
                    color = Color.Gray
                )
            }
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            label = { Text(text = stringResource(R.string.email_label)) },
            value = viewState.email,
            onValueChange = { loginViewModel.obtainEvent(SignUpEvent.ChangeEmail(it)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            placeholder = {
                Text(
                    text = stringResource(R.string.email_placeholder),
                    color = Color.Gray
                )
            }
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            label = { Text(text = stringResource(R.string.password_label)) },
            value = viewState.password,
            onValueChange = { loginViewModel.obtainEvent(SignUpEvent.ChangePassword(it)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )

        Spacer(modifier = Modifier.height(15.dp))

        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Row{
                Checkbox(
                    checked = viewState.keepSigned,
                    onCheckedChange = { loginViewModel.obtainEvent(SignUpEvent.ChangeKeepSigned) },
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    stringResource(R.string.agreement_1),
                    color = Color.Gray
                )
            }

            Row{
                Checkbox(
                    checked = viewState.emailAboutPricing,
                    onCheckedChange = { loginViewModel.obtainEvent(SignUpEvent.ChangeEmailAboutPricing) },
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    stringResource(R.string.agreement_2),
                    color = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {},
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = stringResource(R.string.sign_up))
            }
        }

        ClickableText(
            text = AnnotatedString(stringResource(R.string.agreement_3)),
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