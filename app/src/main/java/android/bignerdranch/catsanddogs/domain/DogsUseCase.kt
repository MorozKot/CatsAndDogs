package android.bignerdranch.catsanddogs.domain

import android.bignerdranch.catsanddogs.domain.repository.AnimalRepository
import javax.inject.Inject

class DogsUseCase @Inject constructor(private val repository: AnimalRepository) {
    suspend fun getDogsResult() = repository.getDogResponse()
}