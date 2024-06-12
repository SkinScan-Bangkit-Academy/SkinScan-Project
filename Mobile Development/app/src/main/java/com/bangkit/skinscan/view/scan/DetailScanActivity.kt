package com.bangkit.skinscan.view.scan

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.activity.enableEdgeToEdge
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bangkit.skinscan.R
import com.bangkit.skinscan.databinding.ActivityDetailScanBinding
import com.bangkit.skinscan.helper.ImageClassifierHelper
import com.bangkit.skinscan.ml.Model
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import org.tensorflow.lite.task.vision.classifier.Classifications
import java.io.File
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
        imageUri?.let {
            Log.d("Image URI", "showImage: $it")
            val imageFile = File(it.path!!)
            val bitmap = BitmapFactory.decodeFile(imageFile.absolutePath)
            binding.imgView.setImageBitmap(bitmap)

            val resizedBitmap = Bitmap.createScaledBitmap(bitmap, 150, 150, true)
            val label = classifyImage(resizedBitmap)
            binding.label.text = label
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
        return  if (maxIndex != -1) labels[maxIndex] else "Unknown"
    }

    companion object {
        const val EXTRA_IMAGE_URI = "extra_image_uri"
        val labels = arrayOf("Dermatitis Atopik", "Eksim", "Infeksi Jamur", "Infeksi Virus",
                "Karsinoma Sel Basal", "Kutil", "Melanoma", "Psoriasis", "Tahi Lalat", "Tumor Jinak")
    }
}