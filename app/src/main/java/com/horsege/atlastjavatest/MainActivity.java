package com.horsege.atlastjavatest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.horsege.middleawaylibrary.BaseActivity;
import com.taobao.android.ActivityGroupDelegate;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityGroupDelegate actGroupCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        ((BottomNavigationView)findViewById(R.id.bottomNavView)).setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        actGroupCompat = new ActivityGroupDelegate(this, savedInstanceState);

        switchToActivity("FirstBundle", "com.horsege.firstbundle.FirstBundleActivity");
    }

    public void switchToActivity(String key,String activityName){
        Intent intent = new Intent();
        intent.setClassName(getBaseContext(), activityName);
        actGroupCompat.startChildActivity((ViewGroup) findViewById(R.id.content), key, intent);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.loadRemoteBundle:
                Intent intent = new Intent();
                intent.setClassName(MainActivity.this, "com.horsege.remotebundle.RemoteBundleActivity");
                startActivity(intent);
                break;
        }
        return false;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.first_tab:
                    switchToActivity("FirstBundle", "com.horsege.firstbundle.FirstBundleActivity");
                    break;
                case R.id.second_tab:
                    switchToActivity("SecondBundle", "com.horsege.secondbundle.SecondBundleActivity");
                    break;
            }
            return false;
        }

    };
}
