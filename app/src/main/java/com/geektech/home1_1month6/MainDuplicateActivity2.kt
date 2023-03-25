package com.geektech.home1_1month6

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.geektech.home1_1month6.databinding.ActivityMainDuplicate2Binding

class MainDuplicateActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMainDuplicate2Binding
    private val launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK
            && result.data != null
        ) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainDuplicate2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.etInputText.setText(getIntent().getStringExtra("data"))
        binding.btnNextActivity.setOnClickListener{
            val intentMainDupl = Intent(this@MainDuplicateActivity2, MainActivity::class.java)
            intentMainDupl.putExtra("data", binding.etInputText.text.toString())
            launcher.launch(intentMainDupl)
        }
    }

}