package com.demo.urbandictionary.view.main.di

import com.demo.urbandictionary.di.ApplicationComponent
import com.demo.urbandictionary.di.Scopes
import com.demo.urbandictionary.view.main.MainActivity
import dagger.Component

@Scopes.ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [HomeModule::class])
interface HomeComponent {
  fun inject(mainActivity: MainActivity)
}