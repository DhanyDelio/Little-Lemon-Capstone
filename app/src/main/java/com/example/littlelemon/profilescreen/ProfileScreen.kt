package com.example.littlelemon.profilescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.littlelemon.database.User

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel,
    logoResId: Int,
    onLogout: () -> Unit
) {
    val user by viewModel.user.collectAsState()

    user?.let {
        Column(modifier = Modifier.padding(16.dp)) {
            ProfileHeaderScreen(logoResId = logoResId)
            PersonalInformationForm(
                firstName = it.firstName,
                lastName = it.lastName,
                email = it.email,
                onLogOutClick = {
                    viewModel.clearUserData()
                    onLogout()
                }
            )
        }
    }
}