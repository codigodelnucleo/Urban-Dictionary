package com.demo.urbandictionary.view.main

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.demo.urbandictionary.base.BaseViewModel
import com.demo.urbandictionary.data.DictionaryRepository
import com.demo.urbandictionary.data.entities.Definition
import com.demo.urbandictionary.util.AppLogger
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
  private val dictionaryRepository: DictionaryRepository
) : BaseViewModel() {

  private val _definitionsLiveData = MutableLiveData<List<Definition>>()
  private val _progressLiveData = ObservableField<Boolean>()

  val searchTerm = ObservableField<String>()
  val definitionsLiveData: LiveData<List<Definition>> = _definitionsLiveData
  val progressLiveData: ObservableField<Boolean> = _progressLiveData

  fun resultListUrban() = viewModelScope.launch {
    try {
      _progressLiveData.set(true)
      val definitions = dictionaryRepository.getDefinitions(searchTerm.get().orEmpty())
      _definitionsLiveData.value = definitions

    } catch (e: Exception) {
      AppLogger.e(e, "Couldn't fetch definitions")
    }
    finally {
      _progressLiveData.set(false)
    }
  }

  fun sortByPopularity(thumbsUp: Boolean) {
    _progressLiveData.set(true)
    val definitions = _definitionsLiveData.value.orEmpty()
    _definitionsLiveData.value = definitions.sortedByDescending { if (thumbsUp) it.thumbs_up else it.thumbs_down }
    _progressLiveData.set(false)
  }

}