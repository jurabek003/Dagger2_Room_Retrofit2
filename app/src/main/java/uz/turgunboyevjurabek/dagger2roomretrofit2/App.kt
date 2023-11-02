package uz.turgunboyevjurabek.dagger2roomretrofit2

import android.app.Application
import uz.turgunboyevjurabek.dagger2roomretrofit2.di.component.AppComponent
import uz.turgunboyevjurabek.dagger2roomretrofit2.di.component.DaggerAppComponent
import uz.turgunboyevjurabek.dagger2roomretrofit2.di.module.NetworkModule

class App:Application() {
    companion object{
         lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent=DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .build()
    }
}