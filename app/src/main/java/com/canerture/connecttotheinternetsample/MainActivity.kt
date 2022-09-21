package com.canerture.connecttotheinternetsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.canerture.connecttotheinternetsample.common.viewBinding
import com.canerture.connecttotheinternetsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}