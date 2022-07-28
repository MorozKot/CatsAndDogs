package android.bignerdranch.catsanddogs.data.network

import android.bignerdranch.catsanddogs.data.network.model.DogsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiDogs {
    @GET("api/breeds/image/random/10")
    suspend fun dogsResponse(): Response<DogsResponse>
}
