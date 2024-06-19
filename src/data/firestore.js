// const Firestore = require('@google-cloud/firestore');
// const path = require('path');

// const firestore = new Firestore({
//     projectId: 'skinscan-capstone',
//     keyFilename: path.join(__dirname, '../../service-account.json') // Gunakan path string langsung ke file JSON
// });

// module.exports = { firestore };
const Firestore = require('@google-cloud/firestore');
const path = require('path');

const firestore = new Firestore({
    projectId: 'skinscan-capstone',
    keyFilename: path.join(__dirname, '../../service-account.json')  // Path ini harus benar
});

module.exports = { firestore };
