package com.horsege.atlastjavatest;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.horsege.atlastjavatest.update.Updater;
import com.horsege.middleawaylibrary.BaseActivity;
import com.horsege.middleawaylibrary.PublicService;
import com.taobao.android.ActivityGroupDelegate;
import com.taobao.atlas.update.AtlasUpdater;

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

        ((BottomNavigationView) findViewById(R.id.bottomNavView)).setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        actGroupCompat = new ActivityGroupDelegate(this, savedInstanceState);

        switchToActivity("FirstBundle", "com.horsege.firstbundle.FirstBundleActivity");
    }

    public void switchToActivity(String key, String activityName) {
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
            case R.id.updatePatchBundle:
                new AsyncTask<Void, Void, Void>() {

                    @Override
                    protected Void doInBackground(Void... voids) {
                        Updater.update(getBaseContext());
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        android.os.Process.killProcess(android.os.Process.myPid());
                    }
                }.execute();
                break;
            //但Bundle调试：../gradlew clean assemblePatchDebug
            case R.id.dexPatchBundle:
                new AsyncTask<Void, Void, Void>() {

                    @Override
                    protected Void doInBackground(Void... voids) {
                        Updater.dexPatchUpdate(getBaseContext());
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        android.os.Process.killProcess(android.os.Process.myPid());
                    }
                }.execute();
                break;
            case R.id.startPublicService:
                Intent publicServiceInent = new Intent(this, PublicService.class);
                startService(publicServiceInent);
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
