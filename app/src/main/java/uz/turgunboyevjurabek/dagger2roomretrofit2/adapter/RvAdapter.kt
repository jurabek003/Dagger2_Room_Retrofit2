package uz.turgunboyevjurabek.dagger2roomretrofit2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.turgunboyevjurabek.dagger2roomretrofit2.databinding.ItemRvBinding
import uz.turgunboyevjurabek.dagger2roomretrofit2.madels.Clients_Get
import javax.inject.Inject

class RvAdapter:RecyclerView.Adapter<RvAdapter.Vh>() {
    private var list=ArrayList<Clients_Get>()
    inner class Vh(val itemRvBinding: ItemRvBinding):ViewHolder(itemRvBinding.root){
        fun onBind(clientsGet: Clients_Get){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    fun updateData(newData: List<Clients_Get>){
        if (list.isNotEmpty()){
            list.clear()
        }
        list.addAll(newData)
    }
}