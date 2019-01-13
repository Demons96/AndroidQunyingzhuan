package com.imooc.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ListView;

// 扩展原生的ListView使其具有弹性效果
public class FlexibleListView extends ListView {

    private static int mMaxOverDistance = 50;   // 设置弹性值
    private Context mContext;

    public FlexibleListView(Context context, AttributeSet attrs,
                            int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    public FlexibleListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initView();
    }

    public FlexibleListView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    /**
     * 通过屏幕的density来计算具体的数值
     * 以此来保证不同的分辨率效果一致
     */
    private void initView() {
        DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
        float density = metrics.density;    // density：密度
        mMaxOverDistance = (int) (density * mMaxOverDistance);
    }

    /**
     * 控制滑动到处理边缘的方法
     */
    @Override
    protected boolean overScrollBy(int deltaX, int deltaY,
                                   int scrollX, int scrollY,
                                   int scrollRangeX, int scrollRangeY,
                                   int maxOverScrollX, int maxOverScrollY,
                                   boolean isTouchEvent) {

        return super.overScrollBy(deltaX, deltaY,
                scrollX, scrollY,
                scrollRangeX, scrollRangeY,
                maxOverScrollX, mMaxOverDistance,
                isTouchEvent);
    }
}
