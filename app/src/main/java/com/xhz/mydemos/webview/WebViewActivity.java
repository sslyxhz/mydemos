package com.xhz.mydemos.webview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.xhz.mydemos.R;
import com.xhz.mydemos.nanohttpd.HelloServer;

import java.io.IOException;

import fi.iki.elonen.NanoHTTPD;

/**
 * Created by xh.zeng on 2017/6/2.
 */

public class WebViewActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        mWebView = (WebView) this.findViewById(R.id.fragment_webview_container);

        mWebView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });

        final String url = "http://localhost:8080/";
        HelloServer server;
        try {
            server = new HelloServer(8080);
            server.start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mWebView.loadUrl(url);
    }
}
