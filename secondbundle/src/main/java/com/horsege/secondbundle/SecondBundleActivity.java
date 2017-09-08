package com.horsege.secondbundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.horsege.middleawaylibrary.BaseActivity;
import com.horsege.middleawaylibrary.PublicService;

public class SecondBundleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_bundle);

        findViewById(R.id.startPublicService).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent publicServiceInent = new Intent(SecondBundleActivity.this, PublicService.class);
                startService(publicServiceInent);
            }
        });
    }
}
