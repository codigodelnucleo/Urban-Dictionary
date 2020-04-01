package com.demo.urbandictionary.data.remote

import com.demo.urbandictionary.data.entities.DefinitionResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val dictionaryService: DictionaryService) {
  suspend fun loadDefinitions(searchTerm: String): DefinitionResponse {
    return dictionaryService.getDefinitions(searchTerm)
  }
}