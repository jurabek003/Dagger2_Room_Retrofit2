package uz.turgunboyevjurabek.dagger2roomretrofit2.madels


import com.google.gson.annotations.SerializedName

data class Requre_Post(
    @SerializedName("ism")
    val ism: String,
    @SerializedName("fam")
    val fam: String,
    @SerializedName("manzil")
    val manzil: String,
    @SerializedName("tel")
    val tel: String,
    @SerializedName("umumiy_summa")
    val umumiySumma: Int
)