package android.bignerdranch.catsanddogs.domain.repository

import android.bignerdranch.catsanddogs.data.network.model.DogsResponse

sealed class GetDogsResult(open val error: String? = null) {
    data class Success(val response: DogsResponse) : GetDogsResult()
    data class ConnectionError(override val error: String? = null) : GetDogsResult(error = error)
    data class ServerError(override val error: String? = null) : GetDogsResult(error = error)
    data class EnqueueError(override val error: String? = null) : GetDogsResult(error = error)
}
