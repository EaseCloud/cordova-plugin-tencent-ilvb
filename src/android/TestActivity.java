package cn.easecloud.cordova.tencent;

import android.app.Activity;
import android.content.Intent;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

//import org.apache.http.util.EncodingUtils;

import static android.webkit.WebSettings.LOAD_NO_CACHE;

public class TestActivity extends Activity {

    private int _R(String defType, String name) {
        return getApplication().getResources().getIdentifier(
                name, defType, getApplication().getPackageName());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(_R("layout", "layout_test"));

        Intent intent = getIntent();
//        initView();

    }

//    private void initView() {
//
//        iv  = (ImageView) findViewById(R.id.td);
//        iv.setOnClickListener(this);
//
//        pb = (ProgressBar) findViewById(R.id.cmb_pb);
//
//        webView = (WebView) findViewById(R.id.yyy);
//        WebSettings webSettings = webView.getSettings();
//
//        //设置WebView属性，能够执行Javascript脚本
//        webSettings.setJavaScriptEnabled(true);
//        webSettings.setCacheMode(webSettings.LOAD_NO_CACHE);
//        webSettings.setSaveFormData(false);
//        //设置支持缩放
//        webSettings.setSupportZoom(false);
//
//
//        webView.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                Intent i;
//
//                CMBKeyboardFunc kbFunc = new CMBKeyboardFunc(TffCMBActivity.this);
//                if(kbFunc.HandleUrlCall(view, url) == false)
//                {
//                    if(url.contains("back.toursforfun.com")){
//                        i = new Intent();
//                        setResult(1,i);
//                        finish();
//                        return false;
//                    }else {
//                        return super.shouldOverrideUrlLoading(view, url);
//                    }
//                }else {
//                    return true;
//                }
//            }
//
//            @Override
//            public void onPageStarted(WebView view, String url, Bitmap bitmap) {
//            }
//
//            public void onPageFinished(WebView view, String url) {
//                filterUrl = url;
//            }
//
//        });
//
//
//        webView.setWebChromeClient(new WebChromeClient() {
//            @Override
//            public void onProgressChanged(WebView view, int newProgress) {
//                if (newProgress == 100) {
//                    pb.setVisibility(View.GONE);
//                } else {
//                    if (View.GONE == pb.getVisibility()) {
//                        pb.setVisibility(View.VISIBLE);
//                    }
//                    pb.setProgress(newProgress);
//                }
//                super.onProgressChanged(view, newProgress);
//            }
//
//        });
//
//    }
//
//    @SuppressWarnings("deprecation")
//    private void postUrl() {
//        try {
//
//            CookieSyncManager.createInstance(TffCMBActivity.this.getApplicationContext());
//            CookieManager.getInstance().removeAllCookie();
//            CookieSyncManager.getInstance().sync();
//        } catch (Exception e) {
//
//        }
//
//        String a = "jsonRequestData=" + jsonRequestData;
//        webView.postUrl(url, EncodingUtils.getBytes(a,"base64"));
//
//
//    }
//
//    @Override
//    public void onClick(View v) {
//        Intent i;
//        switch (v.getId()) {
//            case R.id.td:
//                if(filterUrl.contains("MB_EUserP_PayOK")){
//                    i = new Intent();
//                    setResult(1,i);
//                    finish();
//                }else{
//                    finish();
//                }
//                break;
//        }
//    }
}
