package android.bignerdranch.catsanddogs.di

import android.bignerdranch.catsanddogs.data.network.ApiCats
import android.bignerdranch.catsanddogs.data.network.ApiDogs
import android.bignerdranch.catsanddogs.data.repository.AnimalRepositoryImpl
import android.bignerdranch.catsanddogs.domain.repository.AnimalRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class NetworkModule {

    @Provides
    fun provideCatsService(@Named("Cat") retrofit: Retrofit): ApiCats =
        retrofit.create(ApiCats::class.java)

    @Provides
    @Named("Cat")
    fun retrofitCats(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://catfact.ninja/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideDogsService(@Named("Dog") retrofit: Retrofit): ApiDogs =
        retrofit.create(ApiDogs::class.java)

    @Provides
    @Named("Dog")
    fun retrofitDogs(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun bindAnimalRepository(impl: AnimalRepositoryImpl): AnimalRepository {
        return impl
    }
}