package com.demo.urbandictionary.data.remote

import com.demo.urbandictionary.BuildConfig
import com.demo.urbandictionary.data.entities.DefinitionResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface DictionaryService {

  @Headers(BuildConfig.RAPID_HOST_API, BuildConfig.RAPID_KEY_API)
  @GET("/define")
  suspend fun getDefinitions(@Query("term") term: String): DefinitionResponse
}