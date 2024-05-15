package com.example.cubetest.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cubetest.repository.StorageRepository
import com.example.cubetest.repository.TravelTaipeiRepository
import com.example.cubetest.vo.Language
import com.example.cubetest.vo.attraction.Attraction
import com.example.cubetest.vo.news.News
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class UiState(
    val isLoading: Boolean = true,
    val attractions: List<Attraction> = emptyList(),
    val news: List<News> = emptyList()
)

class MainViewModel(
    private val repository: TravelTaipeiRepository,
    private val storageRepository: StorageRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun refresh() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val lang = getLanguageCode()
            combine(
                repository.fetchAttractions(lang),
                repository.fetchNews(lang)
            ) { attractions, news ->
                return@combine UiState(
                    isLoading = false,
                    attractions = attractions.data,
                    news = news.data
                )
            }.collect {
                _uiState.value = it
            }

        }
    }

    /**
     * 儲存語言
     */
    fun setLanguageCode(language: Language) {
        viewModelScope.launch {
            storageRepository.saveLanguageCode(language.languageCode)
            refresh()
        }
    }

    /**
     * 取得語言
     */
    private fun getLanguageCode(): String {
        return storageRepository.getLanguageCode()
    }

}