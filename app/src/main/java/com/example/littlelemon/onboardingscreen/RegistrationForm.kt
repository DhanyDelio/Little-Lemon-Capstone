package com.example.littlelemon.onboardingscreen

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.imePadding
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape

@Composable
fun RegistrationForm(
    firstName: String,
    onFirstNameChange: (String) -> Unit,
    lastName: String,
    onLastNameChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit,
    onRegisterClick: () -> Unit,
    isEmailValid: (String) -> Boolean
) {
    val emailValid = isEmailValid(email)
    val focusManager = LocalFocusManager.current
    val coroutineScope = rememberCoroutineScope()
    val karla = FontFamily(Font(R.font.karla_variablefont_wght))


    val firstNameRequester = remember { BringIntoViewRequester() }
    val lastNameRequester = remember { BringIntoViewRequester() }
    val emailRequester = remember { BringIntoViewRequester() }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
            .padding(16.dp)
            .pointerInput(Unit) {
                detectTapGestures(onTap = { focusManager.clearFocus() })
            },
        verticalArrangement = Arrangement.spacedBy(32.dp)

    ) {
        item {
            Text(
                text = "Personal Information",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = karla,
                modifier = Modifier.padding(top = 16.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
        }

        item {
            OutlinedTextField(
                value = firstName,
                onValueChange = onFirstNameChange,
                label = { Text("First Name", fontFamily = karla) },
                textStyle = TextStyle(color = Color.Black, fontFamily = karla),
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(
                    onNext = {
                        coroutineScope.launch { lastNameRequester.bringIntoView() }
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .bringIntoViewRequester(firstNameRequester)
            )

        }

        item {
            OutlinedTextField(
                value = lastName,
                onValueChange = onLastNameChange,
                label = { Text("Last Name", fontFamily = karla) },
                textStyle = TextStyle(color = Color.Black, fontFamily = karla),
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(
                    onNext = {
                        coroutineScope.launch { emailRequester.bringIntoView() }
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .bringIntoViewRequester(lastNameRequester)
            )

        }

        item {
            OutlinedTextField(
                value = email,
                onValueChange = onEmailChange,
                label = { Text("Email", fontFamily = karla) },
                textStyle = TextStyle(color = Color.Black, fontFamily = karla),
                singleLine = true,
                isError = !emailValid && email.isNotEmpty(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        if (emailValid) onRegisterClick()
                        focusManager.clearFocus()
                    }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .bringIntoViewRequester(emailRequester)
            )
        }

        item {
            Spacer(modifier = Modifier.height(96.dp))
            Button(
                onClick = onRegisterClick,
                enabled = emailValid,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (emailValid) Color(0xFFF4CE14) else Color(0xFF888888),
                    contentColor = Color.Black,
                    disabledContainerColor = Color(0xFF888888),
                    disabledContentColor = Color.White,
                )
            ) {
                Text(
                    text = "Register",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = karla
                )
            }
        }
    }
}
