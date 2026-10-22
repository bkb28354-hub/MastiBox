package com.mastibox;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
 ws.setUserAgentString("Mozilla/5.0 (Linux; Android 10) Chrome/120.0.0.0 Mobile Safari/537.36");
 webView.setWebViewClient(new WebViewClient(){
 @Override
 public boolean shouldOverrideUrlLoading(WebView view, String url){
 if(url.startsWith("intent://") || url.contains("snssdk1233") || url.contains("tiktok://") || url.contains("play.google.com")) return true;
 return false;
 }
 });
 webView.loadUrl("https://www.tiktok.com");
 }
 @Override
 public void onBackPressed(){
 if(webView.canGoBack()) webView.goBack();
 else super.onBackPressed();
 }
}
