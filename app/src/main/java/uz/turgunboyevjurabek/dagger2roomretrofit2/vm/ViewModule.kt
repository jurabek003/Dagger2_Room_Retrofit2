package uz.turgunboyevjurabek.dagger2roomretrofit2.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import uz.turgunboyevjurabek.dagger2roomretrofit2.madels.Clients_Get
import uz.turgunboyevjurabek.dagger2roomretrofit2.model.repozitory.AppRepozitory
import uz.turgunboyevjurabek.dagger2roomretrofit2.utils.Recourse
import javax.inject.Inject

class ViewModule @Inject constructor(val appRepozitory: AppRepozitory) : ViewModel() {

    private val  getAllLiveData =MutableLiveData<Recourse<List<Clients_Get>>>()
    init {
        getAllClients()
    }

     fun getAllClients() :MutableLiveData<Recourse<List<Clients_Get>>> {
        viewModelScope.launch {
            getAllLiveData.postValue(Recourse.loading("loading"))
            try {
                coroutineScope {
                    val list=async {
                        appRepozitory.getClients()
                    }.await()
                    getAllLiveData.postValue(Recourse.success(list))
                }
            }catch (e:Exception){
                getAllLiveData.postValue(Recourse.error(e.message))
            }
        }
        return getAllLiveData
    }
}