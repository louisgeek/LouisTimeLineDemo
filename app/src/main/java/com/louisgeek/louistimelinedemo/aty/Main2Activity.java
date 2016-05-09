package com.louisgeek.louistimelinedemo.aty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.louisgeek.louistimelinedemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 不适合列表的
 */
public class Main2Activity extends AppCompatActivity {

    @Bind(R.id.id_btn_2_3)
    Button idBtn23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.id_btn_2_3)
    public void onClick() {
        Intent intent=new Intent(this,Main3Activity.class);
        startActivity(intent);
    }
}
