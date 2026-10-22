package com.mastibox;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this);
        setContentView(webView);

        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setDomStorageEnabled(true);
        ws.setUserAgentString("Mozilla/5.0 (Linux; Android 13; SM-S918B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Mobile Safari/537.36 TikTok 33.3.4");

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.contains("snssdk1233") || url.contains("Access Denied") || url.contains("tiktok.com/api")) {
                    view.loadUrl("https://www.tikwm.com/");
                    return true;
                }
                return false;
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                view.evaluateJavascript("javascript:(function(){ localStorage.clear(); document.cookie=''; })()", null);
            }
        });

        webView.loadUrl("https://www.tikwm.com/");
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) webView.goBack();
        else super.onBackPressed();
    }
}
