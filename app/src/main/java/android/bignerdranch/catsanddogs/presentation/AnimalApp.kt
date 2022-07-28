package android.bignerdranch.catsanddogs.presentation

import android.app.Application
import android.bignerdranch.catsanddogs.di.DaggerApplicationComponent

class AnimalApp: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create()
    }
}