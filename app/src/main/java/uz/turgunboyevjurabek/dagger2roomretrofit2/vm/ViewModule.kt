package uz.turgunboyevjurabek.dagger2roomretrofit2.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.turgunboyevjurabek.dagger2roomretrofit2.madels.Clients_Get
import uz.turgunboyevjurabek.dagger2roomretrofit2.model.repozitory.AppRepozitory
import javax.inject.Inject

class ViewModule @Inject constructor(val appRepozitory: AppRepozitory) : ViewModel() {

    private val  getAllLiveData =MutableLiveData<ArrayList<Clients_Get>>()
}