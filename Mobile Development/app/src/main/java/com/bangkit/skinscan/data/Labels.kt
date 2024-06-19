package com.bangkit.skinscan.data

import com.bangkit.skinscan.R
import java.util.*

object Labels {
    val labels = arrayOf(
        "Dermatitis Atopik", "Eksim", "Infeksi Jamur", "Infeksi Virus",
        "Karsinoma Sel Basal", "Kutil", "Melanoma", "Psoriasis", "Tahi Lalat", "Tumor Jinak"
    )

    val diseaseLabels = arrayOf(
        R.string.atopic_dermatitis,
        R.string.eczema,
        R.string.fungal_infections,
        R.string.viral_infections,
        R.string.basal_cell_carcinoma,
        R.string.warts,
        R.string.melanoma,
        R.string.psoriasis,
        R.string.moles,
        R.string.benign_tumors
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

    val diseaseAbout = arrayOf(
        R.string.dermatitis_about,
        R.string.eksim_about,
        R.string.infeksi_jamur_about,
        R.string.infeksi_virus_about,
        R.string.karsinoma_sel_basal_about,
        R.string.kutil_about,
        R.string.melanoma_about,
        R.string.psoriasis_about,
        R.string.tahi_lalat_about,
        R.string.tumor_jinak_about
        )

    val listData: ArrayList<Disease>
        get() {
            val list = arrayListOf<Disease>()
            for (position in diseaseLabels.indices){
                val disease = Disease()
                disease.name = diseaseLabels[position]
                disease.img = diseaseImg[position]
                disease.about = diseaseAbout[position]
                list.add(disease)
            }
            return list
        }
}