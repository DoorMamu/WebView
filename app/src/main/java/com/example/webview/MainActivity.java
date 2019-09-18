package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button loadWeb,loadStaticWeb;
WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadWeb=findViewById(R.id.loadWebPage);
        loadStaticWeb=findViewById(R.id.loadFromStaticHtml);
        webView=findViewById(R.id.webView);
        loadWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.setWebViewClient(new MyWebViewClient());
                String url = "https://chandansatyendraprasad.wordpress.com/";
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl(url); // load a web page in a web view
            }
        });

        loadStaticWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //static web pages
                String custHtml="<html> <body><h1>Hello </h1> </body></html>";
                webView.loadData(custHtml,"text/html","UTF-8");
            }
        });


    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
