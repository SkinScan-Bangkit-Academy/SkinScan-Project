package com.bangkit.skinscan.view.scan

import androidx.activity.enableEdgeToEdge
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bangkit.skinscan.R
import com.bangkit.skinscan.databinding.ActivityDetailScanBinding
import com.bangkit.skinscan.helper.ImageClassifierHelper
import org.tensorflow.lite.task.vision.classifier.Classifications

class DetailScanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailScanBinding
    private lateinit var imageClassifierHelper: ImageClassifierHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailScanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageUri = Uri.parse(intent.getStringExtra(EXTRA_IMAGE_URI))
        imageUri?.let {
            Log.d("Image URI", "showImage: $it")
            binding.imgView.setImageURI(it)
            analyzeImage(it)
        }
    }

    private fun analyzeImage(uri: Uri) {
        imageClassifierHelper = ImageClassifierHelper(
            context = this,
            classifierListener = object : ImageClassifierHelper.ClassifierListener {
                override fun onError(error: String) {
                    runOnUiThread {
                        Toast.makeText(this@DetailScanActivity, error, Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onResults(results: List<Classifications>?, inferenceTime: Long) {
                    runOnUiThread {
                        results?.let {
                            if (it.isNotEmpty() && it[0].categories.isNotEmpty()){
                                println(it)
                                val displayResult = it[0].categories[0]
                                val label = displayResult.label
                                val score = displayResult.score

                                binding.label.text = getString(R.string.label, label)

                            } else {
                                binding.label.text = ""
                            }
                        }
                    }
                }

            }
        )
        imageClassifierHelper.classifyImage(uri)
    }

    companion object {
        const val EXTRA_IMAGE_URI = "extra_image_uri"
    }
}