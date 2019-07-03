package com.android.yucheng.permission_lib;


import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.android.yucheng.permission_lib.callback.RequestPermissionCallback;
import com.android.yucheng.permission_lib.fragment.RequestFragment;

/**
 * Created by lingjiu on 2019/7/1.
 */
public class RequestPermission implements IRequestPermission {
    private RequestFragment requestFragment;
    private String TAG = "request_fragment_tag";


    public RequestPermission(Activity activity) {
        requestFragment = new RequestFragment();
        if (activity instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) activity;
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            requestFragment = (RequestFragment) supportFragmentManager.findFragmentByTag(TAG);
            if (requestFragment == null) {
                requestFragment = new RequestFragment();
                supportFragmentManager
                        .beginTransaction()
                        .add(requestFragment, TAG)
                        .commitNowAllowingStateLoss();
            }
        } else {
           /* activity.getFragmentManager()
                    .beginTransaction()
                    .add(requestFragment, TAG)
                    .commitAllowingStateLoss();*/
        }

    }

    @Override
    public void requestPermission(String[] permissions, RequestPermissionCallback listener) {
        requestFragment.requestPermission(permissions, listener);
    }

    @Override
    public boolean checkPermission(String[] permissions) {
        return requestFragment.checkPermission(permissions);
    }
}
