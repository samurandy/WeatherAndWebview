package com.example.weatherwebview.ui.webview

import android.graphics.Bitmap
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.ProgressBar

class MyWebViewClient(progressBar: ProgressBar, imageView: ImageView) : WebViewClient() {
    private var progress: ProgressBar = progressBar
    private var image: ImageView = imageView

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        image.visibility = View.VISIBLE
        progress.visibility = View.VISIBLE
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        image.visibility = View.GONE
        progress.visibility = View.GONE
    }
}
