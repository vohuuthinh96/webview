package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        WebView webView = findViewById(R.id.web);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setAllowContentAccess(true);


        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient(){

        });

        String elementName = "logo-wrap";
        webView.evaluateJavascript("document.getElementsByClassName(\"logo-wrap\")[0];\n" +
                "elem.style.pointerEvents = \"none\"", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String s) {
                Toast.makeText(MainActivity2.this, s, Toast.LENGTH_SHORT).show();
            }
        });

        webView.loadUrl("https://haivl.com.vn/");
    }
}