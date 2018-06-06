package com.yoesuv.myapplication.menu.listplace.views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.yoesuv.myapplication.R

class MainListPlaceActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_place)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId==android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

}