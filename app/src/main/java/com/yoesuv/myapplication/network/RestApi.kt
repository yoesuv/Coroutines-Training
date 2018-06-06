package com.yoesuv.myapplication.network

import com.yoesuv.myapplication.menu.listplace.models.PlaceModel
import retrofit2.Call
import retrofit2.http.GET


interface RestApi {

    @GET("List_place.json")
    fun getListPlace(): Call<MutableList<PlaceModel>>

}