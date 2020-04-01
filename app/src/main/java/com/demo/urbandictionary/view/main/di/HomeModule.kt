package com.demo.urbandictionary.view.main.di

import androidx.lifecycle.ViewModelProvider
import com.demo.urbandictionary.base.ViewModelFactory
import com.demo.urbandictionary.di.Scopes
import com.demo.urbandictionary.view.main.MainViewModel
import com.demo.urbandictionary.view.main.recycler.DefinitionAdapter
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

  @Scopes.ActivityScope
  @Provides
  fun createViewModelFactory(mainViewModel: MainViewModel): ViewModelProvider.Factory {
    return ViewModelFactory(mainViewModel)
  }

  @Scopes.ActivityScope
  @Provides
  fun createDefinitionAdapter(): DefinitionAdapter {
    return DefinitionAdapter()
  }
}