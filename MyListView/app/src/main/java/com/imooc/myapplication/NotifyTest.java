package com.imooc.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 左边图片，右边文字
 */
public class NotifyTest extends Activity {

    private List<String> mData;
    private ListView mListView;
    private NotifyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notify);

        initData(); // 初始化数据

        mListView = (ListView) findViewById(R.id.listView);
        mAdapter = new NotifyAdapter(this, mData);
        mListView.setAdapter(mAdapter);

        //遍历ListView中所有的Item
        for (int i = 0; i < mListView.getChildCount(); i++) {
            View view = mListView.getChildAt(i);
        }
    }

    public void btnAdd(View view) {
        mData.add("new");
        mAdapter.notifyDataSetChanged();    //通知ListView更改数据源
        mListView.setSelection(mData.size() - 1);
    }

    private void initData() {
        mData = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            mData.add("" + i);
        }
    }
}
