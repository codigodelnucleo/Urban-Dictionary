package com.demo.urbandictionary.data.entities

import com.google.gson.annotations.SerializedName

data class Definition(
  @SerializedName("definition") val definition: String,
  @SerializedName("thumbs_up") val thumbs_up: Int,
  @SerializedName("thumbs_down") val thumbs_down: Int,
  @SerializedName("author") val author: String
)