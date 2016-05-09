package com.louisgeek.louistimelinedemo.aty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.louisgeek.louistimelinedemo.Bean.ItemBean;
import com.louisgeek.louistimelinedemo.R;
import com.louisgeek.louistimelinedemo.adapter.My_3_4_BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 线作用于aty上
 */
public class Main3_And4Activity extends AppCompatActivity {

    @Bind(R.id.id_lv_3_4)
    ListView idLv34;

    List<ItemBean> itemBeans=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3__and4);
        ButterKnife.bind(this);

        for (int i = 0; i < 10; i++) {
            ItemBean itemBean=new ItemBean();
            itemBean.setItemName("name" + i);
            itemBeans.add(itemBean);
        }

        My_3_4_BaseAdapter my_3_4_baseAdapter=new My_3_4_BaseAdapter(itemBeans,this);
        idLv34.setAdapter(my_3_4_baseAdapter);

        idLv34.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Main3_And4Activity.this, "position:"+position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
