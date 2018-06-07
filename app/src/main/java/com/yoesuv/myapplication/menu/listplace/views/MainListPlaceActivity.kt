package com.yoesuv.myapplication.menu.listplace.views

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.MenuItem
import android.view.View
import com.yoesuv.myapplication.R
import com.yoesuv.myapplication.data.AppConstants
import com.yoesuv.myapplication.menu.listplace.adapters.ListPlaceAdapter
import com.yoesuv.myapplication.menu.listplace.contracts.ListPlaceContract
import com.yoesuv.myapplication.menu.listplace.models.PlaceModel
import com.yoesuv.myapplication.menu.listplace.presenters.ListPlacePresenter
import kotlinx.android.synthetic.main.activity_list_place.*

class MainListPlaceActivity: AppCompatActivity(), ListPlaceContract.ViewListPlace {

    private lateinit var presenter: ListPlacePresenter
    private lateinit var adapter: ListPlaceAdapter
    private var listPlaceData: MutableList<PlaceModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_place)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        presenter = ListPlacePresenter(this)
        adapter = ListPlaceAdapter(this, listPlaceData)

        setupSwipeRefresh()
        setupRecycler()

        presenter.getListPlace()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId==android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    //========== Begin Local Function ==========
    private fun setupRecycler(){
        val lManager = LinearLayoutManager(this)
        lManager.orientation = LinearLayoutManager.VERTICAL
        recyclerViewListPlace.layoutManager = lManager
        recyclerViewListPlace.adapter = adapter
    }

    private fun setupSwipeRefresh(){
        swipeRefreshLayoutListPlace.setColorSchemeColors(ContextCompat.getColor(this, R.color.colorPrimary))
        swipeRefreshLayoutListPlace.setOnRefreshListener {
            swipeRefreshLayoutListPlace.isRefreshing = false
            presenter.getListPlace()
        }
    }
    //========== End Local Function ==========

    //========== Begin Presenter Interface ==========
    override fun showLoading() {
        progressBarListPlace.visibility = View.VISIBLE
        swipeRefreshLayoutListPlace.visibility = View.INVISIBLE
    }

    override fun dismissLoading() {
        progressBarListPlace.visibility = View.INVISIBLE
        swipeRefreshLayoutListPlace.visibility = View.VISIBLE
    }

    override fun setData(listPlace: MutableList<PlaceModel>) {
        listPlaceData.clear()
        if(listPlace.isNotEmpty()){
            listPlaceData.addAll(listPlace)
            Log.d(AppConstants.TAG_DEBUG,"MainListPlaceActivity # jumlah data ${listPlaceData.size}")
            recyclerViewListPlace.post {
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun setHttpError() {

    }

    override fun setError() {

    }
    //========== End Presenter Interface ==========

}