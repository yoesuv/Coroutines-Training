package com.yoesuv.myapplication.menu.listplace.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yoesuv.myapplication.R
import com.yoesuv.myapplication.menu.listplace.models.PlaceModel
import kotlinx.android.synthetic.main.item_list_place.view.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext

class ListPlaceAdapter(private val context: Context, private var listData: MutableList<PlaceModel>): RecyclerView.Adapter<ListPlaceAdapter.ListPlaceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPlaceViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.item_list_place, parent, false)
        return ListPlaceViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ListPlaceViewHolder, position: Int) {
        val fixPos = holder.adapterPosition
        holder.setupData(listData[fixPos])
    }

    class ListPlaceViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun setupData(model: PlaceModel){
            launch {
                withContext(UI) {
                    itemView.textViewItemListPlaceName.text = model.name
                    itemView.textViewItemListPlaceLocation.text = model.location
                }
            }
        }

    }

}