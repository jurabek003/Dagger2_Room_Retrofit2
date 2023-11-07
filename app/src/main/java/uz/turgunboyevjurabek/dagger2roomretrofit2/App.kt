package uz.turgunboyevjurabek.dagger2roomretrofit2

import android.app.Application
import uz.turgunboyevjurabek.dagger2roomretrofit2.di.component.AppComponent
import uz.turgunboyevjurabek.dagger2roomretrofit2.di.component.DaggerAppComponent
import uz.turgunboyevjurabek.dagger2roomretrofit2.di.module.DatabaseModule
import uz.turgunboyevjurabek.dagger2roomretrofit2.di.module.NetworkModule
import uz.turgunboyevjurabek.dagger2roomretrofit2.di.module.RvModule

class App:Application() {
    companion object{
         lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent=DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .rvModule(RvModule())
            .databaseModule(DatabaseModule(applicationContext))
            .build()
    }
}