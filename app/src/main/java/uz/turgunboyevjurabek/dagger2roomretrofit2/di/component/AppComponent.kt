package uz.turgunboyevjurabek.dagger2roomretrofit2.di.component

import dagger.Component
import uz.turgunboyevjurabek.dagger2roomretrofit2.MainActivity
import uz.turgunboyevjurabek.dagger2roomretrofit2.di.module.DatabaseModule
import uz.turgunboyevjurabek.dagger2roomretrofit2.di.module.NetworkModule
import uz.turgunboyevjurabek.dagger2roomretrofit2.di.module.RvModule

@Component(modules = [NetworkModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)

}