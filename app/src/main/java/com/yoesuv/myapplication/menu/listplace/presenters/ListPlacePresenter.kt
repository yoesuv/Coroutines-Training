package com.yoesuv.myapplication.menu.listplace.presenters

import com.yoesuv.myapplication.menu.listplace.contracts.ListPlaceContract
import com.yoesuv.myapplication.network.ServiceFactory
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext
import retrofit2.HttpException
import ru.gildor.coroutines.retrofit.await

class ListPlacePresenter(private val viewListPlace: ListPlaceContract.ViewListPlace): ListPlaceContract.Presenter {

    private val restApi = ServiceFactory.create()
    private val parentJob = Job()

    override fun getListPlace() {
        viewListPlace.showLoading()
        launch(CommonPool, parent = parentJob) {
            try {
                val listPlace = restApi.getListPlace().await()
                viewListPlace.setData(listPlace)
            } catch (http: HttpException) {
                withContext(UI){
                    viewListPlace.setHttpError()
                }
            } catch (error: Exception) {
                withContext(UI){
                    viewListPlace.setError()
                }
            } finally {
                withContext(UI){
                    viewListPlace.dismissLoading()
                }
            }
        }
    }

    override fun cancel() {
        parentJob.cancel()
    }

    override fun destroy() {
        parentJob.cancel()
    }

}