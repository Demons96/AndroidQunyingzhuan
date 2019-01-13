package com.imooc.dragviewtest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * scrollTo:移动到一个具体的坐标点
 * scrollBy:自动的增量
 * 这两个方法移动的是View的content,即View的内容
 * 在ViewGroup种使用的话就是移动所有的子View
 */
@SuppressLint("AppCompatCustomView")
public class DragView4 extends TextView {

    private int lastX;
    private int lastY;

    public DragView4(Context context) {
        super(context);
        initView();
    }

    public DragView4(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public DragView4(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        setText("啦啦啦");
        setBackgroundColor(Color.BLUE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = (int) event.getX();
                lastY = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;

                /**
                 * 用正数的话会乱动
                 * 因为移动的是可视区域，就是底层画布不动，动的是屏幕的盖板
                 */
//                scrollBy(-offsetX, -offsetY); // 移动内容
                ((View) getParent()).scrollBy(-offsetX, -offsetY);  // 移动view
//                lastX = x;
//                lastY = y;
                break;
        }
        return true;
    }
}
