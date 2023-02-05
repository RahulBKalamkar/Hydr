package com.rahul.assesment_04_02_2023.Data.Api

import com.rahul.assesment_04_02_2023.Data.Model.BaseResponse
import com.rahul.assesment_04_02_2023.Utils.AppConstant.API_KEY
import com.rahul.assesment_04_02_2023.Utils.AppConstant.API_NAME
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @Headers("X-Api-Key: $API_KEY")
    @GET(API_NAME)
    suspend fun getWindInformation(
        @Query("lon") lon: String,
        @Query("lat") lat: String,
        @Query("ac") ac: String,
        @Query("unit") unit: String,
        @Query("output") output: String,
        @Query("tzshift") tzshift: String
    ): BaseResponse

}