package com.demo.urbandictionary.view.main.recycler

import androidx.recyclerview.widget.DiffUtil
import com.demo.urbandictionary.data.entities.Definition

class DefinitionDiffItemCallback : DiffUtil.ItemCallback<Definition>() {
  override fun areItemsTheSame(oldItem: Definition, newItem: Definition) = oldItem === newItem

  override fun areContentsTheSame(oldItem: Definition, newItem: Definition) = oldItem == newItem
}
