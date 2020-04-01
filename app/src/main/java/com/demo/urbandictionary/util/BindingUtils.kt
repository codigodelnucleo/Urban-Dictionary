package com.demo.urbandictionary.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.demo.urbandictionary.data.entities.Definition
import com.demo.urbandictionary.view.main.recycler.DefinitionAdapter

object BindingUtils {

  @JvmStatic
  @BindingAdapter("definitions")
  fun definitions(recyclerView: RecyclerView, definitions: List<Definition>?) {
    val adapter = recyclerView.adapter as? DefinitionAdapter
    adapter?.submitList(definitions)
    println("TAG_ " + definitions)
  }
}