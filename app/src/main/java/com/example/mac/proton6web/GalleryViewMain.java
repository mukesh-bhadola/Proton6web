package com.example.mac.proton6web;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import android.os.Handler;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;


public class GalleryViewMain extends Activity {
    public static boolean activityVisible;
    String MY_PREFS_SETTING = "lxc_APP_CONFIG";
    ArrayList<Long> hold = new ArrayList();
    ArrayList<String> imagesFormType = new ArrayList();
    ArrayList<Uri> imagesFromURL = new ArrayList();
    MarshmallowPermissions marshmallowPermissions;
    ImageView playing_i_1;
    ImageView playing_i_10;
    ImageView playing_i_2;
    ImageView playing_i_3;
    ImageView playing_i_4;
    ImageView playing_i_5;
    ImageView playing_i_6;
    ImageView playing_i_7;
    ImageView playing_i_8;
    ImageView playing_i_9;
    VideoView playing_v_1;
    VideoView playing_v_10;
    VideoView playing_v_2;
    VideoView playing_v_3;
    VideoView playing_v_4;
    VideoView playing_v_5;
    VideoView playing_v_6;
    VideoView playing_v_7;
    VideoView playing_v_8;
    VideoView playing_v_9;

    public static boolean isActivityVisible() {
        return activityVisible;
    }

    public static void activityResumed() {
        activityVisible = true;
    }

    public static void activityPaused() {
        activityVisible = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_gallery_view_main);

        marshmallowPermissions = new MarshmallowPermissions(this);
        marshmallowPermissions.CheckOrRequestPermissions();
        playing_v_1 = (VideoView) findViewById(R.id.video_view_holder_1);
        playing_i_1 = (ImageView) findViewById(R.id.image_view_holder_1);
        SharedPreferences prefs = getSharedPreferences(this.MY_PREFS_SETTING, 0);
        String app_m1_url = prefs.getString("m1_url", null);
        String app_m1_type = prefs.getString("m1_type", null);
        String app_m2_url = prefs.getString("m2_url", null);
        String app_m2_type = prefs.getString("m2_type", null);
        String app_m3_url = prefs.getString("m3_url", null);
        String app_m3_type = prefs.getString("m3_type", null);
        String app_m4_url = prefs.getString("m4_url", null);
        String app_m4_type = prefs.getString("m4_type", null);
        String app_m5_url = prefs.getString("m5_url", null);
        String app_m5_type = prefs.getString("m5_type", null);
        String app_m6_url = prefs.getString("m6_url", null);
        String app_m6_type = prefs.getString("m6_type", null);
        String app_m7_url = prefs.getString("m7_url", null);
        String app_m7_type = prefs.getString("m7_type", null);
        String app_m8_url = prefs.getString("m8_url", null);
        String app_m8_type = prefs.getString("m8_type", null);
        String app_m9_url = prefs.getString("m9_url", null);
        String app_m9_type = prefs.getString("m9_type", null);
        String app_m10_url = prefs.getString("m10_url", null);
        String app_m10_type = prefs.getString("m10_type", null);
        final String app_delay = prefs.getString("delay_interval", String.valueOf(3000));

