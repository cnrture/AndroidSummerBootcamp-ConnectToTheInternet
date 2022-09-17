package com.canerture.connecttotheinternetsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.canerture.connecttotheinternetsample.common.viewBinding
import com.canerture.connecttotheinternetsample.databinding.ActivityMainBinding
import com.canerture.connecttotheinternetsample.databinding.FragmentHomeBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}