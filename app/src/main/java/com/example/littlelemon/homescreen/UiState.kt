package com.example.littlelemon.homescreen

import com.example.littlelemon.data.MenuItem

data class UiState(
    val menuItems: List<MenuItem> = emptyList(),
    val searchPhrase: String = "",
    val selectedCategory: String? = null
)