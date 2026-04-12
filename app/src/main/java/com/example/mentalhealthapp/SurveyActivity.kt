package com.example.mentalhealthapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class SurveyActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled", "ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.survey_screen)

        val myWebView = findViewById<WebView>(R.id.webview)
        myWebView.webViewClient = WebViewClient()

        myWebView.isVerticalScrollBarEnabled = true
        myWebView.isHorizontalScrollBarEnabled = true

        myWebView.setOnTouchListener { v, event ->
            v.parent.requestDisallowInterceptTouchEvent(true)
            false
        }

        //enable javascript as required for Google forms
        val settings = myWebView.settings
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true

        settings.useWideViewPort = true
        settings.loadWithOverviewMode = true

        settings.layoutAlgorithm = android.webkit.WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING

        settings.builtInZoomControls = true
        settings.displayZoomControls = false

        myWebView.setInitialScale(1)

        myWebView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSexAm_bFycILZNOOr8kyCZy2gTHmSwKHEun0BeEvnh3eckJgw/viewform?embedded=true")

    }
}