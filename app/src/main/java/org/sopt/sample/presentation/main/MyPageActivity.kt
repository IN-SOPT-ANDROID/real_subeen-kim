package org.sopt.sample.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.sample.databinding.ActivityMyPageBinding

class MyPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}