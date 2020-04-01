package com.demo.urbandictionary.data.local

import com.demo.urbandictionary.data.entities.Definition
import javax.inject.Inject
import javax.inject.Singleton

//TODO 3/31: Implement Room and save data when offline
@Singleton
class LocalDataSource @Inject constructor() {
  fun saveDefinitions(definitions: List<Definition>) = Unit
  fun loadDefinitions(): List<Definition> = emptyList()
}