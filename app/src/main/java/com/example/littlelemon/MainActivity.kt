package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.littlelemon.database.AppDatabase
import com.example.littlelemon.onboardingscreen.OnBoardingViewModel
import com.example.littlelemon.onboardingscreen.OnBoardingViewModelFactory
import com.example.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {

    private val onboardingViewModel: OnBoardingViewModel by viewModels {
        val userDao = AppDatabase.getInstance(applicationContext).userDao()
        OnBoardingViewModelFactory(userDao)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LittleLemonTheme {
                AppNavHost(viewModel = onboardingViewModel)
            }
        }
    }
}