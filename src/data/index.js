const Article = require('../controllers/article'); // Pastikan path ini benar

const sakitKulit = {
    docName: 'Bahaya Penyakit Kulit',
    author: 'kimia farma'
};

const save = async () => {
    try {
        await Article.save('Article', sakitKulit);
        console.log('Data should be saved now');
    } catch (error) {
        console.error('Error saving data:', error);
    }
};

save();
