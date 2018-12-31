package com.example.karim.webviewtutorial;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private WebView myWebView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        myWebView = findViewById(R.id.webView);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        myWebView.addJavascriptInterface(new WebViewInterface(context), "Android");

        Button button = findViewById(R.id.showToast);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                loadStaticHtml();
            }
        });
    }

    private void loadStaticHtml() {
        myWebView.loadUrl("file:///android_asset/myHTML.html");
    }
}
