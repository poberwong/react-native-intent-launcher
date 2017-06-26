package com.poberwong.launcher;

import android.app.Activity;
import android.content.Intent;
import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.facebook.react.bridge.*;

import java.io.Console;
import java.util.Set;
import java.util.Iterator;

/**
 * Created by poberwong on 16/6/30.
 */
public class IntentLauncherModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    private static final String ATTR_ACTION = "action";
    private static final String ATTR_CATEGORY = "category";
    private static final String TAG_EXTRA = "extra";
    private static final String ATTR_DATA = "data";
    private static final String ATTR_FLAGS = "flags";
    Promise promise;

    public IntentLauncherModule(ReactApplicationContext reactContext) {
        super(reactContext);
        reactContext.addActivityEventListener(this);
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
    public void startActivity(ReadableMap params, final Promise promise){
        this.promise = promise;
        try {
          ComponentName cn = new ComponentName(params.getString(ATTR_DATA), params.getString(ATTR_ACTION));
          Intent intent = new Intent();
          intent.setComponent(cn);
          Log.d("IntentLauncherModule", "Opening");
          if (params.hasKey(TAG_EXTRA)) {
              intent.putExtras(Arguments.toBundle(params.getMap(TAG_EXTRA)));
          }
          if (params.hasKey(ATTR_FLAGS)) {
              intent.addFlags(params.getInt(ATTR_FLAGS));
          }
          if (params.hasKey(ATTR_CATEGORY)) {
              intent.addCategory(params.getString(ATTR_CATEGORY));
          }
          getReactApplicationContext().startActivityForResult(intent, 12, null); // 暂时使用当前应用的任务栈
        } catch (Exception e) {
          promise.reject("ERROR", "Could not open intent");
        }
    }

    @ReactMethod
    public void startActivityOnlyIntent (ReadableMap params, final Promise promise) {
        this.promise = promise;
        try {
            Intent intent = new Intent(params.getString(ATTR_DATA));
            if (params.hasKey(TAG_EXTRA)) {
                intent.putExtras(Arguments.toBundle(params.getMap(TAG_EXTRA)));
            }
            if (params.hasKey(ATTR_FLAGS)) {
                intent.addFlags(params.getInt(ATTR_FLAGS));
            }
            if (params.hasKey(ATTR_CATEGORY)) {
                intent.addCategory(params.getString(ATTR_CATEGORY));
            }
            getReactApplicationContext().startActivityForResult(intent, 12, null); // 暂时使用当前应用的任务栈
        } catch (Exception e) {
            promise.reject("ERROR", "Could not open intent");
        }
    }

    @Override
    public void onNewIntent(Intent intent) { }

    @Override
    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
      if (requestCode != 12) {
        return;
      }
      WritableMap params = Arguments.createMap();
      Bundle extras = data.getExtras();

        Set<String> keys = extras.keySet();
        Iterator<String> it = keys.iterator();
        Log.e("LGC","Dumping Intent start");
        while (it.hasNext()) {
            String key = it.next();
            
            if (extras.get(key) instanceof String) {
                params.putString(key, (String) extras.get(key));
            }

            if (extras.get(key) instanceof Integer) {
                params.putInt(key, (Integer) extras.get(key));
            }

            if (extras.get(key) instanceof Double) {
                params.putDouble(key, (Double) extras.get(key));
            }

            if (extras.get(key) instanceof Boolean) {
                params.putBoolean(key, (Boolean) extras.get(key));
            }
            
            Log.e("LGC", "[" + key + "=" + extras.get(key) + "]");
        }

      // params = Arguments.fromBundle(extras);

      this.promise.resolve(params);

    }
}
