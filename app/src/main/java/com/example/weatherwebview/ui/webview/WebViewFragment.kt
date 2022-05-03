package com.example.weatherwebview.ui.webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherwebview.R
import com.example.weatherwebview.databinding.FragmentWebviewBinding

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configAndRunWebview()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun configAndRunWebview(){
        binding.myWebView.webViewClient = MyWebViewClient(binding.progressBar, binding.imageView)
        binding.myWebView.settings.javaScriptEnabled = true
        binding.myWebView.loadUrl(getString(R.string.WebviewUrl))
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}