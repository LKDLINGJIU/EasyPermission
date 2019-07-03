package com.android.yucheng.permission_lib;

import com.android.yucheng.permission_lib.callback.RequestPermissionCallback;

/**
 * Created by lingjiu on 2019/7/1.
 */
public interface IRequestPermission {

    void requestPermission(String[] permissions, RequestPermissionCallback listener);

    boolean checkPermission(String[] permissions);

}
