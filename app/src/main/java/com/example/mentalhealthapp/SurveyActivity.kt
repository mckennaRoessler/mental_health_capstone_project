package com.example.mentalhealthapp

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class SurveyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.survey_screen)

        val myWebView = findViewById<WebView>(R.id.webview)
        myWebView.webViewClient = WebViewClient()
        //enable javascript as required for Google forms
        myWebView.settings.javaScriptEnabled = true
        myWebView.loadUrl("https://forms.gle/WSAUABy8RQ6JwqHaA")
    }
}