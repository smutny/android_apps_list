package com.example.smutny.appslistapplication;

import android.app.ListActivity;
import android.content.pm.PackageInfo;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MyListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ArrayList<AppInfo> appsList = getAppInfoList(false);
        final MyArrayAdapter adapter = new MyArrayAdapter(this, appsList);
        setListAdapter(adapter);
    }

    private ArrayList<AppInfo> getAppInfoList(boolean getSysPackages) {
        ArrayList<AppInfo> appInfoList = new ArrayList<AppInfo>();
        List<PackageInfo> packages = getPackageManager().getInstalledPackages(0);

        for (PackageInfo packageInfo : packages) {
            if ((!getSysPackages) && (packageInfo.versionName == null)) {
                continue ;
            }
            AppInfo newInfo = new AppInfo();
            newInfo.setAppName(packageInfo.applicationInfo.loadLabel(getPackageManager()).toString());
            newInfo.setPackageName(packageInfo.packageName);
            newInfo.setVersionName(packageInfo.versionName);
            newInfo.setVersionCode(packageInfo.versionCode);
            newInfo.setIcon(packageInfo.applicationInfo.loadIcon(getPackageManager()));
            appInfoList.add(newInfo);
        }

        return appInfoList;
    }
}
