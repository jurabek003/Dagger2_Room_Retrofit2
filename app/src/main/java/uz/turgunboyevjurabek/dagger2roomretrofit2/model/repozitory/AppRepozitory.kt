package uz.turgunboyevjurabek.dagger2roomretrofit2.model.repozitory

import uz.turgunboyevjurabek.dagger2roomretrofit2.model.network.ApiService
import javax.inject.Inject

class AppRepozitory @Inject constructor(private val apiService: ApiService){
    suspend fun getClients()=apiService.getAllClients()


}