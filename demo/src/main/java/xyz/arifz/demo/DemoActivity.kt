package xyz.arifz.demo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import xyz.arifz.demo.databinding.ActivityDemoBinding

class DemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupSpinner()
        initListener()
    }

    private fun setupSpinner() {
        val datas = arrayOf("Male", "Female", "Others")
        binding.spn.setItems(datas)

        binding.spn.hint = "Gender"
        binding.spn.apply {
            setBoxWidth(1)
            setHintFontFamily(R.font.poppins)
            setFontSize(12f)
            setTextColor("#FF0000")
            setTextFontFamily(R.font.poppins)
        }

        binding.spn.text = "Female"

        binding.spn.onItemClickListener { _, _, _, _ ->
            Log.v(
                "Hello",
                "onItemClickListener"
            )
        }
    }

    private fun initListener() {
        binding.btn.setOnClickListener {
            val txt = binding.spn.text
            if (txt.isNullOrEmpty()) {
                Toast.makeText(this, txt ?: "empty", Toast.LENGTH_SHORT).show()
                binding.spn.error = "Error occurred"
            } else {
                binding.spn.text = null
            }
        }
    }

}