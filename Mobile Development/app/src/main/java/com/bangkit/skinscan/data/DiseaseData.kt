package com.bangkit.skinscan.data

import android.content.Context
import com.bangkit.skinscan.R

object DiseaseData {
    fun getDiseaseInfoMap(context: Context): Map<String, Map<String, String>> {
        return mapOf(
            "Dermatitis Atopik" to mapOf(
                "explanation" to context.getString(R.string.dermatitis_details),
                "recommendation" to context.getString(R.string.dermatitis_drug),
                "prevention" to context.getString(R.string.dermatitis_prevention)
            ),
            "Eksim" to mapOf(
                "explanation" to context.getString(R.string.eksim_details),
                "recommendation" to context.getString(R.string.eksim_drug),
                "prevention" to context.getString(R.string.eksim_prevention)
            ),
            "Infeksi Jamur" to mapOf(
                "explanation" to context.getString(R.string.infeksi_jamur_details),
                "recommendation" to context.getString(R.string.infeksi_jamur_drug),
                "prevention" to context.getString(R.string.infeksi_jamur_prevention)
            ),
            "Infeksi virus" to mapOf(
                "explanation" to context.getString(R.string.infeksi_virus_details),
                "recommendation" to context.getString(R.string.infeksi_virus_drug),
                "prevention" to context.getString(R.string.infeksi_virus_prevention)
            ),
            "Karsinoma Sel Basal" to mapOf(
                "explanation" to context.getString(R.string.karsinoma_details),
                "recommendation" to context.getString(R.string.karsinoma_drug),
                "prevention" to context.getString(R.string.karsinoma_prevention)
            ),
            "Kutil" to mapOf(
                "explanation" to context.getString(R.string.kutil_details),
                "recommendation" to context.getString(R.string.kutil_drug),
                "prevention" to context.getString(R.string.kutil_prevention)
            ),
            "Melanoma" to mapOf(
                "explanation" to context.getString(R.string.melanoma_details),
                "recommendation" to context.getString(R.string.melanoma_drug),
                "prevention" to context.getString(R.string.melanoma_prevention)
            ),
            "Psoriasis" to mapOf(
                "explanation" to context.getString(R.string.Psoriasis_details),
                "recommendation" to context.getString(R.string.proriasis_drug),
                "prevention" to context.getString(R.string.psoriasis_prevention)
            ),
            "Tahi Lalat" to mapOf(
                "explanation" to context.getString(R.string.tahi_lalat_details),
                "recommendation" to context.getString(R.string.tahi_lalat_drug),
                "prevention" to context.getString(R.string.tahi_lalat_prevention)
            ),
            "Tumor Jinak" to mapOf(
                "explanation" to context.getString(R.string.tumor_jinak_details),
                "recommendation" to context.getString(R.string.tumor_jinak_drug),
                "prevention" to context.getString(R.string.tumor_jinak_prevention)
            )

        )
    }
}