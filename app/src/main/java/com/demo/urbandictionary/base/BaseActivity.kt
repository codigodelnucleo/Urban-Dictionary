package com.demo.urbandictionary.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.demo.urbandictionary.DictionaryApp
import com.demo.urbandictionary.di.ApplicationComponent

abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : AppCompatActivity() {

  protected abstract val layoutId: Int
  protected abstract val bindingVariable: Int
  protected lateinit var viewModel: V

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layoutId)

    injectDependencies((application as DictionaryApp).applicationComponent)

    setViewModel()
    performDataBinding()
  }

  private fun performDataBinding() {
    val viewDataBinding = DataBindingUtil.setContentView<T>(this, layoutId)
    viewDataBinding.lifecycleOwner = this
    viewDataBinding.setVariable(bindingVariable, viewModel)
    viewDataBinding.executePendingBindings()
  }

  abstract fun injectDependencies(applicationComponent: ApplicationComponent)
  abstract fun setViewModel()
}