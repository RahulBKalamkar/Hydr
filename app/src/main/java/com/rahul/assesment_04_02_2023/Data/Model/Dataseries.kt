package com.rahul.assesment_04_02_2023.Data.Model

import com.google.gson.annotations.SerializedName

data class Dataseries(
    @SerializedName("timepoint") var timepoint: Int? = null,
    @SerializedName("cloudcover") var cloudcover: Int? = null,
    @SerializedName("seeing") var seeing: Int? = null,
    @SerializedName("transparency") var transparency: Int? = null,
    @SerializedName("lifted_index") var liftedIndex: Int? = null,
    @SerializedName("rh2m") var rh2m: Int? = null,
    @SerializedName("wind10m") var wind10m: Wind10m? = Wind10m(),
    @SerializedName("temp2m") var temp2m: Int? = null,
    @SerializedName("prec_type") var precType: String? = null
)