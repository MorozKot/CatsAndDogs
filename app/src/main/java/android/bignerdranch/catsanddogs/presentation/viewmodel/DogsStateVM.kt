package android.bignerdranch.catsanddogs.presentation.viewmodel

import android.bignerdranch.catsanddogs.domain.repository.GetDogsResult

sealed class DogsStateVM {
    data class GotDogs(val list: List<String>): DogsStateVM()
    data class MoreDogs(val more: List<String>?): DogsStateVM()
    object MoreDogsError: DogsStateVM()
    data class Error(val result: GetDogsResult, val msg:String?): DogsStateVM()
}