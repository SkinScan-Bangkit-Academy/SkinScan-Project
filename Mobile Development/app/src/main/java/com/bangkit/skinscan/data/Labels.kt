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

    val diseaseAbout = arrayOf(
        "Atopic dermatitis is a chronic condition that causes the skin to become red, itchy, and inflamed. It usually begins in childhood and can continue into adulthood.\n" +
                "Atopic dermatitis was first identified as a medical condition in the early 20th century. Researchers have found a link between atopic dermatitis, asthma, and hay fever, known as the \"atopic march.\"",
        "Eczema is a general term for various skin conditions that cause inflammation, redness, and itching. It is most commonly used to describe atopic dermatitis.\n" +
                "Eczema has been known since ancient times, with references found in Greek and Roman medical texts. Modern treatments for eczema began to develop rapidly in the 20th century with the discovery of topical corticosteroids.",
        "Fungal infections of the skin are caused by various types of fungi and can affect the skin, hair, and nails. Common examples include ringworm and athlete's foot.\n" +
                "Fungal infections have been known since ancient times, with archaeological evidence showing treatment of skin fungi in Ancient Egypt. Modern science about fungal infections advanced rapidly in the 19th century with the invention of the microscope and the identification of fungal organisms.",
        "Viral skin infections can be caused by various viruses, including herpes simplex virus (HSV), human papillomavirus (HPV), and poxvirus. Symptoms vary depending on the infecting virus.\n" +
                "Research on viral skin infections developed in the 20th century with the emergence of virology as a scientific discipline. Vaccines and antivirals were developed to combat various viral skin infections.",
        "Basal cell carcinoma is the most common type of skin cancer, usually appearing as a small, shiny bump on sun-exposed skin.\n" +
                "Basal cell carcinoma was first medically described in the 19th century. Improved understanding of the link between UV exposure and skin cancer has driven the development of prevention and treatment strategies.",
        "Warts are skin growths caused by an infection with the human papillomavirus (HPV). They can appear on various parts of the body.\n" +
                "Warts have been known since ancient times, with traditional treatments found in various cultures. Modern research on HPV and the development of the HPV vaccine occurred in the late 20th century.",
        "Melanoma is a type of skin cancer that develops from melanocytes, the cells that produce skin pigment. Melanoma is the most serious form of skin cancer.\n" +
                "Melanoma was first recognized as a medical entity in the 19th century. Modern research has led to a better understanding of the genetics and risk factors for melanoma, as well as the development of immunotherapy.",
        "Psoriasis is a chronic skin condition that causes skin cells to multiply rapidly, resulting in thick, red, and scaly patches.\n" +
                "Psoriasis has been known since ancient times, but it was not until the 19th century that the condition began to be understood more deeply. Modern therapies include the use of biologic drugs that target the immune system.",
        "Moles are skin growths that are usually brown or black and consist of clusters of melanocytes. Most moles are harmless, but some can develop into melanoma.\n" +
                "Moles have been known and observed throughout human history. Modern research emphasizes the importance of monitoring moles for early signs of melanoma.",
        "Benign tumors are non-cancerous growths that can occur on the skin. They do not spread to other parts of the body and are usually not harmful.\n" +
                "The study of benign tumors has existed since the 19th century, with an improved understanding of the differences between benign and malignant tumors aiding in diagnosis and treatment."
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