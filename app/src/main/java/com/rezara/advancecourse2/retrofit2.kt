package com.rezara.advancecourse2
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface retrofit2 {
    @GET("timingsByCity")
    fun getTimings ( @Query("city")city: String,
                     @Query("country")country: String,
                     @Query("method")method: Int
    ):Call<azanresponse>
}