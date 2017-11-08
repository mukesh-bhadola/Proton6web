package com.example.mac.proton6web;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.jsoup.Jsoup;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class WebViewMain extends Activity {
    public static boolean activityVisible;
    String MY_PREFS_SETTING = "lxc_APP_CONFIG";
    String app_url = "";//"http://www.proton6.tech/digital-signage/?device=37";
    //String app_url = "http://youtube.com";
    String current_url = "current_url";
    String last_url = "last_url";
    MarshmallowPermissions marshmallowPermissions;
    ProgressBar progressBar;
    private WebView webView;

    public class myWebClient extends WebViewClient {
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            WebViewMain.this.progressBar.setVisibility(View.GONE);
            view.loadUrl(url);
            return true;
        }

        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            WebViewMain.this.progressBar.setVisibility(View.VISIBLE);
        }
    }

    public static boolean isActivityVisible() {
        return activityVisible;
    }

    public static void activityResumed() {
        activityVisible = true;
    }

    public static void activityPaused() {
        activityVisible = false;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(128);
        setContentView(R.layout.activity_web_view_main);
        this.marshmallowPermissions = new MarshmallowPermissions(this);
        this.marshmallowPermissions.CheckOrRequestPermissions();
        SharedPreferences prefs = getSharedPreferences(this.MY_PREFS_SETTING, 0);
        String c_url = prefs.getString(this.current_url, null);
        String p_url = prefs.getString(this.last_url, null);
        this.webView = (WebView) findViewById(R.id.MyLocalView);
        this.progressBar = (ProgressBar) findViewById(R.id.LoadingWeb);
        if (c_url != null) {
            this.app_url = c_url;
        }
        if (!URLUtil.isValidUrl(this.app_url)) {
            Toast.makeText(this, "Please Contact to content provider for configuration Settings! ", Toast.LENGTH_LONG).show();
        } else if (CheckNetwork.isInternetAvailable(this)) {
            CookieManager.getInstance().setAcceptCookie(true);
            this.webView.setWebViewClient(new myWebClient());
            if (Build.VERSION.SDK_INT >= 17) {
                this.webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
            }
            this.webView.getSettings().setJavaScriptEnabled(true);
            this.webView.getSettings().setJavaScriptEnabled(true);
            this.webView.getSettings().setDomStorageEnabled(true);
            this.webView.getSettings().setLoadWithOverviewMode(true);
            this.webView.getSettings().setUseWideViewPort(true);
            this.webView.getSettings().setBuiltInZoomControls(true);
            this.webView.getSettings().setDisplayZoomControls(false);
            this.webView.getSettings().setSupportZoom(true);
            this.webView.getSettings().setDefaultTextEncodingName("utf-8");
            //this.webView.getSettings().setCacheMode(-1);
            this.webView.loadUrl(this.app_url);
        } else {
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_LONG).show();
        }
    }

    public void changeTextStatus(boolean isConnected) {
        if (!isConnected) {
        }
    }

    public void onPause() {
        super.onPause();
        this.webView.onPause();
        activityPaused();

    }

    public void onResume() {
        super.onResume();
        this.webView.onResume();
        activityResumed();

    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == 0) {
            switch (keyCode) {
                case 4:
                    if (this.webView.canGoBack()) {
                        this.webView.goBack();
                        return true;
                    }
                    finish();
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
