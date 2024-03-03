package com.danamon.data.mapper

import com.danamon.core.network.Mapper
import com.danamon.data.model.HomeDataResponse
import com.danamon.domain.model.HomeData

class HomeDataMapper : Mapper<List<HomeDataResponse>, List<HomeData>> {
    override fun to(t: List<HomeDataResponse>): List<HomeData> {
        return t.map {
            HomeData(
                albumId = it.albumId,
                id = it.id,
                title = it.title,
                thumbnailUrl = it.thumbnailUrl,
                url = it.url
            )
        }
    }
}