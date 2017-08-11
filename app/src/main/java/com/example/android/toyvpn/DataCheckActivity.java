package com.example.android.toyvpn;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.android.toyvpn.R;

/**
 * Created by 상헌 on 2016-05-29.
 */
public class DataCheckActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datacheck);

        WebView webView=(WebView)findViewById(R.id.webView);
        webView.loadUrl("http://104.155.192.218/ui/");
    }
}
