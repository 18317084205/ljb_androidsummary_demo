package com.ljb.summary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ljb.summary.R;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class ButterKnifeListViewAdapter extends BaseAdapter {

    private Context context;
    private List<String> chars;

    public ButterKnifeListViewAdapter(Context context, List<String> chars) {
        this.context = context;
        this.chars = chars;
    }

    @Override
    public int getCount() {
        return chars.size();
    }

    @Override
    public String getItem(int position) {
        return chars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.butterknife_lv_item, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(String cha, ViewHolder holder) {
        holder.butterknifeItemTv.setText("id: "+ cha);
        holder.butterknifeItemIv.setImageResource(R.drawable.ic_launcher);
    }

    static class ViewHolder {
        @InjectView(R.id.butterknife_item_iv)
        ImageView butterknifeItemIv;
        @InjectView(R.id.butterknife_item_tv)
        TextView butterknifeItemTv;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
