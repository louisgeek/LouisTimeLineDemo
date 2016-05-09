package com.louisgeek.louistimelinedemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.louisgeek.louistimelinedemo.R;

import java.util.List;
import java.util.Map;

/**
 * Created by louisgeek on 2016/5/9.
 */
public class MyBaseAdapter extends BaseAdapter {

    private List<Map<String,Object>> mapList;
    private Context context;

    public MyBaseAdapter(List<Map<String, Object>> mapList, Context context) {
        this.mapList = mapList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mapList.size();
    }

    @Override
    public Object getItem(int position) {
        return mapList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null) {
            holder=new ViewHolder();
            convertView=LayoutInflater.from(context).inflate(R.layout.conetent_layout_3, null);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder) convertView.getTag();
        }
        holder.imageView=(ImageView) convertView.findViewById(R.id.left_imageview);
        holder.show=(TextView) convertView.findViewById(R.id.right_textview);

       // holder.imageView.setImageResource();
        holder.show.setText(mapList.get(position).get("name").toString());
        return convertView;
    }


    class ViewHolder{
      ImageView  imageView;
      TextView   show;
    }
}
