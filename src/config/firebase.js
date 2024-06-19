require("dotenv").config();
const firebase = require("firebase/app");

const firebaseConfig = {
    apiKey: "AIzaSyAPja2Vy6E21t-0-x35LHc_Su_UUAqZX9U",
    authDomain: "skinscan-capstone.firebaseapp.com",
    projectId: "skinscan-capstone",
    storageBucket: "skinscan-capstone.appspot.com",
    messagingSenderId: "706758131044",
    appId: "1:706758131044:web:6528344fda1bf7d5710e71"
};

const { 
    getAuth, 
    createUserWithEmailAndPassword, 
    signInWithEmailAndPassword, 
    signOut, 
    sendEmailVerification, 
    sendPasswordResetEmail,
    updateProfile,
  } = require("firebase/auth") ;


firebase.initializeApp(firebaseConfig);

const admin = require('firebase-admin');
const serviceAccount = require('../../skinscancapstone-firebase-adminsdk-76kxp-6c8f5c025a.json')

admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
});

module.exports = {
    getAuth,
    signInWithEmailAndPassword,
    createUserWithEmailAndPassword,
    signOut,
    sendEmailVerification,
    sendPasswordResetEmail,
    updateProfile,
    admin,
  };