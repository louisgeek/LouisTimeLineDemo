package com.louisgeek.louistimelinedemo.aty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.louisgeek.louistimelinedemo.Bean.ChildBean;
import com.louisgeek.louistimelinedemo.Bean.GroupBean;
import com.louisgeek.louistimelinedemo.R;
import com.louisgeek.louistimelinedemo.adapter.MyBaseExpandableListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 线作用于aty上
 */
public class Main4Activity extends AppCompatActivity {

    @Bind(R.id.id_expandlist)
    ExpandableListView idExpandlist;

    List<GroupBean> groupBeanList = new ArrayList<>();
    @Bind(R.id.id_btn_4_34)
    Button idBtn434;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ButterKnife.bind(this);


        for (int i = 0; i < 10; i++) {
            GroupBean groupBean = new GroupBean();
            groupBean.setGroupName("父" + i);

            List<ChildBean> cbs = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                ChildBean childBean = new ChildBean();
                childBean.setChildName("父" + i + "的子" + j);
                cbs.add(childBean);
            }
            groupBean.setChildList(cbs);
            groupBeanList.add(groupBean);
        }

        MyBaseExpandableListAdapter myBaseExpandableListAdapter = new MyBaseExpandableListAdapter(groupBeanList, this);
        idExpandlist.setAdapter(myBaseExpandableListAdapter);
        idExpandlist.setGroupIndicator(null); // 去掉默认带的箭头
        //idExpandlist.setSelection(0);// 设置默认选中项

        // 遍历所有group,将所有项设置成默认展开
        int groupCount = idExpandlist.getCount();
        for (int i = 0; i < groupCount; i++) {
            idExpandlist.expandGroup(i);
        }

        idExpandlist.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(Main4Activity.this, "groupPosition:" + groupPosition, Toast.LENGTH_SHORT).show();
                // return false;
                return true;//不收缩
            }
        });

        idExpandlist.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(Main4Activity.this, "childPosition:" + childPosition, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @OnClick(R.id.id_btn_4_34)
    public void onClick() {
        Intent intent=new Intent(this,Main3_And4Activity.class);
        startActivity(intent);
    }
}
