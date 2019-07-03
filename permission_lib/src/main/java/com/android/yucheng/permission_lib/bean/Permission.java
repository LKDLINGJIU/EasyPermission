package com.android.yucheng.permission_lib.bean;

import android.content.pm.PackageManager;

/**
 * Created by lingjiu on 2019/7/1.
 */
public class Permission {
    String permissionName;

    int grant;

    //描述
    String desc;

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public int getGrant() {
        return grant;
    }

    public void setGrant(int grant) {
        this.grant = grant;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isGrant() {
        return grant == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionName='" + permissionName + '\'' +
                ", grant=" + grant +
                ", desc='" + desc + '\'' +
                '}';
    }
}
