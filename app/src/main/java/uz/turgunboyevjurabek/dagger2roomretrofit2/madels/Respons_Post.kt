package uz.turgunboyevjurabek.dagger2roomretrofit2.madels


import com.google.gson.annotations.SerializedName

data class Respons_Post(
    @SerializedName("client_rasm")
    val clientRasm: String,
    @SerializedName("fam")
    val fam: String,
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