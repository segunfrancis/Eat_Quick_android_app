package com.example.tc1.eatquick;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by TC1 on 17/03/2018.
 */
public class WebViewFragment extends Fragment {

    public WebView wv;
//    public WebViewClient myWebViewClient;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_webview, container, false);
        wv = (WebView)v.findViewById(R.id.webpage);
        Bundle b = getArguments();
        String bnd = b.getString("url");
        wv.loadUrl(bnd);
        WebSettings settings = wv.getSettings();
        wv.getSettings().setLoadsImagesAutomatically(true);
        settings.setJavaScriptEnabled(true);
        wv.setWebViewClient(new MyWebViewClient());
        wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        return v;
    }

    private class MyWebViewClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        callWebClient(bnd);
    }

//    private void callWebClient(String url) {
//        wv.setWebViewClient(myWebViewClient);
//        wv.getSettings().setLoadsImagesAutomatically(true);
//        //wv.getSettings().setJavaScriptEnabled(true);
//        wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
//    }
}