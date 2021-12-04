package com.yameen.contreyandflaghw.internet

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class AllData(val error:Boolean,val msg :String, val data: List<DataItem>)
data class DataItem(val name: String,val flag:String)