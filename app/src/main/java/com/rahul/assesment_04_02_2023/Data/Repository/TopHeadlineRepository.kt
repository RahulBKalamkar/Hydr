package com.rahul.assesment_04_02_2023.Data.Repository

import com.rahul.assesment_04_02_2023.Data.Api.NetworkService
import com.rahul.assesment_04_02_2023.Data.Model.Dataseries
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WindInformationRepository @Inject constructor(private val networkService: NetworkService) {

    fun getTopHeadlines(lat: String, lon: String): Flow<List<Dataseries>> {
        return flow {
            emit(networkService.getWindInformation(lon, lat, "0", "metric", "json", "0"))
        }.map {
            it.dataseries
        }
    }

}