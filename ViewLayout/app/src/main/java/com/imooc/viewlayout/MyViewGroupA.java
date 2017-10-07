package com.imooc.viewlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class MyViewGroupA extends LinearLayout {

    public MyViewGroupA(Context context) {
        super(context);
    }

    public MyViewGroupA(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroupA(Context context, AttributeSet attrs,
                        int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 事件分发
     * 一般请境况下不会重写这个
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("xys", "1ViewGroupA dispatchTouchEvent" + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 事件拦截
     * @param ev
     * @return true拦截、false不拦截，默认false
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("xys", "2ViewGroupA onInterceptTouchEvent" + ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }

    /**
     * 事件处理
     * @param event
     * @return true处理、false留给上级,默认false
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("xys", "8ViewGroupA onTouchEvent" + event.getAction());
        return super.onTouchEvent(event);
    }
}
