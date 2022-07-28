package android.bignerdranch.catsanddogs.di

import android.bignerdranch.catsanddogs.presentation.StartFragment
import dagger.Component

@Component(modules = [ViewModelModule::class, NetworkModule::class])
interface ApplicationComponent {

    fun inject(fragment: StartFragment)

    @Component.Factory
    interface Factory {
        fun create() : ApplicationComponent
    }
}