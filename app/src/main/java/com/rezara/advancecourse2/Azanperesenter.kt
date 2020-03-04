package com.rezara.advancecourse2

class azanpresenter  (val view:azanContract.View): azanContract.Presenter{
    override fun onRetrofitResponse(isSucceed: Boolean, parayerTiming: Timings?) {
        if(isSucceed)
            view.showAzanTime(parayerTiming)}
    override fun timedevidetion(time: String): String {
        val hour=time.toInt()
        var result=when(hour){
            in 5..18 -> {"day"}
            else ->{"night"}
        }
        return result
    }

    val md=azanModel(this)

    override fun showResultButtonclick() {
val (country,city) = view.getCountryCity()
        md.getPrayTimeData(city, country)
}}