package com.example.cubetest.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cubetest.repository.StorageRepository
import com.example.cubetest.repository.TravelTaipeiRepository
import com.example.cubetest.tools.WhileUiSubscribed
import com.example.cubetest.vo.Language
import com.example.cubetest.vo.attraction.Attraction
import com.example.cubetest.vo.news.News
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
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
    private val _languageFlow: Flow<String> = storageRepository.getLanguageFlow()

    val uiState: StateFlow<UiState> = _languageFlow.flatMapLatest { language ->
        return@flatMapLatest combine(
            repository.fetchAttractions(language),
            repository.fetchNews(language)
        ) { attractions, news ->
            return@combine UiState(
                isLoading = false,
                attractions = attractions.data,
                news = news.data
            )
        }.catch { e ->
            e.printStackTrace()
        }.onStart {
            this.emit(UiState(isLoading = true))
        }
    }.stateIn(
        scope = viewModelScope,
        started = WhileUiSubscribed,
        initialValue = UiState(isLoading = true)
    )

    /**
     * 儲存語言
     */
    fun setLanguageCode(language: Language) {
        viewModelScope.launch {
            storageRepository.saveLanguageCode(language.languageCode)
        }
    }

}