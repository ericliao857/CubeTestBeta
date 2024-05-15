package com.example.cubetestbeta2.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cubetestbeta2.repository.TravelTaipeiRepository
import com.example.cubetestbeta2.tools.WhileUiSubscribed
import com.example.cubetestbeta2.vo.attraction.Attraction
import com.example.cubetestbeta2.vo.news.News
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class UiState(
    val isLoading: Boolean = true,
    val attractions: List<Attraction>? = null,
    val news: List<News>? = null
)

class MainViewModel(
    private val repository: TravelTaipeiRepository
) : ViewModel() {
    val uiState: StateFlow<UiState> = combine(
        repository.fetchAttractions(TW),
        repository.fetchNews(TW)
    ) { attractions, news ->
        return@combine UiState(
            isLoading = false,
            attractions = attractions.data,
            news = news.data
        )
    }.catch { e ->
        e.printStackTrace()
    }.stateIn(
        scope = viewModelScope,
        started = WhileUiSubscribed,
        initialValue = UiState(isLoading = true)
    )

    companion object {
        const val TW = "zh-tw"
    }
}