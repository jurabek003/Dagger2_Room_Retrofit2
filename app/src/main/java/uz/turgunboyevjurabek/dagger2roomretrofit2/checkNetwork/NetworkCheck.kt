package uz.turgunboyevjurabek.dagger2roomretrofit2.checkNetwork

import android.content.Context
import android.net.ConnectivityManager

class NetworkCheck {
     fun isNetworkAvailable(context: Context): Boolean {
             val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
             val networkInfo = connectivityManager.activeNetworkInfo
             return networkInfo != null && networkInfo.isConnected
         }

}