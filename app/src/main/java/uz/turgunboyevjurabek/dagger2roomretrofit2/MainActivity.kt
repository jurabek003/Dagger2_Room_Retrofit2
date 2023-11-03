package uz.turgunboyevjurabek.dagger2roomretrofit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import uz.turgunboyevjurabek.dagger2roomretrofit2.adapter.RvAdapter
import uz.turgunboyevjurabek.dagger2roomretrofit2.databinding.ActivityMainBinding
import uz.turgunboyevjurabek.dagger2roomretrofit2.di.module.RvModule
import uz.turgunboyevjurabek.dagger2roomretrofit2.madels.Clients_Get
import uz.turgunboyevjurabek.dagger2roomretrofit2.utils.Status
import uz.turgunboyevjurabek.dagger2roomretrofit2.utils.Status.*
import uz.turgunboyevjurabek.dagger2roomretrofit2.vm.ViewModule
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    @Inject
     lateinit var rvAdapter: RvAdapter

    @Inject
     lateinit var viewModule: ViewModule


    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        rvAddFun()
    }

    private fun rvAddFun() {
        viewModule.getAllClients().observe(this){it->
            when(it.status){
                LOADING -> Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()

                ERROR -> Log.d("XATO",it.massage!!)
                SUCCESS -> {
                    rvAdapter.updateData(it.data!!)
                    binding.rvAdapter.adapter=rvAdapter
                }
            }

        }
    }
}