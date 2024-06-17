package com.bangkit.skinscan.data

import com.bangkit.skinscan.R
import java.util.*

object Labels {
    val diseaseLabels = arrayOf(
        "Dermatitis Atopik", "Eksim", "Infeksi Jamur", "Infeksi Virus",
        "Karsinoma Sel Basal", "Kutil", "Melanoma", "Psoriasis", "Tahi Lalat", "Tumor Jinak"
    )

    val diseaseImg = arrayOf(
        R.drawable.dermatitis_atopik,
        R.drawable.eksim,
        R.drawable.infeksi_jamur,
        R.drawable.infeksi_virus,
        R.drawable.karsinoma,
        R.drawable.kutil,
        R.drawable.melanoma,
        R.drawable.psoriasis,
        R.drawable.tahi_lalat,
        R.drawable.tumor_jinak
    )

    val listData: ArrayList<Disease>
        get() {
            val list = arrayListOf<Disease>()
            for (position in diseaseLabels.indices){
                val disease = Disease()
                disease.name = diseaseLabels[position]
                disease.img = diseaseImg[position]
                list.add(disease)
            }
            return list
        }
}