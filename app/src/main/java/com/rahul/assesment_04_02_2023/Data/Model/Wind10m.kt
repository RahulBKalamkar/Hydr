package com.rahul.assesment_04_02_2023.Data.Model

import com.google.gson.annotations.SerializedName


data class Wind10m (

  @SerializedName("direction" ) var direction : String? = null,
  @SerializedName("speed"     ) var speed     : Int?    = null

)