        if (app_m1_url != null && app_m1_type.equals("video")) {
            Uri appm1_url = Uri.parse(app_m1_url);
            imagesFromURL.add(appm1_url);
            imagesFormType.add("video");
            hold.add(Long.valueOf(m37d(appm1_url)));
        }
        if (app_m1_url != null && app_m1_type.equals("image")) {
            imagesFromURL.add(Uri.parse(app_m1_url));
            imagesFormType.add("image");
            hold.add(Long.valueOf(3000));
        }
        if (app_m2_url != null && app_m2_type.equals("video")) {
            Uri appm2_url = Uri.parse(app_m2_url);
            imagesFormType.add("video");
            imagesFromURL.add(appm2_url);
            hold.add(Long.valueOf(m37d(appm2_url)));
        }
        if (app_m2_url != null && app_m2_type.equals("image")) {
            imagesFromURL.add(Uri.parse(app_m2_url));
            imagesFormType.add("image");
            hold.add(Long.valueOf(3000));
        }
        if (app_m3_url != null && app_m3_type.equals("video")) {
            Uri appm3_url = Uri.parse(app_m3_url);
            imagesFormType.add("video");
            imagesFromURL.add(appm3_url);
            hold.add(Long.valueOf(m37d(appm3_url)));
        }
        if (app_m3_url != null && app_m3_type.equals("image")) {
            imagesFromURL.add(Uri.parse(app_m3_url));
            imagesFormType.add("image");
            hold.add(Long.valueOf(3000));
        }
        if (app_m4_url != null && app_m4_type.equals("video")) {
            Uri appm4_url = Uri.parse(app_m4_url);
            imagesFormType.add("video");
            imagesFromURL.add(appm4_url);
            hold.add(Long.valueOf(m37d(appm4_url)));
        }
        if (app_m4_url != null && app_m4_type.equals("image")) {
            imagesFromURL.add(Uri.parse(app_m4_url));
            imagesFormType.add("image");
            hold.add(Long.valueOf(3000));
        }
        if (app_m5_url != null && app_m5_type.equals("video")) {
            Uri appm5_url = Uri.parse(app_m5_url);
            imagesFormType.add("video");
            imagesFromURL.add(appm5_url);
            hold.add(Long.valueOf(m37d(appm5_url)));
        }
        if (app_m5_url != null && app_m5_type.equals("image")) {
            imagesFromURL.add(Uri.parse(app_m5_url));
            imagesFormType.add("image");
            hold.add(Long.valueOf(3000));
        }
        if (app_m6_url != null && app_m6_type.equals("video")) {
            Uri appm6_url = Uri.parse(app_m6_url);
            imagesFormType.add("video");
            imagesFromURL.add(appm6_url);
            hold.add(Long.valueOf(m37d(appm6_url)));
        }
        if (app_m6_url != null && app_m6_type.equals("image")) {
            imagesFromURL.add(Uri.parse(app_m6_url));
            imagesFormType.add("image");
            hold.add(Long.valueOf(3000));
        }
        if (app_m7_url != null && app_m7_type.equals("video")) {
            Uri appm7_url = Uri.parse(app_m7_url);
            imagesFormType.add("video");
            imagesFromURL.add(appm7_url);
            hold.add(Long.valueOf(m37d(appm7_url)));
        }
        if (app_m7_url != null && app_m7_type.equals("image")) {
            imagesFromURL.add(Uri.parse(app_m7_url));
            imagesFormType.add("image");
            hold.add(Long.valueOf(3000));
        }
        if (app_m8_url != null && app_m8_type.equals("video")) {
            Uri appm8_url = Uri.parse(app_m8_url);
            imagesFormType.add("video");
            imagesFromURL.add(appm8_url);
            hold.add(Long.valueOf(m37d(appm8_url)));
        }
        if (app_m8_url != null && app_m8_type.equals("image")) {
            imagesFromURL.add(Uri.parse(app_m8_url));
            imagesFormType.add("image");
            hold.add(Long.valueOf(3000));
        }
        if (app_m9_url != null && app_m9_type.equals("video")) {
            Uri appm9_url = Uri.parse(app_m9_url);
            imagesFormType.add("video");
            imagesFromURL.add(appm9_url);
            hold.add(Long.valueOf(m37d(appm9_url)));
        }
        if (app_m9_url != null && app_m9_type.equals("image")) {
            imagesFromURL.add(Uri.parse(app_m9_url));
            imagesFormType.add("image");
            hold.add(Long.valueOf(3000));
        }
        if (app_m10_url != null && app_m10_type.equals("video")) {
            Uri appm10_url = Uri.parse(app_m10_url);
            imagesFormType.add("video");
            imagesFromURL.add(appm10_url);
            hold.add(Long.valueOf(m37d(appm10_url)));
        }
        if (app_m10_url != null && app_m10_type.equals("image")) {
            imagesFromURL.add(Uri.parse(app_m10_url));
            imagesFormType.add("image");
            hold.add(Long.valueOf(3000));
        }
        //Toast.makeText(this, "gallery option selected", Toast.LENGTH_LONG).show();
        if (imagesFormType.size() > 0) {
            //Toast.makeText(this, imagesFormType.get(2), Toast.LENGTH_LONG).show();
            Handler handler = new Handler();
            final Handler handler2 = handler;
            handler.postDelayed(new Runnable() {
                int f11i = 0;
                long ls_t = Long.parseLong(app_delay);

                public void run() {

                    if (((String)imagesFormType.get(f11i)).equals("video")) {
                       playing_i_1.setVisibility(View.GONE);
                        playing_v_1.setVisibility(View.VISIBLE);
                        playing_v_1.requestFocus();
                        //playing_v_1.setVideoURI((Uri) imagesFromURL.get(f11i));
                        //Toast(getApplicationContext(),"-->",Toast.LENGTH_LONG).show();
                        playing_v_1.setVideoURI(imagesFromURL.get(f11i));
                        playing_v_1.start();
                        playing_v_1.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                GalleryViewMain.this.playing_v_1.start();
                            }
                        });
                        playing_v_1.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                //Toast.makeText(getApplicationContext(), "Run", Toast.LENGTH_LONG).show();
                            }
                        });
                        playing_v_1.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                            @Override
                            public boolean onError(MediaPlayer mp, int what, int extra) {
                                Log.d("video", "setOnErrorListener ");
                                return true;
                            }
                        });
                        handler2.postDelayed(this, ((Long) hold.get(f11i)).longValue());
                    }
                    if (((String)imagesFormType.get(this.f11i)).equals("image")) {
                        playing_v_1.setVisibility(View.GONE);
                        playing_i_1.setVisibility(View.VISIBLE);
                        Picasso.with(getApplicationContext()).load((Uri) imagesFromURL.get(f11i)).into(playing_i_1);
                        Picasso.with(getApplicationContext()).load(new File(String.valueOf(imagesFromURL.get(this.f11i)))).placeholder((int) R.drawable.load).error((int) R.drawable.load).into(playing_i_1);
                        handler2.postDelayed(this, this.ls_t);
                    }
                    f11i++;
                    if (f11i > imagesFromURL.size() - 1) {
                        //Toast.makeText(getApplicationContext(),"Reset ",Toast.LENGTH_LONG).show();
                        f11i = 0;
                    }
                    /*
                    NetworkInfo networkInfo = ((ConnectivityManager) GalleryViewMain.this.getSystemService("connectivity")).getActiveNetworkInfo();
                    if (networkInfo == null || !networkInfo.isConnected()) {
                        GalleryViewMain.this.changeTextStatus(false);
                    } else {
                        GalleryViewMain.this.changeTextStatus(true);
                    }
                    */
                }
            }, 2000);
        }
    }

    public long m37d(Uri i) {
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        retriever.setDataSource(this, i);
        long timeInmillisec = Long.parseLong(retriever.extractMetadata(9));
        long duration = timeInmillisec / 1000;
        long hours = duration / 3600;
        long seconds = duration - ((3600 * hours) + (60 * ((duration - (3600 * hours)) / 60)));
        return timeInmillisec;
    }

    public void changeTextStatus(boolean isConnected) {
        if (isConnected) {
            Intent sflashw = new Intent(getApplicationContext(), WebViewMain.class);
            sflashw.setFlags(67108864);
            sflashw.setFlags(268435456);
            sflashw.setFlags(1073741824);
            startActivity(sflashw);
            finish();
        }
    }

    public void onPause() {
        super.onPause();
        activityPaused();
    }

    public void onResume() {
        super.onResume();
        activityResumed();
    }
}
