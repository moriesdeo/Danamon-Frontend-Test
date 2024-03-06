package com.danamon.test.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danamon.core.data.Resource
import com.danamon.domain.model.HomeData
import com.danamon.domain.model.request.HomeRequest
import com.danamon.domain.usecase.GetHomeUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getHomeUseCase: GetHomeUseCase
) : ViewModel() {

    val homeData = MutableLiveData<Resource<List<HomeData>>>()
    fun getHomeData(homeRequest: HomeRequest) {
        viewModelScope.launch {
            getHomeUseCase.invoke(homeRequest).collect {
                homeData.value = it
            }
        }
    }

    fun isValidEmail(email: String): Boolean {
        val emailRegex = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
        return emailRegex.matches(email)
    }
}