package com.danamon.data.service

import com.danamon.data.model.HomeDataResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeService {
    @GET("photos")
    suspend fun getDataHome(
        @Query("page") page: Int, @Query("limit") limit: Int
    ): List<HomeDataResponse>
}