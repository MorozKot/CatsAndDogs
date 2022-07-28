package android.bignerdranch.catsanddogs.domain

import android.bignerdranch.catsanddogs.domain.repository.AnimalRepository
import javax.inject.Inject

class CatsUseCase @Inject constructor(private val repository: AnimalRepository) {
    suspend fun getCatsResult() = repository.getCatResponse()
}
