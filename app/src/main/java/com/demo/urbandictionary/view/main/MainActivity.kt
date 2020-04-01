package com.demo.urbandictionary.view.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.demo.urbandictionary.BR
import com.demo.urbandictionary.R
import com.demo.urbandictionary.base.BaseActivity
import com.demo.urbandictionary.databinding.ActivityMainBinding
import com.demo.urbandictionary.di.ApplicationComponent
import com.demo.urbandictionary.view.main.di.DaggerHomeComponent
import com.demo.urbandictionary.view.main.recycler.DefinitionAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  @Inject
  lateinit var definitionAdapter: DefinitionAdapter

  override val layoutId = R.layout.activity_main

  override val bindingVariable = BR.viewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initRecyclerView()
  }

  override fun injectDependencies(applicationComponent: ApplicationComponent) {
    DaggerHomeComponent.builder()
      .applicationComponent(applicationComponent)
      .build()
      .inject(this)
  }

  override fun setViewModel() {
    viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
  }

  private fun initRecyclerView() {
    definitionRecyclerView.adapter = definitionAdapter
  }
}