package com.rezara.advancecourse2

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AzanModel(private val presenter: azanContract.Presenter) {

    fun getPrayTimeData(country: String, city: String){
        val retrofit= Retrofit.Builder()
            .baseUrl("https://api.aladhan.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
      val timingInterface = retrofit.create(Retrofit2::class.java)

        timingInterface.getTimings(city,country,8)
            .enqueue(object: Callback<AzanResponse>{
                override fun onFailure(call: Call<AzanResponse>, t: Throwable) {
                    Log.d("myerror",t.message)
                    presenter.onRetrofitResponse(false,null)
                }

                override fun onResponse(call: Call<AzanResponse>, response: Response<AzanResponse>) {
                    val result= response.body()?.data?.timings
                    presenter.onRetrofitResponse(true,result)
                }

            })
    }

}