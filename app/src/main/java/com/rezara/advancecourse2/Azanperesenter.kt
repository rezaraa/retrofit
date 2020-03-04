package com.rezara.advancecourse2

class Azanperesenter  (val view:azanContract.View): azanContract.Presenter{
    override fun onRetrofitResponse(isSucceed: Boolean, parayerTiming: Timings?) {
        if(isSucceed)
            view.showAzanTime(parayerTiming)}
    override fun timedevidetion(time: Int): String {
        val hour=time
        var result=when(hour){
            in 5..18 -> {
                "day"
            }
            else ->{
                "night"
            }
        }
        return result
    }

    val md=AzanModel(this)

    override fun showResultButtonclick() {
val (country,city) = view.getCountryCity()
        md.getPrayTimeData(city, country)
}}