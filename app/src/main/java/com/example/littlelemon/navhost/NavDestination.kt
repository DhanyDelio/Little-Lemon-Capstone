sealed class NavDestination(val route: String) {
    object OnBoarding : NavDestination("onboarding")
    object Home : NavDestination("home")
    object Profile : NavDestination("profile")
}