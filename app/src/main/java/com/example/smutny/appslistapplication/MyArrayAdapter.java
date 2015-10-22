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

    static class ViewHolder {
        public TextView appName;
        public TextView appPackageName;
        public ImageView icon;
    }

    public MyArrayAdapter(Context context, List<AppInfo> appInfoList) {
        super(context, R.layout.rowlayout, appInfoList);
        this.context = context;
        this.appInfoList = appInfoList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        // reuse views
        if (rowView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            rowView = inflater.inflate(R.layout.rowlayout, parent, false);
            // configure view holder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.appName = (TextView) rowView.findViewById(R.id.app_name_label);
            viewHolder.appPackageName = (TextView) rowView.findViewById(R.id.app_package_name_label);
            viewHolder.icon = (ImageView) rowView.findViewById(R.id.app_icon);
            rowView.setTag(viewHolder);
        }

        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.appName.setText(appInfoList.get(position).getAppName());
        holder.appPackageName.setText(appInfoList.get(position).getPackageName());
        holder.icon.setImageDrawable(appInfoList.get(position).getIcon());

        return rowView;
    }
}
