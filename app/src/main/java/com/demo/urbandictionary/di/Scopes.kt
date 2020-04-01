package com.demo.urbandictionary.di

import javax.inject.Scope

interface Scopes {

  @Scope
  @Retention(AnnotationRetention.RUNTIME)
  annotation class ActivityScope
}