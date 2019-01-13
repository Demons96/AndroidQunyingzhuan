package com.imooc.systemwidget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * 实现TopBar的按键监听事件
 */
public class TopBarTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topbar_test);

        // 获得我们创建的topbar
        TopBar mTopBar = (TopBar) findViewById(R.id.topBar);

        // 为topbar注册监听事件，传入定义的接口
        // 并以匿名类的方式实现接口内的方法
        mTopBar.setOnTopBarClickListener(
                new TopBar.TopBarClickListener() {
                    @Override
                    public void leftClick() {
                        finish();
                        Toast.makeText(TopBarTest.this, "left", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void rightClick() {
                        Toast.makeText(TopBarTest.this, "right", Toast.LENGTH_SHORT).show();
                    }
                });

        // 控制topbar上组件的状态
        mTopBar.setButtonVisible(0, true);
        mTopBar.setButtonVisible(1, true);
    }
}
