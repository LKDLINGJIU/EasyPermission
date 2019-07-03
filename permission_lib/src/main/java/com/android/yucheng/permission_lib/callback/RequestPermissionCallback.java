package com.android.yucheng.permission_lib.callback;

import com.android.yucheng.permission_lib.bean.Permission;

/**
 * Created by lingjiu on 2019/7/1.
 */
public interface RequestPermissionCallback {

    void requestPermissionResult(Permission[] permissions);
}
