package com.rezara.advancecourse2

interface azanContract {
    interface View{
        fun getCountryCity(): Pair<String,String>
        fun showAzanTime(prayerTimings: Timings?)
        fun showError()
        fun showCurrentTime()
    }
    interface Presenter{
        fun showResultButtonclick()
        fun timedevidetion(time: Int):String
        fun onRetrofitResponse(isSucceed: Boolean, prayerTimings: Timings?)

    }
}