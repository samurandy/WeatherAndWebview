package com.example.weatherwebview.data.network.model

import com.google.gson.annotations.SerializedName


data class Minutely (

  @SerializedName("dt"            ) var dt            : Int? = null,
  @SerializedName("precipitation" ) var precipitation : Int? = null

)