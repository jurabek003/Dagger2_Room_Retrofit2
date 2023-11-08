package uz.turgunboyevjurabek.dagger2roomretrofit2

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.content.Context
import android.content.DialogInterface.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.google.android.material.bottomsheet.BottomSheetDialog
import uz.turgunboyevjurabek.dagger2roomretrofit2.adapter.RvAdapter
import uz.turgunboyevjurabek.dagger2roomretrofit2.checkNetwork.NetworkCheck
import uz.turgunboyevjurabek.dagger2roomretrofit2.dataBase.AppDataBase
import uz.turgunboyevjurabek.dagger2roomretrofit2.dataBase.dao.UserDao
import uz.turgunboyevjurabek.dagger2roomretrofit2.databinding.ActivityMainBinding
import uz.turgunboyevjurabek.dagger2roomretrofit2.databinding.DialogItemBinding
import uz.turgunboyevjurabek.dagger2roomretrofit2.di.module.RvModule
import uz.turgunboyevjurabek.dagger2roomretrofit2.madels.Client_Post
import uz.turgunboyevjurabek.dagger2roomretrofit2.madels.Clients_Get
import uz.turgunboyevjurabek.dagger2roomretrofit2.madels.Requre_Post
import uz.turgunboyevjurabek.dagger2roomretrofit2.utils.Recourse
import uz.turgunboyevjurabek.dagger2roomretrofit2.utils.Status
import uz.turgunboyevjurabek.dagger2roomretrofit2.utils.Status.*
import uz.turgunboyevjurabek.dagger2roomretrofit2.vm.ViewModule
import javax.inject.Inject

@Suppress("UNUSED_EXPRESSION")
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

    var isAllFabsVisible: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        rvAddFun()

        binding.btnAdd.shrink()

        binding.floatingActionButton1.visibility=View.GONE
        binding.floatingActionButton2.visibility=View.GONE

        isAllFabsVisible=false


        fabfun()
    }

    private fun fabfun() {
        binding.btnAdd.setOnClickListener{

            isAllFabsVisible=if(!isAllFabsVisible!!){
                binding.floatingActionButton1.visibility=View.VISIBLE
                binding.floatingActionButton2.visibility=View.VISIBLE
                binding.btnAdd.extend()
                true
            }else{
                binding.floatingActionButton1.visibility=View.GONE
                binding.floatingActionButton2.visibility=View.GONE
                binding.btnAdd.shrink()
                false
            }
        }

        val dialog=BottomSheetDialog(this)
        val dialogItemBinding=DialogItemBinding.inflate(layoutInflater)
        dialog.setContentView(dialogItemBinding.root)

        binding.floatingActionButton2.setOnClickListener {
            dialog.show()
        }

        dialogItemBinding.btnDialogSave.setOnClickListener {
            val requrePost=Requre_Post("fam","ism","quqon","901234567",123)
            addPost(requrePost)
            dialog.cancel()
        }

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

    private fun addPost(requrePost: Requre_Post){

        viewModule.postClient(requrePost).observe(this){
            when(it.status){
                LOADING -> Toast.makeText(this, "Yuklanmoqda...", Toast.LENGTH_SHORT).show()
                ERROR -> Toast.makeText(this, "Hatolik yuzberdi :( ${it.massage}", Toast.LENGTH_SHORT).show()
                SUCCESS -> Toast.makeText(this, "Yuklandi :)", Toast.LENGTH_SHORT).show()
            }
        }
    }
}