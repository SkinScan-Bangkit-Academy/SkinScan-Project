package com.bangkit.skinscan.view.main

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.bangkit.skinscan.databinding.ActivityHomeBinding
import com.bangkit.skinscan.utils.getImageUri
import com.bangkit.skinscan.view.ViewModelFactory
import com.bangkit.skinscan.view.camera.CameraActivity
import com.bangkit.skinscan.view.login.LoginActivity
import com.bangkit.skinscan.view.scan.DetailScanActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private var currentImageUri: Uri? = null

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ){isGranted: Boolean ->
            if (isGranted){
                Toast.makeText(this, "Permission request granted", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Permission request Denied", Toast.LENGTH_LONG).show()
            }
        }
    private fun allPermissionsGranted() =
        ContextCompat.checkSelfPermission(
            this,
            REQUIRED_PERMISSION
        ) == PackageManager.PERMISSION_GRANTED
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (!allPermissionsGranted()){
            requestPermissionLauncher.launch(REQUIRED_PERMISSION)
        }
        binding.square.setOnClickListener { startCameraX() }
//        binding.profile.setOnClickListener {
//            val intent = Intent(this@HomeActivity, )
//        }
    }

    private fun startGallery() {
        launcherGallery.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }
    private val launcherGallery = registerForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ){ uri: Uri? ->
        if (uri != null){
            currentImageUri = uri
            moveToResult(uri)
        } else {
            Log.d("Photo Picker", "No media selected")
        }
    }

    //camera
//    private fun startCamera(){
//        currentImageUri = getImageUri(this)
//        launcherIntentCamera.launch(currentImageUri)
//    }

    private val launcherIntentCamera = registerForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { isSuccess ->
        if (isSuccess){
            currentImageUri?.let {
                moveToResult(it)
            }
        }
    }

    private fun moveToResult(uri: Uri){
        val intent = Intent(this, DetailScanActivity::class.java)
        intent.putExtra(DetailScanActivity.EXTRA_IMAGE_URI, uri.toString())
        startActivity(intent)
    }

    //camerax
    private fun startCameraX(){
        val intent = Intent(this, CameraActivity::class.java)
        startActivityForResult(intent, CAMERA_REQUEST_CODE)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == CameraActivity.CAMERAX_RESULT) {
            val imageUriString = data?.getStringExtra(CameraActivity.EXTRA_CAMERAX_IMAGE)
            imageUriString?.let {
                moveToResult(Uri.parse(it))
            }
        }
    }

    companion object{
        private const val REQUIRED_PERMISSION = Manifest.permission.CAMERA
        private const val CAMERA_REQUEST_CODE = 1
    }
}