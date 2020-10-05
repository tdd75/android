package com.tdd.duytran.readrss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class NewsActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        webView = (WebView) findViewById(R.id.webViewNews);

        Intent intent = getIntent();

        String link = intent.getStringExtra("link");
        webView.loadUrl(link);

        webView.setWebViewClient(new WebViewClient());  // not use browser
    }

}