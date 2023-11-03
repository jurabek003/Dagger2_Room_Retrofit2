package uz.turgunboyevjurabek.dagger2roomretrofit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.turgunboyevjurabek.dagger2roomretrofit2.adapter.RvAdapter
import uz.turgunboyevjurabek.dagger2roomretrofit2.databinding.ActivityMainBinding
import uz.turgunboyevjurabek.dagger2roomretrofit2.di.module.RvModule
import uz.turgunboyevjurabek.dagger2roomretrofit2.madels.Clients_Get
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    @Inject
    private lateinit var rvAdapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        rvAddFun()
    }

    private fun rvAddFun() {
    }
}