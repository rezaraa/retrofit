package com.rezara.advancecourse2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            var intent = Intent(this,Azanshow::class.java)
            val list = arrayListOf( "azan time" )
            var clickListener: (String)->Unit={
                when(it) {"azan time" -> startActivity(intent)
                }
            }
            val adapter = Recycleradapter(list,clickListener)
           recycler.adapter = adapter
         //   txtIntent.setOnClickListener {
           //     val intent = Intent(this, Azanshow::class.java)
              //  startActivity(intent)
            }
    }

