package com.danamon.data.repository

import com.danamon.core.data.Resource
import com.danamon.core.extension.buildNetwork
import com.danamon.core.extension.mapTo
import com.danamon.data.mapper.HomeDataMapper
import com.danamon.data.safeApiCall
import com.danamon.data.service.HomeService
import com.danamon.domain.model.HomeData
import com.danamon.domain.model.request.HomeRequest
import com.danamon.domain.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepositoryImpl(
    private val service: HomeService, private val homeDataMapper: HomeDataMapper
) : HomeRepository {
    override suspend fun getHome(homeRequest: HomeRequest?): Flow<Resource<List<HomeData>>> {
        return flow {
            val response = safeApiCall(Dispatchers.IO) {
                service.getDataHome(
                    page = homeRequest?.page ?: 0, limit = homeRequest?.limit ?: 0
                ).mapTo(homeDataMapper)
            }
            emit(response)
        }.buildNetwork()
    }
}