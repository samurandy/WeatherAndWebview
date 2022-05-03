package com.example.weatherwebview.ui.webview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.weatherwebview.R
import com.example.weatherwebview.data.network.model.RemoteResult
import com.example.weatherwebview.databinding.FragmentWebviewBinding
import com.example.weatherwebview.ui.toast
import com.example.weatherwebview.ui.weather.WeatherViewModel
import kotlinx.coroutines.launch

class WebViewFragment : Fragment() {

    private var _binding: FragmentWebviewBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWebviewBinding.inflate(layoutInflater)
        return binding.root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}