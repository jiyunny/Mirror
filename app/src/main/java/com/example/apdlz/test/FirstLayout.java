package com.example.apdlz.test;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by apdlz on 2018-04-05.
 */

public class FirstLayout extends Fragment {


    private WebView mWebView;
    private WebSettings mWebSettings;// 웹뷰세팅
    View v;
    String ipadress="0";
    Bundle bd;
    @Nullable



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       v =inflater.inflate (R.layout.first_layout, container, false);

        // ip주소
        //223.194.128.61

        mWebView=(WebView)v.findViewById(R.id.webview);// 레이어와연결
        mWebView.setWebViewClient(new WebViewClient());// 클릭시 새창 안뜨게
        mWebSettings = mWebView.getSettings();// 세부 세팅등록

        mWebSettings.setJavaScriptEnabled(true);// 자바스크립트 사용 허용
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String uri) {
                view.loadUrl(uri);
                return true;
            }
        });
        bd =getArguments();
        if(bd.getString("ip")!=null)
        ipadress = bd.getString("ip");


        mWebView.loadUrl("http://"+ipadress+":8080/remote.html");
        //https://www.naver.com/
        //"http://"+ipadress+":8080/remote.html"
       return v;
       
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //String ipadress = "223.194.128.61";// ip주소

    }
}
