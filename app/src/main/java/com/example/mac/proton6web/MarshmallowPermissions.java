package com.example.mac.proton6web;

import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

/**
 * Created by mac on 9/27/17.
 */

public class MarshmallowPermissions {
    public static final int BOOT_COMPLETE_REQUEST_CODE = 1;
    public static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    Activity activity;

    public MarshmallowPermissions(Activity activity) {
        this.activity = activity;
    }

    public boolean checkBootComplete() {
        if (ContextCompat.checkSelfPermission(this.activity, "android.permission.RECEIVE_BOOT_COMPLETED") == 0) {
            return true;
        }
        return false;
    }

    public boolean checkFileRW() {
        if (ContextCompat.checkSelfPermission(this.activity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return true;
        }
        return false;
    }

    public void requestBootComplete() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this.activity, "android.permission.RECEIVE_BOOT_COMPLETED")) {
            Toast.makeText(this.activity, "No BootComplete Request", 1).show();
            return;
        }
        ActivityCompat.requestPermissions(this.activity, new String[]{"android.permission.RECEIVE_BOOT_COMPLETED"}, 1);
    }

    public void requestFileRW() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this.activity, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            Toast.makeText(this.activity, "Need File Permission ", 1).show();
            return;
        }
        ActivityCompat.requestPermissions(this.activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
    }

    private boolean checkPermission() {
        if (ContextCompat.checkSelfPermission(this.activity, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            return true;
        }
        return false;
    }

    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this.activity, "android.permission.READ_EXTERNAL_STORAGE")) {
            Toast.makeText(this.activity, "Write External Storage permission allows us to access images. Please allow this permission in App Settings.", 1).show();
            return;
        }
        ActivityCompat.requestPermissions(this.activity, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1);
    }

    public void CheckOrRequestPermissions() {
        if (!checkBootComplete()) {
            requestBootComplete();
        }
        if (!checkPermission()) {
            requestFileRW();
        }
        if (!checkFileRW()) {
            requestPermission();
        }
    }
}
