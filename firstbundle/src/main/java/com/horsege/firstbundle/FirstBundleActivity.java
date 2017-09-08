package com.horsege.firstbundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.horsege.middleawaylibrary.BaseActivity;
import com.horsege.middleawaylibrary.PublicService;

public class FirstBundleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_bundle);

//        Toast.makeText(this, "First Bundle FirstChanged", Toast.LENGTH_LONG).show();

        findViewById(R.id.startPublicService).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent publicServiceInent = new Intent(FirstBundleActivity.this, PublicService.class);
                startService(publicServiceInent);
            }
        });
    }


}
