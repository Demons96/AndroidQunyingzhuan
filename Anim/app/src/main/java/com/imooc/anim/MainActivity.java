package com.imooc.anim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 灵动菜单
    public void btnProperty(View view) {
        startActivity(new Intent(this, PropertyTest.class));
    }

    // 轻点计时
    public void btnTimer(View view) {
        startActivity(new Intent(this, TimerTest.class));
    }

    // 下拉展开动画
    public void btnDrop(View view) {
        startActivity(new Intent(this, DropTest.class));
    }
}
