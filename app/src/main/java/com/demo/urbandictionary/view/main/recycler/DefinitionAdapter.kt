package com.demo.urbandictionary.view.main.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.demo.urbandictionary.R
import com.demo.urbandictionary.extensions.inflate
import com.demo.urbandictionary.data.entities.Definition
import com.demo.urbandictionary.databinding.ItemRowBinding

class DefinitionAdapter : ListAdapter<Definition, DefinitionViewHolder>(DefinitionDiffItemCallback()) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefinitionViewHolder {
    val layoutInflater = LayoutInflater.from(parent.context)
    val itemRowBinding = ItemRowBinding.inflate(layoutInflater, parent, false)
    return DefinitionViewHolder(itemRowBinding)
  }

  override fun onBindViewHolder(holder: DefinitionViewHolder, position: Int) = holder.bind(getItem(position))
}