package com.rahul.assesment_04_02_2023.Data.Model

import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("product")
    var product: String? = null,
    @SerializedName("init")
    var init: String? = null,
    @SerializedName("dataseries")
    var dataseries: ArrayList<Dataseries> = arrayListOf()
)
