package com.imooc.myapplication;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ScrollHideListView extends Activity {

    private Toolbar mToolbar;
    private ListView mListView;
    private String[] mStr = new String[20];
    private int mTouchSlop;     //最低滑动距离，用来判断是否滑动
    private float mFirstY;
    private float mCurrentY;
    private int direction;
    private ObjectAnimator mAnimator;
    private boolean mShow = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_hide);

        //获取系统认为最低的滑动距离
        mTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mListView = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < mStr.length; i++) {
            mStr[i] = "Item " + i;
        }

        /**
         * 功能：避免第一个Item被Toolbar遮挡
         * 添加一个HeaderView
         * 通过abd_action_bar...获取系统Actionbar的高度
         */
        View header = new View(this);
        header.setLayoutParams(new AbsListView.LayoutParams(
                AbsListView.LayoutParams.MATCH_PARENT,
                (int) getResources().getDimension(
                        R.dimen.abc_action_bar_default_height_material)));

        mListView.addHeaderView(header);
        mListView.setAdapter(new ArrayAdapter<String>(
                ScrollHideListView.this,
                android.R.layout.simple_expandable_list_item_1,
                mStr));
//        mListView.setOnTouchListener(myTouchListener);

        /**
         * 通过滑动点的坐标改变大小，判断方向，执行不同的动画效果
         */
        mListView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mFirstY = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        mCurrentY = event.getY();
                        if (mCurrentY - mFirstY > mTouchSlop) {
                            direction = 0;// down
                        } else if (mFirstY - mCurrentY > mTouchSlop) {
                            direction = 1;// up
                        }
                        if (direction == 1) {
                            if (mShow) {
                                toolbarAnim(1);//hide
                                mShow = !mShow;
                            }
                        } else if (direction == 0) {
                            if (!mShow) {
                                toolbarAnim(0);//show
                                mShow = !mShow;
                            }
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return false;
            }
        });
    }

    //控制布局隐藏的动画
    private void toolbarAnim(int flag) {
        if (mAnimator != null && mAnimator.isRunning()) {
            mAnimator.cancel();
        }
        if (flag == 0) {
            mAnimator = ObjectAnimator.ofFloat(mToolbar,
                    "translationY", mToolbar.getTranslationY(), 0);
        } else {
            mAnimator = ObjectAnimator.ofFloat(mToolbar,
                    "translationY", mToolbar.getTranslationY(),
                    -mToolbar.getHeight());
        }
        mAnimator.start();
    }

//    View.OnTouchListener myTouchListener = new View.OnTouchListener() {
//        @Override
//        public boolean onTouch(View v, MotionEvent event) {
//            switch (event.getAction()) {
//                case MotionEvent.ACTION_DOWN:
//                    mFirstY = event.getY();
//                    break;
//                case MotionEvent.ACTION_MOVE:
//                    mCurrentY = event.getY();
//                    if (mCurrentY - mFirstY > mTouchSlop) {
//                        direction = 0;// down
//                    } else if (mFirstY - mCurrentY > mTouchSlop) {
//                        direction = 1;// up
//                    }
//                    if (direction == 1) {
//                        if (mShow) {
//                            toolbarAnim(1);//hide
//                            mShow = !mShow;
//                        }
//                    } else if (direction == 0) {
//                        if (!mShow) {
//                            toolbarAnim(0);//show
//                            mShow = !mShow;
//                        }
//                    }
//                    break;
//                case MotionEvent.ACTION_UP:
//                    break;
//            }
//            return false;
//        }
//    };
}
