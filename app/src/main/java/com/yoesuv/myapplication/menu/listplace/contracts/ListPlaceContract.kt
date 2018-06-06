package com.yoesuv.myapplication.menu.listplace.contracts

import com.yoesuv.myapplication.menu.listplace.models.PlaceModel

class ListPlaceContract {

    interface ViewListPlace{
        fun showLoading()
        fun dismissLoading()
        fun setData(listPlace: MutableList<PlaceModel>)
        fun setHttpError()
        fun setError()
    }

    interface Presenter{
        fun getListPlace()
        fun cancel()
        fun destroy()
    }
}