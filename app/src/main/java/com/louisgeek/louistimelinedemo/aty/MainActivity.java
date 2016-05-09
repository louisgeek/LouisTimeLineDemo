package com.louisgeek.louistimelinedemo.aty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.louisgeek.louistimelinedemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import razerdp.widget.UnderLineLinearLayout;

/**
 * 第三方类库   横竖都行  动态添加
 */
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.underline_layout)
    UnderLineLinearLayout underlineLayout;
    @Bind(R.id.underline_layout_h)
    UnderLineLinearLayout underlineLayoutH;
    @Bind(R.id.id_btn_1_2)
    Button idBtn12;


    /**
     * <declare-styleable name="UnderLineLinearLayout">
     * <!--时间轴偏移值-->
     * <attr name="line_margin_side" format="dimension"/>
     * <!--时间轴动态调整值-->
     * <attr name="line_dynamic_dimen" format="dimension"/>
     * <!--线宽-->
     * <attr name="line_stroke_width" format="dimension"/>
     * <!--线的颜色-->
     * <attr name="line_color" format="color"/>
     * <!--点的大小-->
     * <attr name="point_size" format="dimension"/>
     * <!--点的颜色-->
     * <attr name="point_color" format="color"/>
     * <!--图标-->
     * <attr name="icon_src" format="reference"/>
     * <!--时间轴的gravity-->
     * <!--the gravity of the timeline-->
     * <attr name="line_gravity">
     * <enum name="Left" value="2"/>
     * <enum name="Right" value="4"/>
     * <enum name="Middle" value="0"/>
     * <enum name="Top" value="1"/>
     * <enum name="Bottom" value="3"/>
     * </attr>
     * </declare-styleable>
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        initV();
        // initH();

    }

    private void initV() {
        for (int i = 0; i < 10; i++) {
            View conetent_layout = LayoutInflater.from(this).inflate(R.layout.conetent_layout, null, false);
            TextView id_tv = ButterKnife.findById(conetent_layout, R.id.id_tv);
            id_tv.setText("测试" + i);
            underlineLayout.addView(conetent_layout);
            // underlineLayout.removeViews(underlineLayout.getChildCount() - 1, 1);
            underlineLayout.setLineGravity(UnderLineLinearLayout.GRAVITY_MIDDLE);
            //underlineLayout.setIcon(R.mipmap.ic_launcher);

        }
    }

    private void initH() {
        for (int i = 0; i < 3; i++) {
            View conetent_layout = LayoutInflater.from(this).inflate(R.layout.conetent_layout, null, false);
            TextView id_tv = ButterKnife.findById(conetent_layout, R.id.id_tv);
            id_tv.setText("测试" + i);
            underlineLayoutH.addView(conetent_layout);
            // underlineLayout.removeViews(underlineLayout.getChildCount() - 1, 1);
            underlineLayoutH.setLineGravity(UnderLineLinearLayout.GRAVITY_BOTTOM);
            // underlineLayout.setIcon(R.mipmap.ic_launcher);

        }
    }

    @OnClick(R.id.id_btn_1_2)
    public void onClick() {
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
}
