package com.louisgeek.louistimelinedemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.louisgeek.louistimelinedemo.Bean.ItemBean;
import com.louisgeek.louistimelinedemo.R;

import java.util.List;

/**
 * Created by louisgeek on 2016/5/9.
 */
public class My_3_4_BaseAdapter extends BaseAdapter {
    List<ItemBean> itemBeans;
    Context context;

    public My_3_4_BaseAdapter(List<ItemBean> itemBeans, Context context) {
        this.itemBeans = itemBeans;
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return itemBeans.get(position);
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
            convertView= LayoutInflater.from(context).inflate(R.layout.conetent_layout_3_and_4, null);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder) convertView.getTag();
        }
        holder.id_tv_item=(TextView) convertView.findViewById(R.id.id_tv_item);

        holder.id_tv_item.setText(itemBeans.get(position).getItemName());
        return convertView;
    }

    class ViewHolder{
        TextView id_tv_item;
    }
}
