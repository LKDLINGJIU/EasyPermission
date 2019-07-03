package com.android.yucheng.permission_lib;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.lang.ref.WeakReference;

/**
 * Created by lingjiu on 2019/7/2.
 */
public class ObtainTopActivity implements Application.ActivityLifecycleCallbacks {

    private WeakReference<Activity> topActivity;

    private static ObtainTopActivity obtainTopActivity;

    public static ObtainTopActivity getDefault() {
        if (obtainTopActivity == null) {
            obtainTopActivity = new ObtainTopActivity();
        }
        return obtainTopActivity;
    }

    private ObtainTopActivity() {
    }

    public Activity getTopActivity() {
        if (topActivity == null)
            return null;
        return topActivity.get();
    }

    public void init(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        topActivity = new WeakReference<>(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {
        topActivity = new WeakReference<>(activity);
    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
