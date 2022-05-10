package com.example.weatherwebview.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.weatherwebview.R
import com.example.weatherwebview.databinding.ActivityMainBinding
import com.example.weatherwebview.ui.weather.WeatherFragment
import com.example.weatherwebview.ui.webview.WebViewFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.viewPager.adapter = FragmentAdapter(this)

        with(binding){
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.icon = ContextCompat.getDrawable(this@MainActivity, chooseIcon(position))
            }.attach()
        }
    }

    private fun chooseIcon(position: Int): Int {
        return when (position) {
            0 -> R.drawable.ic_baseline_wb_sunny_24
            1 -> R.drawable.ic_baseline_web_24
            else -> R.drawable.ic_baseline_wb_sunny_24
        }
    }

    class FragmentAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> WeatherFragment()
                1 -> WebViewFragment()
                else -> WeatherFragment()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}