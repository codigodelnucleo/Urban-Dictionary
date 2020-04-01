package com.demo.urbandictionary.di

import com.demo.urbandictionary.data.DictionaryRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
  fun definitionRepository(): DictionaryRepository
}