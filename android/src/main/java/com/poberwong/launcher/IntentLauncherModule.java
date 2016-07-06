package com.poberwong.launcher;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

import java.io.Console;

/**
 * Created by poberwong on 16/6/30.
 */
public class IntentLauncherModule extends ReactContextBaseJavaModule {
    private static final String ATTR_ACTION = "action";
    private static final String ATTR_CATEGORY = "category";
    private static final String TAG_EXTRA = "extra";
    private static final String ATTR_DATA = "data";
    private static final String ATTR_FLAGS = "flags";

    public IntentLauncherModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "IntentLauncher";
    }

    /**
     * 选用方案
     * intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
     * getReactApplicationContext().startActivity(intent);
     */
    @ReactMethod
    public void startActivity(ReadableMap params){
        Intent intent = new Intent();
        if (params.hasKey(ATTR_DATA)) {
            intent.setData(Uri.parse(params.getString(ATTR_DATA)));
        }
        if (params.hasKey(TAG_EXTRA)) {
            intent.putExtras(Arguments.toBundle(params.getMap(TAG_EXTRA)));
        }
        if (params.hasKey(ATTR_FLAGS)) {
            intent.addFlags(params.getInt(ATTR_FLAGS));
        }
        if (params.hasKey(ATTR_CATEGORY)) {
            intent.addCategory(params.getString(ATTR_CATEGORY));
        }
        if (params.hasKey(ATTR_ACTION)) {
            intent.setAction(params.getString(ATTR_ACTION));
        }
        getReactApplicationContext().startActivityForResult(intent, 0, null); // 暂时使用当前应用的任务栈
    }
}
