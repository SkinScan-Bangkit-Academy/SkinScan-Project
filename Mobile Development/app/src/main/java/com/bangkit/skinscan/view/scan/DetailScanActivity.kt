package com.bangkit.skinscan.view.scan

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.activity.enableEdgeToEdge
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import com.bangkit.skinscan.R
import com.bangkit.skinscan.data.DiseaseData
import com.bangkit.skinscan.data.Labels
import com.bangkit.skinscan.databinding.ActivityDetailScanBinding
import com.bangkit.skinscan.ml.Model
import com.bumptech.glide.Glide
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.io.File
import java.io.IOException
import java.nio.ByteBuffer
import java.nio.ByteOrder

class DetailScanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailScanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailScanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageUri = Uri.parse(intent.getStringExtra(EXTRA_IMAGE_URI))

        if (imageUri != null) {
            Glide.with(this).load(imageUri).into(binding.imgView)
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, imageUri)
                val resizedBitmap = Bitmap.createScaledBitmap(bitmap, 150, 150, true)
                val label = classifyImage(resizedBitmap)
                binding.label.text = label

                val diseaseInfoMap = DiseaseData.getDiseaseInfoMap(this)
                val diseaseInfo = diseaseInfoMap[label]

                if (diseaseInfo != null){
                    binding.diseaseExpTv.text = diseaseInfo["explanation"] //pengertian penyakit
                    binding.drugRecTv.text = diseaseInfo["recommendation"] //rekomendasi obat
                    binding.diseasePrevTv.text = diseaseInfo["prevention"] //pencegahan penyakit
                } else {
                    binding.diseaseExpTv.text = getString(R.string.details_unavailable)
                    binding.drugRecTv.text = getString(R.string.drug_recommend_unavailable)
                    binding.diseasePrevTv.text = getString(R.string.preventive_unavailable)
                }

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun classifyImage(bitmap: Bitmap): String {
        val byteBuffer = convertBitmapToByteBuffer(bitmap)

        // Load your TFLite model
        val model = Model.newInstance(this)

        // Create input for reference
        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 150, 150, 3), DataType.FLOAT32)
        inputFeature0.loadBuffer(byteBuffer)

        // Runs model inference and gets result
        val outputs = model.process(inputFeature0)
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer


        // Releases model resources if no longer used
        model.close()

        return getLabelFromOutput(outputFeature0)
    }

    private fun convertBitmapToByteBuffer(bitmap: Bitmap): ByteBuffer {
        val byteBuffer = ByteBuffer.allocateDirect(4 * 150 * 150 * 3)
        byteBuffer.order(ByteOrder.nativeOrder())

        val intValues = IntArray(150 * 150)
        bitmap.getPixels(intValues, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)

        var pixel = 0
        for (i in 0 until 150) {
            for (j in 0 until 150) {
                val value = intValues[pixel++]

                byteBuffer.putFloat(((value shr 16 and 0xFF) / 255.0f))
                byteBuffer.putFloat(((value shr 8 and 0xFF) / 255.0f))
                byteBuffer.putFloat(((value and 0xFF) / 255.0f))
            }
        }
        return byteBuffer
    }

    private fun getLabelFromOutput(output: TensorBuffer): String {
        val outputArray = output.floatArray
        val maxIndex = outputArray.indices.maxByOrNull { outputArray[it] } ?: -1
        return  if (maxIndex != -1) Labels.diseaseLabels[maxIndex] else "Unknown"
    }

    companion object {
        const val EXTRA_IMAGE_URI = "extra_image_uri"
    }
}