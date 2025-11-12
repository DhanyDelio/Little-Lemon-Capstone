package com.example.littlelemon.onboardingscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.littlelemon.profilescreen.PersonalInformationForm

@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    logoResId: Int,
    viewModel: OnBoardingViewModel,
    onRegisterClick: () -> Unit,
    isEmailValid: (String) -> Boolean
) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OnBoardingHeader(
            logoResId = logoResId,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        OnBoardingGreeting()
        RegistrationForm(
            firstName = firstName,
            onFirstNameChange = { firstName = it },
            lastName = lastName,
            onLastNameChange = { lastName = it },
            email = email,
            onEmailChange = { email = it },
            onRegisterClick = {
                viewModel.registerUser(firstName, lastName, email)
                onRegisterClick()
            },
            isEmailValid = isEmailValid

        )
    }
}


