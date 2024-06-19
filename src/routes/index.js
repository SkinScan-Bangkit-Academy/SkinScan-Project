const express = require('express');
const router = express.Router();
const firebaseAuthController = require('../controllers/firebase-auth-controller');
const article = require('../controllers/article');

router.get('/', (req, res) => {
  res.status(200).json({
    status: 'success',
    message: 'Welcome to SkinScan API',
  });
});

router.get('/api', (req, res) => {
  try {
    res.status(200).json({
      status: 'success',
      data: [],
      message: 'Welcome to API Page',
    });
  } catch (e) {
    res.status(500).json({
      status: 'error',
      message: 'Internal Server Error',
    });
  }
});

router.post('/register', firebaseAuthController.registerUser);
router.post('/login', firebaseAuthController.loginUser);
router.post('/logout', firebaseAuthController.logoutUser);
router.post('/reset-password', firebaseAuthController.resetPassword);
router.get('/username', firebaseAuthController.getUsername);
router.get('/article', article.getArticle);

module.exports = router;