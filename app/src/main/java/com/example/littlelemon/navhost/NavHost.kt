package com.example.littlelemon

import NavDestination
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.database.AppDatabase
import com.example.littlelemon.homescreen.HomeScreen
import com.example.littlelemon.homescreen.HomeScreenViewModel
import com.example.littlelemon.onboardingscreen.OnBoardingScreen
import com.example.littlelemon.onboardingscreen.OnBoardingViewModel
import com.example.littlelemon.profilescreen.ProfileScreen
import com.example.littlelemon.profilescreen.ProfileViewModel
import com.example.littlelemon.profilescreen.ProfileViewModelFactory

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    viewModel: OnBoardingViewModel
) {
    NavHost(
        navController = navController,
        startDestination = NavDestination.OnBoarding.route
    ) {
        composable(NavDestination.OnBoarding.route) {
            OnBoardingScreen(
                logoResId = R.drawable.logo,
                viewModel = viewModel,
                modifier = Modifier.fillMaxSize(),
                isEmailValid = viewModel::isValidEmail,
                onRegisterClick = {
                    navController.navigate(NavDestination.Home.route)
                }
            )
        }

        composable(NavDestination.Home.route) {
            val homeViewModel: HomeScreenViewModel = viewModel()
            HomeScreen(
                viewModel = homeViewModel,
                logoResId = R.drawable.logo,
                onProfileClick = {
                    navController.navigate(NavDestination.Profile.route)
                },
                profileImageResId = R.drawable.profile
            )
        }

        composable(NavDestination.Profile.route) {
            val context = LocalContext.current
            val db = AppDatabase.getInstance(context)
            val profileViewModel: ProfileViewModel = viewModel(
                factory = ProfileViewModelFactory(db.userDao())
            )

            ProfileScreen(
                viewModel = profileViewModel,
                logoResId = R.drawable.logo,
                onLogout = {
                    navController.navigate(NavDestination.OnBoarding.route) {
                        popUpTo(NavDestination.OnBoarding.route) { inclusive = true }
                    }
                }
            )
        }
    }
}