package com.xhz.mydemos.webview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.xhz.mydemos.R;

/**
 * Created by xh.zeng on 2017/6/2.
 */

public class WebViewFragment extends Fragment {

    private WebView mWebView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_webview, container, false);
        mWebView = (WebView) v.findViewById(R.id.fragment_webview_container);
        mWebView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });
        mWebView.loadUrl("http://www.baidu.com/");
        return v;
    }
}
