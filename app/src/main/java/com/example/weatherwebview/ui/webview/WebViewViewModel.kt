package com.example.weatherwebview.ui.webview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WebViewViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is WebView Fragment"
    }
    val text: LiveData<String> = _text
}