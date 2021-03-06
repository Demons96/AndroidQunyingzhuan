package com.imooc.dragviewtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * 传说实现视图滑动有七种方法
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnView(View view) {
        startActivity(new Intent(this, DragViewTest.class));
    }

    public void btnViewGroup(View view) {
        startActivity(new Intent(this, DragViewGroupTest.class));
    }
}
