package com.example.smutny.appslistapplication;

import android.graphics.drawable.Drawable;

public class AppInfo {
    private String appName = "";
    private String packageName = "";
    private String versionName = "";
    private int versionCode = 0;
    private Drawable icon;


    public String getAppName() {
        return appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}
