package com.danamon.domain.repository

import com.danamon.core.data.Resource
import com.danamon.domain.model.HomeData
import com.danamon.domain.model.request.HomeRequest
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getHome(homeRequest: HomeRequest?): Flow<Resource<List<HomeData>>>
}