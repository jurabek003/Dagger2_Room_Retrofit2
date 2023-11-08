package uz.turgunboyevjurabek.dagger2roomretrofit2.model.network

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import uz.turgunboyevjurabek.dagger2roomretrofit2.madels.Client_Post
import uz.turgunboyevjurabek.dagger2roomretrofit2.madels.Clients_Get
import uz.turgunboyevjurabek.dagger2roomretrofit2.madels.Requre_Post
import uz.turgunboyevjurabek.dagger2roomretrofit2.madels.Respons_Post

interface ApiService {

    @GET("clientlar/")
   suspend fun getAllClients():List<Clients_Get>

   @POST("clientlar/")
   suspend fun postClient(@Body requrePost: Requre_Post):Respons_Post


}