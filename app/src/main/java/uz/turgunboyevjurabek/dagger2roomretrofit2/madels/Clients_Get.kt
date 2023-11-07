package uz.turgunboyevjurabek.dagger2roomretrofit2.madels


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity
data class Clients_Get(
    @SerializedName("client_rasm")
    var clientRasm: String,
    @SerializedName("fam")
    val fam: String,

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int,

    @SerializedName("ism")
    val ism: String,
    @SerializedName("manzil")
    val manzil: String,
    @SerializedName("tel")
    val tel: String,
    @SerializedName("umumiy_summa")
    val umumiySumma: Int
)