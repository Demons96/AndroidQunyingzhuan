package com.imooc.dragviewtest;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * layout方法
 * 调用其来设置显示位置
 */
public class DragView1 extends View {
    private static final String TAG = "DragView1";

    private int lastX;
    private int lastY;

    public DragView1(Context context) {
        super(context);
        ininView();
    }

    public DragView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        ininView();
    }

    public DragView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ininView();
    }

    private void ininView() {
        // 给View设置背景颜色，便于观察
        setBackgroundColor(Color.BLUE);
    }

    // 视图坐标方式
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();     // 视图坐标
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
//                Log.e(TAG, "ACTION_DOWN: x" + x + " y" + y);
                // 记录触摸点坐标
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
//                Log.e(TAG, "ACTION_MOVE: x" + x + " y" + y);
                // 计算偏移量
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                // 在当前left、top、right、bottom的基础上加上偏移量
                layout(getLeft() + offsetX,
                        getTop() + offsetY,
                        getRight() + offsetX,
                        getBottom() + offsetY);
//                        offsetLeftAndRight(offsetX);
//                        offsetTopAndBottom(offsetY);
                break;
        }
        return true;
    }
}
