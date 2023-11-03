package uz.turgunboyevjurabek.dagger2roomretrofit2.di.module

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.turgunboyevjurabek.dagger2roomretrofit2.model.network.ApiService
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(baseUrl:String,gsonConvertor: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConvertor)
            .build()
    }

    @Singleton
    @Provides
    fun provideGsonConvertor():GsonConverterFactory=GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideBaseUrl():String="https://api111.pythonanywhere.com/"

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}