package android.bignerdranch.catsanddogs.di

import android.bignerdranch.catsanddogs.presentation.viewmodel.AnimalViewModel
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AnimalViewModel::class)
    fun bindAnimalViewModel(impl: AnimalViewModel): ViewModel
}