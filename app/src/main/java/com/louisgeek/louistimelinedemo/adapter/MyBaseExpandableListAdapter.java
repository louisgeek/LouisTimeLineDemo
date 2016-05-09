package com.louisgeek.louistimelinedemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.louisgeek.louistimelinedemo.Bean.GroupBean;
import com.louisgeek.louistimelinedemo.R;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by louisgeek on 2016/5/9.
 */
public class MyBaseExpandableListAdapter extends BaseExpandableListAdapter {

    List<GroupBean> groupBeanList;
    Context context;
    LayoutInflater layoutInflater;

    public MyBaseExpandableListAdapter(List<GroupBean> groupBeanList, Context context) {
        this.groupBeanList = groupBeanList;
        this.context = context;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return groupBeanList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groupBeanList.get(groupPosition).getChildList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupBeanList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groupBeanList.get(groupPosition).getChildList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder=null;
        if (convertView==null) {
            groupViewHolder=new GroupViewHolder();
            convertView=layoutInflater.inflate(R.layout.group_item, null, false);
            groupViewHolder.id_tv_g=ButterKnife.findById(convertView,R.id.id_tv_g);

            convertView.setTag(groupViewHolder);
        }else
        {
            groupViewHolder= (GroupViewHolder) convertView.getTag();
        }
        groupViewHolder.id_tv_g.setText(groupBeanList.get(groupPosition).getGroupName());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder=null;
        if (convertView==null) {
            childViewHolder=new ChildViewHolder();
            convertView=layoutInflater.inflate(R.layout.child_item, null, false);
            childViewHolder.id_tv_c=ButterKnife.findById(convertView,R.id.id_tv_c);

            convertView.setTag(childViewHolder);
        }else
        {
            childViewHolder= (ChildViewHolder) convertView.getTag();
        }
        childViewHolder.id_tv_c.setText(groupBeanList.get(groupPosition).getChildList().get(childPosition).getChildName());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
       // return false;
        return true;//子项可选择
    }

    class GroupViewHolder{
        TextView id_tv_g;
    }
    class ChildViewHolder{
        TextView id_tv_c;
    }
}
