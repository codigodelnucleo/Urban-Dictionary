package com.demo.urbandictionary.data.entities

import com.google.gson.annotations.SerializedName

data class DefinitionResponse(
  @SerializedName("list") val definitions: List<Definition>
)