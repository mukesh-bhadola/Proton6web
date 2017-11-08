package com.example.mac.proton6web;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import android.support.annotation.IdRes;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class SetupAppdata extends Activity implements OnClickListener {
    String MY_PREFS_SETTING = "lxc_APP_CONFIG";
    private int PICK_IMAGE_REQUEST = 1;
    RadioButton a_gallery;
    RadioButton a_url;
    String app_m10_type = "none";
    String app_m10_url = "none";
    String app_m1_type = "none";
    String app_m1_url = "none";
    String app_m2_type = "none";
    String app_m2_url = "none";
    String app_m3_type = "none";
    String app_m3_url = "none";
    String app_m4_type = "none";
    String app_m4_url = "none";
    String app_m5_type = "none";
    String app_m5_url = "none";
    String app_m6_type = "none";
    String app_m6_url = "none";
    String app_m7_type = "none";
    String app_m7_url = "none";
    String app_m8_type = "none";
    String app_m8_url = "none";
    String app_m9_type = "none";
    String app_m9_url = "none";
    Uri appm10_url;
    Uri appm1_url;
    Uri appm2_url;
    Uri appm3_url;
    Uri appm4_url;
    Uri appm5_url;
    Uri appm6_url;
    Uri appm7_url;
    Uri appm8_url;
    Uri appm9_url;
    String c_url = null;
    String current_url = "current_url";
    String custom_delay = "delay_interval";
    RadioGroup default_load;
    Button del_media_1;
    Button del_media_10;
    Button del_media_2;
    Button del_media_3;
    Button del_media_4;
    Button del_media_5;
    Button del_media_6;
    Button del_media_7;
    Button del_media_8;
    Button del_media_9;
    EditText delay_count;
    EditText edit_url;
    private Boolean exit = Boolean.valueOf(false);
    Uri imgUri = Uri.parse("android.resource://my.package.name/2130837812");
    String last_url = "last_url";
    LinearLayout linearLayout1;
    LinearLayout linearLayout110;
    LinearLayout linearLayout2;
    LinearLayout linearLayout3;
    LinearLayout linearLayout4;
    LinearLayout linearLayout5;
    LinearLayout linearLayout6;
    LinearLayout linearLayout7;
    LinearLayout linearLayout8;
    LinearLayout linearLayout9;
    Button madd1;
    Button madd10;
    Button madd2;
    Button madd3;
    Button madd4;
    Button madd5;
    Button madd6;
    Button madd7;
    Button madd8;
    Button madd9;
    MarshmallowPermissions marshmallowPermissions;
    ImageView media1;
    ImageView media10;
    ImageView media2;
    ImageView media3;
    ImageView media4;
    ImageView media5;
    ImageView media6;
    ImageView media7;
    ImageView media8;
    ImageView media9;
    String p_url = null;
    TextView show_current_url;
    Button update_delay;
    Button update_edit_url;

    class C02621 implements OnCheckedChangeListener {
        C02621() {
        }

        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            Editor editor_load = SetupAppdata.this.getSharedPreferences(SetupAppdata.this.MY_PREFS_SETTING, 0).edit();
            if (checkedId == R.id.appby_url) {
                editor_load.putBoolean("load_from_url", true);
                editor_load.putBoolean("load_from_gallery", false);
                editor_load.commit();
                Toast.makeText(SetupAppdata.this.getApplicationContext(), "url selected", Toast.LENGTH_LONG).show();
            }
            if (checkedId == R.id.appby_gallery) {
                editor_load.putBoolean("load_from_url", false);
                editor_load.putBoolean("load_from_gallery", true);
                editor_load.commit();
                Toast.makeText(SetupAppdata.this.getApplicationContext(), "gallery selected", Toast.LENGTH_LONG).show();
            }
        }
    }

    class C02632 implements Runnable {
        C02632() {
        }

        public void run() {
            SetupAppdata.this.exit = Boolean.valueOf(false);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_appdata);
        this.marshmallowPermissions = new MarshmallowPermissions(this);
        this.marshmallowPermissions.CheckOrRequestPermissions();
        SharedPreferences prefs = getSharedPreferences(this.MY_PREFS_SETTING, 0);
        String c_url = prefs.getString(this.current_url, null);
        String p_url = prefs.getString(this.last_url, null);
        Boolean load_from_url = Boolean.valueOf(prefs.getBoolean("load_from_url", false));
        Boolean load_from_gallery = Boolean.valueOf(prefs.getBoolean("load_from_gallery", false));
        this.app_m1_url = prefs.getString("m1_url", null);
        this.app_m1_type = prefs.getString("m1_type", null);
        this.app_m2_url = prefs.getString("m2_url", null);
        this.app_m2_type = prefs.getString("m2_type", null);
        this.app_m3_url = prefs.getString("m3_url", null);
        this.app_m3_type = prefs.getString("m3_type", null);
        this.app_m4_url = prefs.getString("m4_url", null);
        this.app_m4_type = prefs.getString("m4_type", null);
        this.app_m5_url = prefs.getString("m5_url", null);
        this.app_m5_type = prefs.getString("m5_type", null);
        this.app_m6_url = prefs.getString("m6_url", null);
        this.app_m6_type = prefs.getString("m6_type", null);
        this.app_m7_url = prefs.getString("m7_url", null);
        this.app_m7_type = prefs.getString("m7_type", null);
        this.app_m8_url = prefs.getString("m8_url", null);
        this.app_m8_type = prefs.getString("m8_type", null);
        this.app_m9_url = prefs.getString("m9_url", null);
        this.app_m9_type = prefs.getString("m9_type", null);
        this.app_m10_url = prefs.getString("m10_url", null);
        this.app_m10_type = prefs.getString("m10_type", null);
        this.delay_count = (EditText) findViewById(R.id.image_delay);
        this.update_delay = (Button) findViewById(R.id.delay_update);
        this.edit_url = (EditText) findViewById(R.id.app_url);
        this.show_current_url = (TextView) findViewById(R.id.show_current_url);
        this.update_edit_url = (Button) findViewById(R.id.app_url_update);
        this.default_load = (RadioGroup) findViewById(R.id.app_load_by);
        this.a_url = (RadioButton) findViewById(R.id.appby_url);
        this.a_gallery = (RadioButton) findViewById(R.id.appby_gallery);
        this.media1 = (ImageView) findViewById(R.id.img_1);
        this.media2 = (ImageView) findViewById(R.id.img_2);
        this.media3 = (ImageView) findViewById(R.id.img_3);
        this.media4 = (ImageView) findViewById(R.id.img_4);
        this.media5 = (ImageView) findViewById(R.id.img_5);
        this.media6 = (ImageView) findViewById(R.id.img_6);
        this.media7 = (ImageView) findViewById(R.id.img_7);
        this.media8 = (ImageView) findViewById(R.id.img_8);
        this.media9 = (ImageView) findViewById(R.id.img_9);
        this.media10 = (ImageView) findViewById(R.id.img_10);
        this.del_media_1 = (Button) findViewById(R.id.del_1);
        this.del_media_2 = (Button) findViewById(R.id.del_2);
        this.del_media_3 = (Button) findViewById(R.id.del_3);
        this.del_media_4 = (Button) findViewById(R.id.del_4);
        this.del_media_5 = (Button) findViewById(R.id.del_5);
        this.del_media_6 = (Button) findViewById(R.id.del_6);
        this.del_media_7 = (Button) findViewById(R.id.del_7);
        this.del_media_8 = (Button) findViewById(R.id.del_8);
        this.del_media_9 = (Button) findViewById(R.id.del_9);
        this.del_media_10 = (Button) findViewById(R.id.del_10);
        this.madd1 = (Button) findViewById(R.id.addm_1);
        this.madd2 = (Button) findViewById(R.id.addm_2);
        this.madd3 = (Button) findViewById(R.id.addm_3);
        this.madd4 = (Button) findViewById(R.id.addm_4);
        this.madd5 = (Button) findViewById(R.id.addm_5);
        this.madd6 = (Button) findViewById(R.id.addm_6);
        this.madd7 = (Button) findViewById(R.id.addm_7);
        this.madd8 = (Button) findViewById(R.id.addm_8);
        this.madd9 = (Button) findViewById(R.id.addm_9);
        this.madd10 = (Button) findViewById(R.id.del_10);
        if (c_url != null) {
            this.edit_url.setText(c_url);
            this.show_current_url.setText(c_url);
        }
        if (load_from_gallery.booleanValue()) {
            this.a_gallery.setChecked(true);
        }
        if (load_from_url.booleanValue()) {
            this.a_url.setChecked(true);
        }
        if (this.app_m1_url != null && this.app_m1_type.equals("video")) {
            this.media1.setImageResource(R.drawable.video);
        }
        if (this.app_m1_url != null && this.app_m1_type.equals("image")) {
            this.appm1_url = Uri.parse(this.app_m1_url);
            this.media1.setImageURI(this.appm1_url);
        }
        if (this.app_m2_url != null && this.app_m2_type.equals("video")) {
            this.media2.setImageResource(R.drawable.video);
        }
        if (this.app_m2_url != null && this.app_m2_type.equals("image")) {
            this.appm2_url = Uri.parse(this.app_m2_url);
            this.media2.setImageURI(this.appm2_url);
        }
        if (this.app_m3_url != null && this.app_m3_type.equals("video")) {
            this.media3.setImageResource(R.drawable.video);
        }
        if (this.app_m3_url != null && this.app_m3_type.equals("image")) {
            this.appm3_url = Uri.parse(this.app_m3_url);
            this.media3.setImageURI(this.appm3_url);
        }
        if (this.app_m4_url != null && this.app_m4_type.equals("video")) {
            this.media4.setImageResource(R.drawable.video);
        }
        if (this.app_m4_url != null && this.app_m4_type.equals("image")) {
            this.appm4_url = Uri.parse(this.app_m4_url);
            this.media4.setImageURI(this.appm4_url);
        }
        if (this.app_m5_url != null && this.app_m5_type.equals("video")) {
            this.media5.setImageResource(R.drawable.video);
        }
        if (this.app_m5_url != null && this.app_m5_type.equals("image")) {
            this.appm5_url = Uri.parse(this.app_m5_url);
            this.media5.setImageURI(this.appm5_url);
        }
        if (this.app_m6_url != null && this.app_m6_type.equals("video")) {
            this.media6.setImageResource(R.drawable.video);
        }
        if (this.app_m6_url != null && this.app_m6_type.equals("image")) {
            this.appm6_url = Uri.parse(this.app_m6_url);
            this.media6.setImageURI(this.appm6_url);
        }
        if (this.app_m7_url != null && this.app_m7_type.equals("video")) {
            this.media7.setImageResource(R.drawable.video);
        }
        if (this.app_m7_url != null && this.app_m7_type.equals("image")) {
            this.appm7_url = Uri.parse(this.app_m7_url);
            this.media7.setImageURI(this.appm7_url);
        }
        if (this.app_m8_url != null && this.app_m8_type.equals("video")) {
            this.media8.setImageResource(R.drawable.video);
        }
        if (this.app_m8_url != null && this.app_m8_type.equals("image")) {
            this.appm8_url = Uri.parse(this.app_m8_url);
            this.media8.setImageURI(this.appm8_url);
        }
        if (this.app_m9_url != null && this.app_m9_type.equals("video")) {
            this.media9.setImageResource(R.drawable.video);
        }
        if (this.app_m9_url != null && this.app_m9_type.equals("image")) {
            this.appm9_url = Uri.parse(this.app_m9_url);
            this.media9.setImageURI(this.appm9_url);
        }
        if (this.app_m10_url != null && this.app_m10_type.equals("video")) {
            this.media10.setImageResource(R.drawable.video);
        }
        if (this.app_m10_url != null && this.app_m10_type.equals("image")) {
            this.appm10_url = Uri.parse(this.app_m10_url);
            this.media10.setImageURI(this.appm10_url);
        }
        this.update_edit_url.setOnClickListener(this);
        this.madd1.setOnClickListener(this);
        this.madd2.setOnClickListener(this);
        this.madd3.setOnClickListener(this);
        this.madd4.setOnClickListener(this);
        this.madd5.setOnClickListener(this);
        this.madd6.setOnClickListener(this);
        this.madd7.setOnClickListener(this);
        this.madd8.setOnClickListener(this);
        this.madd9.setOnClickListener(this);
        this.madd10.setOnClickListener(this);
        this.media1.setOnClickListener(this);
        this.media2.setOnClickListener(this);
        this.media3.setOnClickListener(this);
        this.media4.setOnClickListener(this);
        this.media5.setOnClickListener(this);
        this.media6.setOnClickListener(this);
        this.media7.setOnClickListener(this);
        this.media8.setOnClickListener(this);
        this.media9.setOnClickListener(this);
        this.media10.setOnClickListener(this);
        this.del_media_1.setOnClickListener(this);
        this.del_media_2.setOnClickListener(this);
        this.del_media_3.setOnClickListener(this);
        this.del_media_4.setOnClickListener(this);
        this.del_media_5.setOnClickListener(this);
        this.del_media_6.setOnClickListener(this);
        this.del_media_7.setOnClickListener(this);
        this.del_media_8.setOnClickListener(this);
        this.del_media_9.setOnClickListener(this);
        this.del_media_10.setOnClickListener(this);
        this.update_delay.setOnClickListener(this);
        this.default_load.setOnCheckedChangeListener(new C02621());
    }

    @RequiresApi(api = 19)
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Uri selectedImageUri;
        String path;
        super.onActivityResult(requestCode, resultCode, data);
        Editor editor1 = getSharedPreferences(this.MY_PREFS_SETTING, 0).edit();
        if (requestCode == 1 && resultCode == -1) {
            selectedImageUri = data.getData();
            String path1 = getMimeType(getPath(this, selectedImageUri));
            editor1.putString("m1_url", getPath(this, selectedImageUri));
            Log.i("Image File Path", "" + selectedImageUri);
            String m1_type = "image";
            if (path1.contains("video/")) {
                m1_type = "video";
                this.media1.setImageResource(R.drawable.video);
            } else {
                this.media1.setImageURI(selectedImageUri);
            }
            editor1.putString("m1_type", m1_type);
        }
        if (requestCode == 2 && resultCode == -1) {
            selectedImageUri = data.getData();
            path = getMimeType(getPath(this, selectedImageUri));
            String m2_type = "image";
            editor1.putString("m2_url", getPath(this, selectedImageUri));
            if (path.contains("video/")) {
                m2_type = "video";
                this.media2.setImageResource(R.drawable.video);
            } else {
                this.media2.setImageURI(selectedImageUri);
            }
            editor1.putString("m2_type", m2_type);
        }
        if (requestCode == 3 && resultCode == -1) {
            selectedImageUri = data.getData();
            path = getMimeType(getPath(this, selectedImageUri));
            String m3_type = "image";
            editor1.putString("m3_url", getPath(this, selectedImageUri));
            if (path.contains("video/")) {
                m3_type = "video";
                this.media3.setImageResource(R.drawable.video);
            } else {
                this.media3.setImageURI(selectedImageUri);
            }
            editor1.putString("m3_type", m3_type);
        }
        if (requestCode == 4 && resultCode == -1) {
            selectedImageUri = data.getData();
            path = getMimeType(getPath(this, selectedImageUri));
            String m4_type = "image";
            editor1.putString("m4_url", getPath(this, selectedImageUri));
            if (path.contains("video/")) {
                m4_type = "video";
                this.media4.setImageResource(R.drawable.video);
            } else {
                this.media4.setImageURI(selectedImageUri);
            }
            editor1.putString("m4_type", m4_type);
        }
        if (requestCode == 5 && resultCode == -1) {
            selectedImageUri = data.getData();
            path = getMimeType(getPath(this, selectedImageUri));
            String m5_type = "image";
            editor1.putString("m5_url", getPath(this, selectedImageUri));
            if (path.contains("video/")) {
                m5_type = "video";
                this.media5.setImageResource(R.drawable.video);
            } else {
                this.media5.setImageURI(selectedImageUri);
            }
            editor1.putString("m5_type", m5_type);
        }
        if (requestCode == 6 && resultCode == -1) {
            selectedImageUri = data.getData();
            path = getMimeType(getPath(this, selectedImageUri));
            String m6_type = "image";
            editor1.putString("m6_url", getPath(this, selectedImageUri));
            if (path.contains("video/")) {
                m6_type = "video";
                this.media6.setImageResource(R.drawable.video);
            } else {
                this.media6.setImageURI(selectedImageUri);
            }
            editor1.putString("m6_type", m6_type);
        }
        if (requestCode == 7 && resultCode == -1) {
            selectedImageUri = data.getData();
            path = getMimeType(getPath(this, selectedImageUri));
            String m7_type = "image";
            editor1.putString("m7_url", getPath(this, selectedImageUri));
            if (path.contains("video/")) {
                m7_type = "video";
                this.media7.setImageResource(R.drawable.video);
            } else {
                this.media7.setImageURI(selectedImageUri);
            }
            editor1.putString("m7_type", m7_type);
        }
        if (requestCode == 8 && resultCode == -1) {
            selectedImageUri = data.getData();
            path = getMimeType(getPath(this, selectedImageUri));
            String m8_type = "image";
            editor1.putString("m8_url", getPath(this, selectedImageUri));
            if (path.contains("video/")) {
                m8_type = "video";
                this.media8.setImageResource(R.drawable.video);
            } else {
                this.media8.setImageURI(selectedImageUri);
            }
            editor1.putString("m8_type", m8_type);
        }
        if (requestCode == 9 && resultCode == -1) {
            selectedImageUri = data.getData();
            path = getMimeType(getPath(this, selectedImageUri));
            String m9_type = "image";
            editor1.putString("m9_url", getPath(this, selectedImageUri));
            if (path.contains("video/")) {
                m9_type = "video";
                this.media9.setImageResource(R.drawable.video);
            } else {
                this.media9.setImageURI(selectedImageUri);
            }
            editor1.putString("m9_type", m9_type);
        }
        if (requestCode == 10 && resultCode == -1) {
            selectedImageUri = data.getData();
            path = getMimeType(getPath(this, selectedImageUri));
            String m10_type = "image";
            editor1.putString("m10_url", getPath(this, selectedImageUri));
            if (path.contains("video/")) {
                m10_type = "video";
                this.media10.setImageResource(R.drawable.video);
            } else {
                this.media10.setImageURI(selectedImageUri);
            }
            editor1.putString("m10_type", m10_type);
        }
        editor1.commit();
    }

    public String getPath2(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
        if (cursor == null) {
            return null;
        }
        int column_index = cursor.getColumnIndexOrThrow("_data");
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    public String imgPath(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
        if (cursor == null) {
            return null;
        }
        int column_index = cursor.getColumnIndexOrThrow("_data");
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    public void onBackPressed() {
        if (this.exit.booleanValue()) {
            finish();
            return;
        }
        Toast.makeText(this, "Press Back again to Exit.", Toast.LENGTH_LONG).show();
        this.exit = Boolean.valueOf(true);
        new Handler().postDelayed(new C02632(), 3000);
    }

    public void onClick(View v) {
        Editor media_remove_1 = getSharedPreferences(this.MY_PREFS_SETTING, 0).edit();
        switch (v.getId()) {
            case R.id.app_url_update:
                save_url_path();
                break;
            case R.id.delay_update:
                update_image_delay();
                break;
            case R.id.img_1:
                call_media(1);
                break;
            case R.id.addm_1:
                call_media(1);
                break;
            case R.id.del_1:
                media_remove_1.putString("m1_url", null);
                media_remove_1.putString("m1_type", null);
                Toast.makeText(this, "Media 1 Removed!", Toast.LENGTH_LONG).show();
                this.media1.setImageResource(R.drawable.plus_media);
                break;
            case R.id.img_2:
                call_media(2);
                break;
            case R.id.addm_2:
                call_media(2);
                break;
            case R.id.del_2:
                Editor media_remove_2 = getSharedPreferences(this.MY_PREFS_SETTING, 0).edit();
                media_remove_2.putString("m2_url", null);
                media_remove_2.putString("m2_type", null);
                media_remove_2.commit();
                Toast.makeText(this, "Media 2 Removed!", Toast.LENGTH_LONG).show();
                this.media2.setImageResource(R.drawable.plus_media);
                break;
            case R.id.img_3:
                call_media(3);
                break;
            case R.id.addm_3:
                call_media(3);
                break;
            case R.id.del_3:
                media_remove_1.putString("m3_url", null);
                media_remove_1.putString("m3_type", null);
                Toast.makeText(this, "Media 3 Removed!", Toast.LENGTH_LONG).show();
                this.media3.setImageResource(R.drawable.plus_media);
                break;
            case R.id.img_4:
                call_media(4);
                break;
            case R.id.addm_4:
                call_media(4);
                break;
            case R.id.del_4:
                media_remove_1.putString("m4_url", null);
                media_remove_1.putString("m4_type", null);
                Toast.makeText(this, "Media 4 Removed!", Toast.LENGTH_LONG).show();
                this.media4.setImageResource(R.drawable.plus_media);
                break;
            case R.id.img_5:
                call_media(5);
                break;
            case R.id.addm_5:
                call_media(5);
                break;
            case R.id.del_5:
                media_remove_1.putString("m5_url", null);
                media_remove_1.putString("m5_type", null);
                Toast.makeText(this, "Media 5 Removed!", Toast.LENGTH_LONG).show();
                this.media5.setImageResource(R.drawable.plus_media);
                break;
            case R.id.img_6:
                call_media(6);
                break;
            case R.id.addm_6:
                call_media(6);
                break;
            case R.id.del_6:
                media_remove_1.putString("m6_url", null);
                media_remove_1.putString("m6_type", null);
                Toast.makeText(this, "Media 6 Removed!", Toast.LENGTH_LONG).show();
                this.media6.setImageResource(R.drawable.plus_media);
                break;
            case R.id.img_7:
                call_media(7);
                break;
            case R.id.addm_7:
                call_media(7);
                break;
            case R.id.del_7:
                media_remove_1.putString("m7_url", null);
                media_remove_1.putString("m7_type", null);
                Toast.makeText(this, "Media 7 Removed!", Toast.LENGTH_LONG).show();
                this.media7.setImageResource(R.drawable.plus_media);
                break;
            case R.id.img_8:
                call_media(8);
                break;
            case R.id.addm_8:
                call_media(8);
                break;
            case R.id.del_8:
                media_remove_1.putString("m8_url", null);
                media_remove_1.putString("m8_type", null);
                Toast.makeText(this, "Media 8 Removed!", Toast.LENGTH_LONG).show();
                this.media8.setImageResource(R.drawable.plus_media);
                break;
            case R.id.img_9:
                call_media(9);
                break;
            case R.id.addm_9:
                call_media(9);
                break;
            case R.id.del_9:
                media_remove_1.putString("m9_url", null);
                media_remove_1.putString("m9_type", null);
                Toast.makeText(this, "Media 9 Removed!", Toast.LENGTH_LONG).show();
                this.media9.setImageResource(R.drawable.plus_media);
                break;
            case R.id.img_10:
                call_media(10);
                break;
            case R.id.addm_10:
                call_media(10);
                break;
            case R.id.del_10:
                media_remove_1.putString("m10_url", null);
                media_remove_1.putString("m10_type", null);
                Toast.makeText(this, "Media 10 Removed!", Toast.LENGTH_LONG).show();
                this.media10.setImageResource(R.drawable.plus_media);
                break;
        }
        media_remove_1.commit();
    }

    public void call_media(int media_id) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/* video/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), media_id);
    }

    public void save_url_path() {
        Editor editor_url = getSharedPreferences(this.MY_PREFS_SETTING, 0).edit();
        editor_url.putString(this.current_url, this.edit_url.getText().toString());
        editor_url.commit();
        Toast.makeText(this, "URL changed!", Toast.LENGTH_LONG).show();
    }

    public void update_image_delay() {
        int value = Integer.parseInt(this.delay_count.getText().toString());
        if (value > 3 || value > 30) {
            value *= 1000;
            Editor editor_delay = getSharedPreferences(this.MY_PREFS_SETTING, 0).edit();
            editor_delay.putString(this.custom_delay, String.valueOf(value));
            editor_delay.commit();
            Toast.makeText(this, "Delay Updated", Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(this, "Value must be greater then 3 or less then 30", Toast.LENGTH_LONG).show();
    }

    public static String getMimeType(String url) {
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(url.substring(url.lastIndexOf("."))));
    }


    /**
     * Get a file path from a Uri. This will get the the path for Storage Access
     * Framework Documents, as well as the _data field for the MediaStore and
     * other file-based ContentProviders.
     *
     * @param context The context.
     * @param uri The Uri to query.
     * @author paulburke
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static String getPath(final Context context, final Uri uri) {

        final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;

        // DocumentProvider
        if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
            // ExternalStorageProvider
            if (isExternalStorageDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                if ("primary".equalsIgnoreCase(type)) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }

                // TODO handle non-primary volumes
            }
            // DownloadsProvider
            else if (isDownloadsDocument(uri)) {

                final String id = DocumentsContract.getDocumentId(uri);
                final Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));

                return getDataColumn(context, contentUri, null, null);
            }
            // MediaProvider
            else if (isMediaDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }

                final String selection = "_id=?";
                final String[] selectionArgs = new String[] {
                        split[1]
                };

                return getDataColumn(context, contentUri, selection, selectionArgs);
            }
        }
        // MediaStore (and general)
        else if ("content".equalsIgnoreCase(uri.getScheme())) {
            return getDataColumn(context, uri, null, null);
        }
        // File
        else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }

        return null;
    }

    /**
     * Get the value of the data column for this Uri. This is useful for
     * MediaStore Uris, and other file-based ContentProviders.
     *
     * @param context The context.
     * @param uri The Uri to query.
     * @param selection (Optional) Filter used in the query.
     * @param selectionArgs (Optional) Selection arguments used in the query.
     * @return The value of the _data column, which is typically a file path.
     */
    public static String getDataColumn(Context context, Uri uri, String selection,
                                       String[] selectionArgs) {

        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {
                column
        };

        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs,
                    null);
            if (cursor != null && cursor.moveToFirst()) {
                final int column_index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(column_index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }


    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is ExternalStorageProvider.
     */
    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is DownloadsProvider.
     */
    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is MediaProvider.
     */
    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }



}
