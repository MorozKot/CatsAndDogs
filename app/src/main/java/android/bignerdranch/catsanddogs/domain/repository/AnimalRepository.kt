package android.bignerdranch.catsanddogs.domain.repository

interface AnimalRepository {

    suspend fun getDogResponse(): GetDogsResult

    suspend fun getCatResponse(): GetCatsResult
}
