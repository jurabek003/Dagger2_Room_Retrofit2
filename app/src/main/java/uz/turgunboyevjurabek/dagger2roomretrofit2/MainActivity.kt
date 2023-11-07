package uz.turgunboyevjurabek.dagger2roomretrofit2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import uz.turgunboyevjurabek.dagger2roomretrofit2.adapter.RvAdapter
import uz.turgunboyevjurabek.dagger2roomretrofit2.checkNetwork.NetworkCheck
import uz.turgunboyevjurabek.dagger2roomretrofit2.dataBase.AppDataBase
import uz.turgunboyevjurabek.dagger2roomretrofit2.dataBase.dao.UserDao
import uz.turgunboyevjurabek.dagger2roomretrofit2.databinding.ActivityMainBinding
import uz.turgunboyevjurabek.dagger2roomretrofit2.di.module.RvModule
import uz.turgunboyevjurabek.dagger2roomretrofit2.madels.Clients_Get
import uz.turgunboyevjurabek.dagger2roomretrofit2.utils.Recourse
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

     @Inject
     lateinit var userDao: UserDao


    @Inject
    lateinit var context: Context

    lateinit var networkCheck: NetworkCheck

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

                ERROR -> {
                    Log.d("XATO",it.massage!!)
                    Toast.makeText(this, "error ga tushdi", Toast.LENGTH_SHORT).show()


                    // enternet bor yoki yuqligini tekshiradi yuq bulsa roomdan userlarni olibkeladi
                    networkCheck=NetworkCheck()
                    if (!networkCheck.isNetworkAvailable(this)) {
                        rvAdapter.updateData(userDao.getAllUsers())
                        binding.rvAdapter.adapter=rvAdapter
                    }



                }
                SUCCESS -> {

                    rvAdapter.updateData(it.data!!)
                    binding.rvAdapter.adapter=rvAdapter

                    userDao.getAllUsers().ifEmpty {
                        Toast.makeText(this, "Bo'shakan ", Toast.LENGTH_SHORT).show()
                    val list=ArrayList<Clients_Get>()
                        list.addAll(it.data)

                        // agar api dan kelayotgan malumotlarni ichida rasmlardan biri null bolsa -
                        // - o'zimiz unga vaqtinchalik rasm berib yubormoqdamiz
                        for (i in 0 until list.size){
                            if(list[i].clientRasm==null){
                                list[i].clientRasm= R.drawable.ic_launcher_foreground.toString()
                            }
                        }
                        userDao.addUser(list)
                    }

                }
            }

        }
    }
}