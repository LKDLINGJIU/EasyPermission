package com.android.yucheng.easypermission;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

import com.android.yucheng.permission_lib.EasyPermission;
import com.android.yucheng.permission_lib.bean.Permission;
import com.android.yucheng.permission_lib.callback.RequestPermissionCallback;

/**
 * Created by lingjiu on 2019/7/2.
 */
public class Utils {

    public static void makeCell(final Activity activity, final String cell) {
        final String[] permission = new String[]{Manifest.permission.CALL_PHONE};
        EasyPermission.getInstance().requestPermission(permission, new RequestPermissionCallback() {
            @Override
            public void requestPermissionResult(Permission[] permissions) {
                for (Permission permission1 : permissions) {
                    if (TextUtils.equals(permission1.getPermissionName(), Manifest.permission.CALL_PHONE)) {
                        if (permission1.isGrant()) {
                            Intent intent = new Intent();
                            intent.setAction(Intent.ACTION_CALL);
                            intent.setData(Uri.parse("tel:" + cell));
                            activity.startActivity(intent);
                        }
                    }
                }
            }
        });
    }
}
