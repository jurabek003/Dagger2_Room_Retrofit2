package uz.turgunboyevjurabek.dagger2roomretrofit2.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import uz.turgunboyevjurabek.dagger2roomretrofit2.dataBase.AppDataBase
import uz.turgunboyevjurabek.dagger2roomretrofit2.dataBase.dao.UserDao
import javax.inject.Singleton
@Module
class DatabaseModule(var context: Context) {


    @Singleton
    @Provides
    fun provideAppDataBase(context: Context):AppDataBase{
        return Room.databaseBuilder(context,AppDataBase::class.java,"my_db2")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideContext():Context=context

    @Singleton
    @Provides
    fun provideUserDao(appDataBase: AppDataBase):UserDao{
        return appDataBase.userDao()
    }


}