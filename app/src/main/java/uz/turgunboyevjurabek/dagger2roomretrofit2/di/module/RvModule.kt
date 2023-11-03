package uz.turgunboyevjurabek.dagger2roomretrofit2.di.module

import dagger.Module
import dagger.Provides
import uz.turgunboyevjurabek.dagger2roomretrofit2.adapter.RvAdapter
import javax.inject.Singleton

@Module
class RvModule {


    @Singleton
    @Provides
    fun provideRvAdapter():RvAdapter{
        return RvAdapter()
    }


}