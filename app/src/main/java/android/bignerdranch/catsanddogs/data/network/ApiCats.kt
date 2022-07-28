package android.bignerdranch.catsanddogs.data.network

import android.bignerdranch.catsanddogs.data.network.model.CatsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiCats {
    @GET("facts?max_length=400&limit=30")
    suspend fun catsResponse(): Response<CatsResponse>
}
