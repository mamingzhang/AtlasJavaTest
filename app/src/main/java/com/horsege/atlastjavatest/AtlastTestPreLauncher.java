package com.horsege.atlastjavatest;

import android.content.Context;
import android.taobao.atlas.runtime.AtlasPreLauncher;
import android.util.Log;

/**
 * Created by mamingzhang on 2017/8/22.
 */

public class AtlastTestPreLauncher implements AtlasPreLauncher {

    @Override
    public void initBeforeAtlas(Context context) {
        Log.e("mmz", "initBeforeAtlas");

    }
}