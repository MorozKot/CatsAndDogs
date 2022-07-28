package android.bignerdranch.catsanddogs.presentation.viewmodel

import android.bignerdranch.catsanddogs.data.network.model.CatsFactDto
import android.bignerdranch.catsanddogs.domain.CatsUseCase
import android.bignerdranch.catsanddogs.domain.DogsUseCase
import android.bignerdranch.catsanddogs.domain.repository.GetCatsResult
import android.bignerdranch.catsanddogs.domain.repository.GetDogsResult
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject


class AnimalViewModel @Inject constructor(
    private val catsUseCase: CatsUseCase,
    private val dogsUseCase: DogsUseCase
) : ViewModel() {

    private val _getDogsResponse: MutableLiveData<DogsStateVM?> = MutableLiveData(null)
    val getDogsResponse: LiveData<DogsStateVM?> = _getDogsResponse

    private val dogsList = mutableListOf<String>()

    private val _getCatsResponse: MutableLiveData<CatsStateVM?> = MutableLiveData(null)
    val getCatsResponse: LiveData<CatsStateVM?> = _getCatsResponse

    private val catsList = mutableListOf<CatsFactDto>()

    fun getDogs(isAdditionalLoading: Boolean = false) {
        viewModelScope.launch {
            when (val result = dogsUseCase.getDogsResult()) {
                is GetDogsResult.Success -> {
                    result.response.message.forEach {
                        if (!dogsList.contains(it)) dogsList.add(it)
                    }
                    when (isAdditionalLoading) {
                        true -> _getDogsResponse.value =
                            DogsStateVM.MoreDogs(result.response.message)
                        false -> _getDogsResponse.value = DogsStateVM.GotDogs(dogsList)
                    }
                }
                else -> {
                    if (dogsList.isEmpty()) _getDogsResponse.value =
                        DogsStateVM.Error(result, result.error)
                    else {
                        _getDogsResponse.value = DogsStateVM.MoreDogsError
                    }
                }
            }
        }
    }

    fun getCats(isAdditionalLoading: Boolean = false) {
        viewModelScope.launch {
            when (val result2 = catsUseCase.getCatsResult()) {
                is GetCatsResult.Success -> {
                    result2.response.data?.forEach {
                        if (!catsList.contains(it)) catsList.add(it)
                    }
                    when (isAdditionalLoading) {
                        true -> _getCatsResponse.value =
                            CatsStateVM.MoreCats(result2.response.data)
                        false -> _getCatsResponse.value = CatsStateVM.GotCats(catsList)
                    }
                }
                else -> {
                    if (catsList.isEmpty()) _getCatsResponse.value =
                        CatsStateVM.Error(result2, result2.error)
                    else {
                        _getCatsResponse.value = CatsStateVM.MoreCatsError
                    }
                }
            }
        }
    }

    fun loadMore() {
        getDogs(true)
        getCats(true)
    }
}