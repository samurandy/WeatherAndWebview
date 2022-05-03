package com.example.weatherwebview.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View =
    LayoutInflater.from(context).inflate(layoutRes, this, false)

fun Int.getDayOfWeek(): String {
    return SimpleDateFormat("EEEE", Locale.ENGLISH).format(this * 1000)
}

fun ImageView.loadUrl(url: String) {
    Glide.with(context).load(url).into(this)
}

fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}
