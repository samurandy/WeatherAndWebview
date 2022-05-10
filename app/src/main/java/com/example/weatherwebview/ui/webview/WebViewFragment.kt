package com.example.weatherwebview.ui.webview

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.weatherwebview.R
import com.example.weatherwebview.databinding.FragmentWebviewBinding


class WebViewFragment : Fragment() {

    private lateinit var binding: FragmentWebviewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWebviewBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            configAndRunWebview()
            }

    @SuppressLint("SetJavaScriptEnabled")
    private fun configAndRunWebview() {
        val webViewClient = object : WebViewClient(){
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                binding.progressBar.visibility = View.VISIBLE
                binding.blockingScreen.visibility = View.VISIBLE            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.blockingScreen.visibility = View.GONE
                binding.progressBar.visibility = View.GONE
            }
        }
        with(binding.webView){
            this.webViewClient = webViewClient
            this.settings.javaScriptEnabled = true
            this.loadUrl(getString(R.string.WebviewUrl))
            this.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK

        }
    }
}
