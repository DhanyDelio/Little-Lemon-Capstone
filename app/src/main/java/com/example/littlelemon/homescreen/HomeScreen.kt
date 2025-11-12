package com.example.littlelemon.homescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle



@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeScreenViewModel,
    logoResId: Int,
    profileImageResId: Int,
    onProfileClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.loadMenuItems()
    }
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Header(
            logoResId = logoResId,
            onProfileClick = onProfileClick,
            profileImageResId = profileImageResId
        )
        HeroSection(
            searchPhrase = uiState.searchPhrase,
            onSearchPhraseChange = { newPhrase -> viewModel.updateSearchPhrase(newPhrase) }
        )
        MenuSection(
            menuItems = uiState.menuItems,
            onCatagorySelect = { viewModel.selectCategory(it) }
        )
    }
}
