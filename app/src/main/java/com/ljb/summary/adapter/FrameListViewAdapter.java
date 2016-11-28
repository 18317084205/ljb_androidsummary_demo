package com.ljb.summary.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ljb.summary.R;
import com.ljb.summary.bean.TypeInfo;

import java.util.List;


public class FrameListViewAdapter extends BaseAdapter {

    private Context context;
    private List<TypeInfo> itemTitles;

    public FrameListViewAdapter(Context context, List<TypeInfo> itemTitles) {
        this.context = context;
        this.itemTitles = itemTitles;
    }

    @Override
    public int getCount() {
        return itemTitles.size();
    }

    @Override
    public TypeInfo getItem(int position) {
        return itemTitles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView titleView = new TextView(context);
        titleView.setTextColor(ContextCompat.getColor(context,R.color.colorblue));
        titleView.setTextSize(20);
        titleView.setPadding(20, 20, 20, 20);
        titleView.setText(getItem(position).getName());
        return titleView;
    }
}
