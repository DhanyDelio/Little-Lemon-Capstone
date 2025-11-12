package com.example.littlelemon.homescreen


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.littlelemon.data.Network
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun loadMenuItems() {
        viewModelScope.launch {
            val response = Network.fetchMenu()
            _uiState.value = _uiState.value.copy(menuItems = response.menu)
        }
    }

    fun updateSearchPhrase(newPhrase: String) {
        val filtered = if (newPhrase.isBlank()) {
            Network.cachedMenu
        } else {
            Network.cachedMenu.filter {
                it.title.contains(newPhrase, ignoreCase = true) ||
                        it.description.contains(newPhrase, ignoreCase = true) ||
                        it.category.contains(newPhrase, ignoreCase = true)
            }
        }

        _uiState.value = _uiState.value.copy(
            searchPhrase = newPhrase,
            menuItems = filtered
        )
    }


    fun selectCategory(category: String) {
        val filtered = Network.cachedMenu.filter { it.category.equals(category, ignoreCase = true) }
        _uiState.value = _uiState.value.copy(menuItems = filtered)
    }
}
