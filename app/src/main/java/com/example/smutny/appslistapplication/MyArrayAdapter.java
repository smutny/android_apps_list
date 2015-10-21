package com.example.smutny.appslistapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<AppInfo> {
    private final Context context;
    private final List<AppInfo> appInfoList;

    public MyArrayAdapter(Context context, List<AppInfo> appInfoList) {
        super(context, -1, appInfoList);
        this.context = context;
        this.appInfoList = appInfoList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.app_name_label);
        TextView textView2 = (TextView) rowView.findViewById(R.id.app_package_name_label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.app_icon);

        textView.setText(appInfoList.get(position).getAppName());
        textView2.setText(appInfoList.get(position).getPackageName());
        imageView.setImageDrawable(appInfoList.get(position).getIcon());

        return rowView;
    }
}
