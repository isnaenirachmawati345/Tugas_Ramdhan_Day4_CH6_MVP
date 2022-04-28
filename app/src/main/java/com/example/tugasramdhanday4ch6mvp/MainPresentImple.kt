package com.example.tugasramdhanday4ch6mvp

import android.text.TextUtils

class MainPresentImple(private  val view: MainView): MainPresenter {
   private val HASIL  = mutableListOf<hasilHitung>()
    //private val KATEGORI = mutableListOf<Kategori>()
    override fun inputBmi(beratBadan: String, tinggiBadan: String) {
//        val tinggiCm = tinggiBadan.toDouble() / 100
//        val bmi = beratBadan.toDouble() / (tinggiCm * tinggiCm)
        if (TextUtils.isEmpty(beratBadan.toString()) || TextUtils.isEmpty(tinggiBadan.toString()) || TextUtils.isEmpty(tinggiBadan.toString())) {
            view.showMessage("Field tidak boleh Kosong")
//        when {
//            bmi < 20.5 -> Kategori.KURUS
//            bmi >= 27.0 -> Kategori.GEMUK
//            else -> Kategori.IDEAL
//        }
        }else{
            val tinggiCm = tinggiBadan.toDouble() / 100
            val bmi = beratBadan.toDouble() / (tinggiCm * tinggiCm)
//                when {
//                    bmi < 18.5 -> Kategori.KURUS
//                    bmi >= 25.0 -> Kategori.GEMUK
//                    else -> Kategori.IDEAL
//                }
            HASIL.run {
                add(hasilHitung(bmi))
            }
            view.showMessage("Hasil Perhitungan : $bmi")
            view.clearField()
    }
    }

    override fun clearHasil() {
        if (HASIL.size !=0){
            HASIL.clear()
            view.showMessage("Data Berhasil Dihapus")
        }else{
            view.showMessage("Sorry Data Memang kosong !!")
        }
    }

    override fun loadHasil() {
        if (HASIL.size == 0){
            view.showMessage("Data Kosong")
        } else{
            var allData = ""
            for (i in 0 until HASIL.size){
                allData += "Hasil : " + HASIL[i].hasilHitung + "\n\n"
            }
            allData += "Kesimpulan : " + HASIL.size
            view.showData(allData)
        }
    }
}