package com.danamon.domain.usecase

import com.danamon.core.data.Resource
import com.danamon.core.network.FlowUseCase
import com.danamon.domain.model.HomeData
import com.danamon.domain.model.request.HomeRequest
import com.danamon.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

class GetHomeUseCase(
    private val repository: HomeRepository
) : FlowUseCase<HomeRequest?, List<HomeData>>() {
    override suspend fun execute(parameters: HomeRequest?): Flow<Resource<List<HomeData>>> {
        return repository.getHome(parameters)
    }
}