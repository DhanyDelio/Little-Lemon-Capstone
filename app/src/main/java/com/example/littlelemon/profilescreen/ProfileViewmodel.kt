package com.example.littlelemon.profilescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.littlelemon.database.User
import com.example.littlelemon.database.UserDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileViewModel(private val userDao: UserDao) : ViewModel() {

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    init {
        loadLatestUser()
    }

    private fun loadLatestUser() {
        viewModelScope.launch {
            val latestUser = userDao.getLatestUser()
            _user.value = latestUser
        }
    }

    fun clearUserData() {
        viewModelScope.launch {
            userDao.clearAllUsers()
            _user.value = null
        }
    }
}
