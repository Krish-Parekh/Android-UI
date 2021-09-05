package com.example.uipractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TableLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.uipractice.adapter.ViewPageAdapter
import com.example.uipractice.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val tabLayout = binding.tabLayout
        val viewPager2 = binding.viewPager2
        val adapter = ViewPageAdapter(supportFragmentManager, lifecycle)
        viewPager2.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "First"
                }
                1 -> {
                    tab.text = "Second"
                }
                2 -> {
                    tab.text = "Third"
                }
            }
        }.attach()
    }
}