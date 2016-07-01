package com.poberwong;

import android.app.Activity;
import android.content.Intent;
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
public class IntentLauncherModule extends ReactContextBaseJavaModule{
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
     * @param action
     * used for startActivity with action and extras
     */
    @ReactMethod
    public void startActivity(String action, ReadableMap extra){
        Intent intent = new Intent(action);
        intent.putExtras(Arguments.toBundle(extra));
        getReactApplicationContext().startActivityForResult(intent, 0, null); // 暂时使用当前应用的任务栈
    }

    @ReactMethod
    public void startService(){

    }

    @ReactMethod
    public void bindService(){}
}
