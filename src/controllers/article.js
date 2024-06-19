const getArticle = async (req, res) => {
  try {
    const article = [
        {
            "article": {
                "title": "Penyakit Kulit: Jenis, Penyebab, dan Cara Mengatasinya",
                "image": "https://www.alodokter.com/wp-content/uploads/2019/04/Macam-macam-Penyakit-Kulit-dan-Cara-Mengatasinya.jpg",
                "date": "22 Juni 2021"
            }
        },
    
        {
            "article": {
                "title": "9 Jenis Penyakit Kulit yang Umum Terjadi dan Penyebabnya",
                "image": "https://mysiloam-api.siloamhospitals.com/public-asset/website-cms/website-cms-16687871975819012.webp",
                "date": "18 Januari 2024"
            }
        },
    
        {
            "article": {
                "title": "4 Jenis Penyakit Kulit yang Perlu Diwaspadai",
                "image": "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRBl2kZExfYo6WskCmGA_E-P0YvEqqaurGe5oQ6ufpEuxAG_8Gs",
                "date": "24 Juli 2023"
            }
        },
    
        {
            "article": {
                "title": "Penyakit Kulit yang Rentan Mewabah di Musim Kemarau",
                "image": "https://img-cdn.medkomtek.com/inoldRSK4W5ZlsftzE1SNQjB_UY=/730x411/smart/filters:quality(100):format(webp)/article/G3D1YR7OYznhyw5nRoG_i/original/076433400_1527965049-5-Penyakit-Kulit-yang-Rentan-Mewabah-di-Musim-Kemarau-By-namtipStudio-shutterstock.jpg?w=128&q=100",
                "date": "29 September 2022"
            }
        },
    
        {
            "article": {
                "title": "Apa itu Eksim? Simak Penyebab, Ciri-ciri, dan Cara Mengobatinya",
                "image": "https://mysiloam-api.siloamhospitals.com/public-asset/website-cms/website-cms-16790716121386103.webp",
                "date": "26 Januari 2024"
            }
        },
    
        {
            "article": {
                "title": "Infeksi Kulit - Penyebab, Gejala dan Pengobatannya",
                "image": "https://img-cdn.medkomtek.com/RhDNyAqtmoLs3KXbjs-zgSHyViE=/730x411/smart/filters:quality(100):format(webp)/article/a399P8469xSnoJLBsV9IS/original/096448500_1581140700-Penyebab-Munculnya-Bintik-Bening-Saat-Kulit-Gatal-Gatal-shutterstock_276199169.jpg?w=128&q=100",
                "date": "05 September 2023"
            }
        }
    ]
    res.status(200).json({ status: "success", data: article });
  } catch (error) {
    res.status(500).json({ status: "error", message: "Error getting articles", error });
  }
};

module.exports = { getArticle };

// class Article {
//     // Hapus atau tambahkan kembali constructor jika diperlukan

//     async save(collection, data) {
//         console.log(`Saving to collection: ${collection}, data: ${JSON.stringify(data)}`);
//         const docRef = firestore.collection(collection).doc(data.docName);
//         await docRef.set(data);
//         console.log('Data saved successfully');
//     }

//     async saveSubCollection(rootCol, rootDocName, subCol, subColData) {
//         const docRef = firestore.collection(rootCol).doc(rootDocName).collection(subCol).doc(subColData.docName);
//         await docRef.set(subColData);
//     }

//     async saveByPath(path, data) {
//         const docRef = firestore.doc(path);
//         await docRef.set(data);
//     }
// }
