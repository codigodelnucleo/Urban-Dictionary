package com.demo.urbandictionary.view.main.recycler

import androidx.recyclerview.widget.RecyclerView
import com.demo.urbandictionary.data.entities.Definition
import com.demo.urbandictionary.databinding.ItemRowBinding

class DefinitionViewHolder(
  private val itemRowBinding: ItemRowBinding
) : RecyclerView.ViewHolder(itemRowBinding.root) {

  fun bind(definition: Definition) {
    itemRowBinding.definition = definition
    itemRowBinding.executePendingBindings()
  }
}