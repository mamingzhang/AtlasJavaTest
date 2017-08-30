package com.horsege.atlastjavatest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.taobao.android.ActivityGroupDelegate;

import static android.R.attr.key;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityGroupDelegate actGroupCompat = new ActivityGroupDelegate(this, savedInstanceState);

        Intent intent = new Intent();
        intent.setClassName(getBaseContext(), "com.horsege.firstbundle.FirstBundleActivity");
        actGroupCompat.startChildActivity((ViewGroup) findViewById(R.id.content), "FirstBundle", intent);
    }
}
