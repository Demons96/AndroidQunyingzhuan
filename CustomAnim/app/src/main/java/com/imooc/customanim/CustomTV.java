package com.imooc.customanim;

import android.graphics.Matrix;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.Transformation;

// 模拟电视关闭的效果
public class CustomTV extends Animation {

    private int mCenterWidth;
    private int mCenterHeight;

    @Override
    public void initialize(int width,
                           int height,
                           int parentWidth,
                           int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);

        setDuration(1000);    // 设置默认时长

        setFillAfter(true);    // 动画结束后保留状态

//        setInterpolator(new AccelerateInterpolator());    // 设置默认插值器
        setInterpolator(new BounceInterpolator());    // 设置默认插值器

        mCenterWidth = width / 2;
        mCenterHeight = height / 2;
    }

    /**
     * @param interpolatedTime：差值器的事件因子
     * @param t：矩阵的分装类
     */
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        final Matrix matrix = t.getMatrix();
        matrix.preScale(1, 1 - interpolatedTime, mCenterWidth, mCenterHeight);
    }
}
