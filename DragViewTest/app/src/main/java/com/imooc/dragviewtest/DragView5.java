package com.imooc.dragviewtest;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

/**
 * Scroller
 * 实现平滑移动
 */
public class DragView5 extends View {

    private int lastX;
    private int lastY;
    private Scroller mScroller;

    public DragView5(Context context) {
        super(context);
        ininView(context);
    }

    public DragView5(Context context, AttributeSet attrs) {
        super(context, attrs);
        ininView(context);
    }

    public DragView5(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ininView(context);
    }

    private void ininView(Context context) {
        setBackgroundColor(Color.BLUE);

        // 1初始化Scroller
        mScroller = new Scroller(context);
    }

    /**
     * 2实现模拟滑动
     * 此方法是Scroller的核心
     */
    @Override
    public void computeScroll() {
        super.computeScroll();
        // 判断Scroller是否执行完毕
        if (mScroller.computeScrollOffset()) {
            //getCurrXY获得当前的滑动坐标
            ((View) getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());

            // 通过重绘来不断调用computeScroll（invalidate()->draw()->computeScroll()）
            invalidate();
        }
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
                ((View) getParent()).scrollBy(-offsetX, -offsetY);
                break;
            case MotionEvent.ACTION_UP:
                // 手指离开时，执行滑动过程
                View viewGroup = ((View) getParent());
                // 开启模拟滑动过程
                mScroller.startScroll(
                        viewGroup.getScrollX(),     //起始坐标
                        viewGroup.getScrollY(),
                        -viewGroup.getScrollX(),    //偏移量
                        -viewGroup.getScrollY(),
                        6666);                      //动画时长，此参数可有可无
                invalidate();
                break;
        }
        return true;
    }
}
