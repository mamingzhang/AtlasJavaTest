package com.horsege.firstbundle;

import android.os.Bundle;
import android.widget.Toast;

import com.horsege.middleawaylibrary.BaseActivity;

public class FirstBundleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_bundle);

        Toast.makeText(this, "First Bundle FirstChanged", Toast.LENGTH_LONG).show();
    }


}
