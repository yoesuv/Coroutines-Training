package com.yoesuv.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.yoesuv.myapplication.menu.listplace.views.MainListPlaceActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonListPlace.setOnClickListener {
            startActivity(Intent(this, MainListPlaceActivity::class.java))
        }

    }
}
