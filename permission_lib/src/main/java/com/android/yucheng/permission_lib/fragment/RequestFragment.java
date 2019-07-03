package com.android.yucheng.permission_lib.fragment;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;

import com.android.yucheng.permission_lib.IRequestPermission;
import com.android.yucheng.permission_lib.bean.Permission;
import com.android.yucheng.permission_lib.callback.RequestPermissionCallback;

/**
 * Created by lingjiu on 2019/7/1.
 */
public class RequestFragment extends Fragment implements IRequestPermission {
    private int REQUEST_PERMISSION_CODE = 0x11;

    RequestPermissionCallback permissionCallback;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //切换横竖屏时,fragment不会被销毁
        setRetainInstance(true);
    }

    @Override
    public void requestPermission(String[] permissions, RequestPermissionCallback listener) {
        requestPermissions(permissions, REQUEST_PERMISSION_CODE);
        permissionCallback = listener;
    }

    @Override
    public boolean checkPermission(String[] permissions) {
        for (String permission : permissions) {
            if (ActivityCompat.checkSelfPermission(getContext(), permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            Permission[] permissionArray = new Permission[permissions.length];
            for (int i = 0; i < permissions.length; i++) {
                Permission permission = new Permission();
                permission.setGrant(grantResults[i]);
                permission.setPermissionName(permissions[i]);
                permissionArray[i] = permission;
            }
            permissionCallback.requestPermissionResult(permissionArray);
        }
    }
}
