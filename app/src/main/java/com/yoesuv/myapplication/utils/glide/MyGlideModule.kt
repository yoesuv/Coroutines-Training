package com.yoesuv.myapplication.utils.glide

import android.content.Context
import android.util.Log
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import com.yoesuv.myapplication.data.AppConstants

@GlideModule
class MyGlideModule: AppGlideModule() {

    override fun applyOptions(context: Context?, builder: GlideBuilder?) {
        Log.d(AppConstants.TAG_DEBUG,"MyGlideModule # applyOptions => init glide options")
        super.applyOptions(context, builder)
        val req = RequestOptions()
                .format(DecodeFormat.PREFER_ARGB_8888)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        builder?.setDefaultRequestOptions(req)
    }

}