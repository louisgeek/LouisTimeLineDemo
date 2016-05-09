package com.louisgeek.louistimelinedemo.aty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import com.louisgeek.louistimelinedemo.R;
import com.louisgeek.louistimelinedemo.adapter.MyBaseAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 线作用于item上
 */
public class Main3Activity extends AppCompatActivity {

    @Bind(R.id.id_btn_3_4)
    Button idBtn34;
    @Bind(R.id.id_lv)
    ListView idLv;


    private List<Map<String,Object>> mapList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);

        for (int i = 0; i < 10; i++) {
            Map<String,Object> map=new HashMap<>();
            map.put("name","标题"+i);
            mapList.add(map);
        }

        MyBaseAdapter mMyBaseAdapter=new MyBaseAdapter(mapList,this);
        idLv.setAdapter(mMyBaseAdapter);
    }

    @OnClick(R.id.id_btn_3_4)
    public void onClick() {
        Intent intent=new Intent(this,Main4Activity.class);
        startActivity(intent);
    }
}
