package com.example.littlelemon.onboardingscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.littlelemon.database.User
import com.example.littlelemon.database.UserDao
import kotlinx.coroutines.launch

class OnBoardingViewModel(private val userDao: UserDao) : ViewModel() {


    fun isValidEmail(email: String): Boolean {
        return com.example.littlelemon.utils.ValidationUtils.isValidEmail(email)
    }

    fun registerUser(firstName: String, lastName: String, email: String) {
        if (!isValidEmail(email)) {
            return
        }

        viewModelScope.launch {
            val user = User(firstName = firstName, lastName = lastName, email = email)
            userDao.insertUser(user)
        }
    }
}