package com.rezara.advancecourse2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.azanshow.*
import java.text.SimpleDateFormat
import java.util.*


class azanShow : AppCompatActivity(), azanContract.View{
    val presenter = azanpresenter(this)
    /**
    https://stackoverflow.com/questions/2271131/display-the-current-time-and-date-in-an-android-application
     */
    override fun getCountryCity(): Pair<String, String> {
        val country =edtcountry.text.trim().toString()
        val city = edtcity.text.trim().toString()
        return country to city
    }
    override fun showCurrentTime() {
        val time = Calendar.getInstance()
        val df = SimpleDateFormat( "HH:mm:ss")
        val timesepration=presenter.timedevidetion(df.format(time))
        when(timesepration){
            "day"-> imgtime.setBackgroundResource(R.drawable.night)
            "night"-> imgtime.setBackgroundResource(R.drawable.sunrise)

        }
    }

    override fun showAzanTime(prayerTimings: Timings?) {
        txtfajr.text =  prayerTimings?.Fajr
        txtsunrise.text = prayerTimings?.Sunrise
        txtsunset.text =  prayerTimings?.Sunset
        txtmidnight.text = prayerTimings?.Midnight
    }

    override fun showError() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.azanshow)
    showCurrentTime()
        btnshowresult.setOnClickListener { presenter.showResultButtonclick() }
    }
}
