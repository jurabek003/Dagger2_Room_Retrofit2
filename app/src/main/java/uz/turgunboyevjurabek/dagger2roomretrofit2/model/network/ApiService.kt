package uz.turgunboyevjurabek.dagger2roomretrofit2.model.network

import retrofit2.http.GET
import uz.turgunboyevjurabek.dagger2roomretrofit2.madels.Clients_Get

interface ApiService {

    @GET("clientlar/")
   suspend fun getAllClients():List<Clients_Get>

}