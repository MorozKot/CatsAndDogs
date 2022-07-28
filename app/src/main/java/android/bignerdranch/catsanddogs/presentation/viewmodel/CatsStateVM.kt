package android.bignerdranch.catsanddogs.presentation.viewmodel

import android.bignerdranch.catsanddogs.data.network.model.CatsFactDto
import android.bignerdranch.catsanddogs.domain.repository.GetCatsResult

sealed class CatsStateVM {
    data class GotCats(val list: List<CatsFactDto>): CatsStateVM()
    data class MoreCats(val more: List<CatsFactDto>?): CatsStateVM()
    object MoreCatsError: CatsStateVM()
    data class Error(val result: GetCatsResult, val msg:String?): CatsStateVM()
}