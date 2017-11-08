package com.example.mac.proton6web;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class sFlashScreen extends Activity {

    String MY_PREFS_SETTING = "lxc_APP_CONFIG";
    String current_url = "current_url";
    String last_url = "last_url";
    MarshmallowPermissions marshmallowPermissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_flash_screen);
        //marshallow permissions
        this.marshmallowPermissions = new MarshmallowPermissions(this);
        this.marshmallowPermissions.CheckOrRequestPermissions();

        ///shared prefrence
        SharedPreferences prefs = getSharedPreferences(this.MY_PREFS_SETTING, 0);
        Boolean load_from_url = Boolean.valueOf(prefs.getBoolean("load_from_url", false));
        Boolean load_from_gallery = Boolean.valueOf(prefs.getBoolean("load_from_gallery", false));
        String c_url = prefs.getString(this.current_url, null);
        if (load_from_url.booleanValue() && !c_url.equals(null)) {
            new Handler().postDelayed(new C02641(), (long) 3000);
            //new Handler().postDelayed(new );
        } else if (load_from_gallery.booleanValue()) {
            new Handler().postDelayed(new C02652(), (long) 3000);
        } else {
            Toast.makeText(getApplicationContext(), "Missing configuration! Please Contact To Service Provider", Toast.LENGTH_LONG).show();
        }
        NetworkInfo networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected()) {
            startActivity(new Intent(getApplicationContext(), GalleryViewMain.class));
            finish();
            return;
        }
        startActivity(new Intent(getApplicationContext(), WebViewMain.class));
        finish();
    }

    class C02641 implements Runnable {
        C02641() {
        }

        public void run() {
        }
    }

    class C02652 implements Runnable {
        C02652() {
        }

        public void run() {
        }
    }
}
