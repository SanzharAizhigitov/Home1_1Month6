package com.geektech.home1_1month6

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.geektech.home1_1month6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
lateinit var binding: ActivityMainBinding
    private val launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK && result.data != null
        ) {
            Log.e("xvr", result.data!!.getStringExtra("data").toString())
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.etInputText.setText(getIntent().getStringExtra("data"))
        binding.btnNextActivity.setOnClickListener{
            val intentMain = Intent(this@MainActivity, MainDuplicateActivity2::class.java)
            intentMain.putExtra("data", binding.etInputText.text.toString())
            Log.e("xvr", intentMain.getStringExtra("data")!!)
            setResult(Activity.RESULT_OK, intentMain)
            launcher.launch(intentMain)}
    }


    }
