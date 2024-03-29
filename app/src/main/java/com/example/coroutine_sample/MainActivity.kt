package com.example.coroutine_sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.coroutine_sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(binding.container.id, ListFragment.newInstance())
            .commit()
    }
}
