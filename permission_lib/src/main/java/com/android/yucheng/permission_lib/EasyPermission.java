package com.android.yucheng.permission_lib;

import com.android.yucheng.permission_lib.callback.RequestPermissionCallback;

/**
 * Created by lingjiu on 2019/7/2.
 */
public class EasyPermission implements IRequestPermission {
    private IRequestPermission requestPermissionProx;

    private static EasyPermission easyPermission ;

    private EasyPermission() {
        requestPermissionProx = new RequestPermission(ObtainTopActivity.getDefault().getTopActivity());
    }

    public static EasyPermission getInstance() {
        if (easyPermission == null) {
            easyPermission = new EasyPermission();
        }
        return easyPermission;
    }


    @Override
    public void requestPermission(String[] permissions, RequestPermissionCallback listener) {
        requestPermissionProx.requestPermission(permissions, listener);
    }

    @Override
    public boolean checkPermission(String[] permissions) {
        return requestPermissionProx.checkPermission(permissions);
    }
}
