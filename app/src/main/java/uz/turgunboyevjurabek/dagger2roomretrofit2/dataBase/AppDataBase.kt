package uz.turgunboyevjurabek.dagger2roomretrofit2.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.turgunboyevjurabek.dagger2roomretrofit2.dataBase.dao.UserDao
import uz.turgunboyevjurabek.dagger2roomretrofit2.madels.Clients_Get

@Database(entities = [Clients_Get::class], version = 1)
abstract  class AppDataBase:RoomDatabase() {

    abstract fun userDao():UserDao
}