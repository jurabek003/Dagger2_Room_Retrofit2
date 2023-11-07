package uz.turgunboyevjurabek.dagger2roomretrofit2.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import uz.turgunboyevjurabek.dagger2roomretrofit2.madels.Clients_Get
import uz.turgunboyevjurabek.dagger2roomretrofit2.utils.Recourse

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(list:ArrayList<Clients_Get>)

    @Query("select *from Clients_Get")
    fun getAllUsers():List<Clients_Get>


}