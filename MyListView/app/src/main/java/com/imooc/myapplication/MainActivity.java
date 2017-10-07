package com.imooc.myapplication;

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

    //视图缓存
    public void btnViewHolder(View view) {
        startActivity(new Intent(this, NotifyTest.class));
    }

    //滑动到头和尾有弹性
    public void btnFlexible(View view) {
        startActivity(new Intent(this, FlexibleListViewTest.class));
    }

    //自动显示隐藏布局
    public void btnScrollHideListView(View view) {
        startActivity(new Intent(this, ScrollHideListView.class));
    }

    //聊天
    public void btnChatItem(View view) {
        startActivity(new Intent(this, ChatItemListViewTest.class));
    }

    //动态改变ListView布局
    public void btnFocus(View view) {
        startActivity(new Intent(this, FocusListViewTest.class));
    }
}
