package com.halohoop.aopprogramdemo;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.halohoop.aoplib.annotation.DealingTrace;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Halohoop";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_thumb).setOnClickListener(this);
        findViewById(R.id.btn_unthumb).setOnClickListener(this);
        findViewById(R.id.btn_sound).setOnClickListener(this);
        findViewById(R.id.btn_word).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_thumb:
                thumb();
                break;
            case R.id.btn_unthumb:
                unthumb();
                break;
            case R.id.btn_sound:
                sound();
                break;
            case R.id.btn_word:
                word();
                break;
        }
    }

//    @DealingTrace(value2 = "thumb", type1 = 77, type2 = 78)
    private void thumb() {
        long start = System.currentTimeMillis();
        SystemClock.sleep(3000);
        Log.i(TAG, "thumb: executed.");
        long elapse = System.currentTimeMillis() - start;
        Log.i(TAG, "dealMethod1: 耗时 ：" + elapse + "ms");
    }

    @DealingTrace(value1 = "halo2", value2 = "unthumb", type1 = 79, type2 = 80)
    private void unthumb() {
        SystemClock.sleep(3000);
        Log.i(TAG, "unthumb: executed.");
    }

    @DealingTrace(value1 = "halo3", value2 = "sound", type1 = 81, type2 = 82)
    private void sound() {
        Log.i(TAG, "sound: executed.");
    }

    @DealingTrace(value1 = "halo4", value2 = "word", type1 = 83, type2 = 84)
    private void word() {
        Log.i(TAG, "word: executed.");
    }
}
