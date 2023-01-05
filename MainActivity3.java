package com.example.rokdobravecbled;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity3 extends AppCompatActivity {

    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        web = findViewById(R.id.idWebview);

        WebSettings webSettings=web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        web.loadUrl("https://sl.wikipedia.org/wiki/Bled");
    }
}