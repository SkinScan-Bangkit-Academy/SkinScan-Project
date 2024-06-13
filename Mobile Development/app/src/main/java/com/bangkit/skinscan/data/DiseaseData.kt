package com.bangkit.skinscan.data

object DiseaseData {
    val diseaseInfoMap: Map<String, Map<String, String>> = mapOf(
        "Dermatitis Atopik" to mapOf(
            "explanation" to "Atopic dermatitis is a chronic skin disease that causes inflammation, itching, and redness of the skin. It often appears in children and can persist into adulthood.",
            "recommendation" to "Moisturizing creams such as Aquaphor, CeraVe, and Eucerin. Hydrocortisone 1% cream can be used to reduce inflammation and itching.",
            "prevention" to "Avoiding triggers such as harsh soaps, detergents, and irritating clothing materials. Keeping the skin moisturized by using moisturizers after bathing. Avoiding hot showers which can dry out the skin."
        ),
        "Eksim" to mapOf(
            "explanation" to "Eczema (Eksim) is a condition that causes the skin to become red, itchy, and inflamed. It can be caused by allergies, irritants, or genetics.",
            "recommendation" to "Moisturizing creams rich in emollients like Aveeno and Cetaphil. Hydrocortisone cream to relieve itching and inflammation.",
            "prevention" to "Using mild, fragrance-free soaps. Avoiding contact with irritants such as detergents and chemicals. Keeping the skin moisturized with lotions."
        ),
        "Infeksi Jamur" to mapOf(
            "explanation" to "Fungal infections (Infeksi jamur) can occur in various parts of the body such as the feet (athlete's foot), groin (jock itch), or scalp (ringworm). Characterized by itching, redness, and scaly skin.",
            "recommendation" to "Antifungal creams like clotrimazole (Canesten) or miconazole (Daktarin). Antifungal powders can also be used to keep the area dry.",
            "prevention" to "Keeping areas prone to fungus clean and dry. Changing wet or sweaty clothes promptly. Avoiding sharing personal items like towels or shoes."
        ),
        "Infeksi virus" to mapOf(
            "explanation" to "Viral infections (Infeksi virus) on the skin include herpes simplex, chickenpox, and molluscum contagiosum. Characterized by rashes or lesions that may be painful or itchy.",
            "recommendation" to "Topical antiseptics to prevent secondary infections. Antiviral topical or oral medications may be required and need a prescription.",
            "prevention" to "Vaccination for preventable diseases like chickenpox and HPV. Avoiding direct contact with another person's lesions or rash. Practicing good hand hygiene."
        ),
        "Karsinoma Sel Basal" to mapOf(
            "explanation" to "Basal cell carcinoma is the most common type of skin cancer and usually grows slowly. Often appears as a small, flesh-colored bump or red patch that doesn't heal.",
            "recommendation" to "No over-the-counter medications are effective; medical treatment is necessary such as surgical excision, cryotherapy, or photodynamic therapy.",
            "prevention" to "Using sunscreen with high SPF daily, wearing protective clothing, and avoiding excessive sun exposure especially during peak hours."
        ),
        "Kutil" to mapOf(
            "explanation" to "Warts (Kutil) are skin growths caused by the human papillomavirus (HPV). They appear as small, hard bumps, usually on the hands or feet.",
            "recommendation" to "Products containing salicylic acid like Compound W and wart removal patches can be used to remove warts.",
            "prevention" to "Avoiding direct contact with other people's warts. Maintaining good hand hygiene and wearing footwear in public showers or pools."
        ),
        "Melanoma" to mapOf(
            "explanation" to "Melanoma is the most dangerous type of skin cancer, developing in melanocytes that produce melanin. Often appears as a new mole or changes in an existing mole.",
            "recommendation" to "No over-the-counter medications; diagnosis and treatment by a doctor are required. Treatment may include surgery, immunotherapy, or chemotherapy.",
            "prevention" to "Using sunscreen with high SPF, wearing protective clothing, and regularly checking the skin for changes in moles."
        ),
        "Psoriasis" to mapOf(
            "explanation" to "Psoriasis is an autoimmune disease that causes rapid skin cell buildup, forming scales and red patches that itch and may be painful.",
            "recommendation" to "Moisturizing creams, corticosteroid creams like hydrocortisone, and products containing salicylic acid or coal tar.",
            "prevention" to "Avoiding triggers such as stress, infections, and skin injuries. Using moisturizers regularly to keep the skin hydrated."
        ),
        "Tahi Lalat" to mapOf(
            "explanation" to "Moles (Tahi lalat) are small, dark skin growths caused by clusters of melanocytes. They are usually harmless.",
            "recommendation" to "No over-the-counter medications are necessary unless suspicious changes occur; evaluation by a doctor is needed to ensure the mole is benign.",
            "prevention" to "Avoiding excessive sun exposure and using sunscreen to protect the skin from UV damage."
        ),
        "Tumor Jinak" to mapOf(
            "explanation" to "Benign tumors (Tumor jinak) are non-cancerous growths that do not spread to other parts of the body and are usually harmless.",
            "recommendation" to "No over-the-counter medications; diagnosis and evaluation by a doctor are necessary to confirm the tumor is benign.",
            "prevention" to "Avoiding excessive sun exposure and using sunscreen to protect the skin. Maintaining overall skin health with proper care."
        )

    )
}