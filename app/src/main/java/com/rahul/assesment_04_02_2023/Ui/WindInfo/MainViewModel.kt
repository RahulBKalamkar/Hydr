package com.rahul.assesment_04_02_2023.Ui.WindInfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahul.assesment_04_02_2023.Data.Model.Dataseries
import com.rahul.assesment_04_02_2023.Data.Repository.WindInformationRepository
import com.rahul.assesment_04_02_2023.Utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MainViewModel(private val windInformationRepository: WindInformationRepository) :
    ViewModel() {

    private val _dataList = MutableStateFlow<Resource<List<Dataseries>>>(Resource.loading())

    val dataList: StateFlow<Resource<List<Dataseries>>> = _dataList

    init {
        fetchTopHeadlines()
    }

    private fun fetchTopHeadlines() {
        viewModelScope.launch {
            windInformationRepository.getTopHeadlines("113.2", "23.1")
                .catch { e ->
                    _dataList.value = Resource.error(e.toString())
                }
                .collect {
                    _dataList.value = Resource.success(it)
                }
        }
    }

}