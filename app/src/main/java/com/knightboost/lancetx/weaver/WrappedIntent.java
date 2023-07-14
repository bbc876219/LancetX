package com.knightboost.lancetx.weaver;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class WrappedIntent extends Intent {
    public WrappedIntent(){
        super();
        Log.d(TAG, "WrappedIntent() called");
    }
    public WrappedIntent(Intent o) {
        super(o);
        Log.d(TAG, "WrappedIntent() called with: old = [" + o + "]");
    }

    public WrappedIntent(String action) {
        super(action);
        Log.d(TAG, "WrappedIntent() called with: action = [" + action + "]");
    }

    public WrappedIntent(String action, Uri uri) {
        super(action, uri);
        Log.d(TAG, "WrappedIntent() called with: action = [" + action + "], uri = [" + uri + "]");
    }

    private static final String TAG = "IntentProxy";
    public WrappedIntent(Context packageContext, Class<?> cls) {
        super(packageContext, cls);
        Log.d(TAG, "WrappedIntent() called with: packageContext = [" + packageContext + "], cls = [" + cls + "]");
    }

    public WrappedIntent(String action, Uri uri, Context packageContext, Class<?> cls) {
        super(action, uri, packageContext, cls);
        Log.d(TAG, "WrappedIntent() called with: action = [" + action + "], uri = [" + uri + "], packageContext = [" + packageContext + "], cls = [" + cls + "]");
    }
}
