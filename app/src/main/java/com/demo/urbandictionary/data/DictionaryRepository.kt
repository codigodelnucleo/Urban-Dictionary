package com.demo.urbandictionary.data

import com.demo.urbandictionary.data.entities.Definition
import com.demo.urbandictionary.data.local.LocalDataSource
import com.demo.urbandictionary.data.remote.RemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DictionaryRepository @Inject constructor(
  private val localDataSource: LocalDataSource,
  private val remoteDataSource: RemoteDataSource
) {

  suspend fun getDefinitions(searchTerm: String): List<Definition> {
    val definitions = localDataSource.loadDefinitions()
    return definitions.ifEmpty { getRemoteDefinitions(searchTerm) }
  }

  private suspend fun getRemoteDefinitions(searchTerm: String): List<Definition> {
    val definitionsResponse = remoteDataSource.loadDefinitions(searchTerm)
    val definitions = definitionsResponse.definitions
    localDataSource.saveDefinitions(definitions)
    return definitions
  }
}