package com.imooc.dragviewtest;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * scrollTo:移动到一个具体的坐标点
 * scrollBy:自动的增量
 * 这两个方法移动的是View的content,即View的内容
 * 在ViewGroup种使用的话就是移动所有的子View
 */
public class DragView4 extends View {

    private int lastX;
    private int lastY;

    public DragView4(Context context) {
        super(context);
        ininView();
    }

    public DragView4(Context context, AttributeSet attrs) {
        super(context, attrs);
        ininView();
    }

    public DragView4(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ininView();
    }

    private void ininView() {
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
                ((View) getParent()).scrollBy(-offsetX, -offsetY);
                break;
        }
        return true;
    }
}
