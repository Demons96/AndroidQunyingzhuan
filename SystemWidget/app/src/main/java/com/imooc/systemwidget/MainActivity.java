package com.imooc.systemwidget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //选择启动的活动的类
        mIntent = new Intent(this, MyViewTest.class);
    }

    //34View的测量，正方形
    public void btnTeaching(View view) {
        mIntent.putExtra("flag", 0);
        startActivity(mIntent);
    }

    //39自定义TextView
    public void btnMyTextView(View view) {
        mIntent.putExtra("flag", 1);
        startActivity(mIntent);
    }

    //42闪烁渐变的TextView
    public void btnShineTextView(View view) {
        mIntent.putExtra("flag", 2);
        startActivity(mIntent);
    }

    //自定义标题
    public void btnTopBar(View view) {
        startActivity(new Intent(this, TopBarTest.class));
    }

    //圆柱比例图
    public void btnCircleProgress(View view) {
        mIntent.putExtra("flag", 3);
        startActivity(mIntent);
    }

    //音频
    public void btnVolumeView(View view) {
        mIntent.putExtra("flag", 4);
        startActivity(mIntent);
    }

    //自定义ViewGroup
    public void btnMyScrollView(View view) {
        mIntent.putExtra("flag", 5);
        startActivity(mIntent);
    }

}
