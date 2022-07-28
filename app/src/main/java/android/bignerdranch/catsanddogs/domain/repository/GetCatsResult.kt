package android.bignerdranch.catsanddogs.domain.repository

import android.bignerdranch.catsanddogs.data.network.model.CatsResponse

sealed class GetCatsResult(open val error: String? = null) {
    data class Success(val response: CatsResponse): GetCatsResult()
    data class ConnectionError(override val error: String? = null) : GetCatsResult(error = error)
    data class ServerError(override val error: String? = null) : GetCatsResult(error = error)
    data class EnqueueError(override val error: String? = null) : GetCatsResult(error = error)
}
