package com.imooc.systemwidget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * 音频
 */
public class VolumeView extends View {

    private int mWidth;

    private int mRectWidth;     // 矩形的宽
    private int mRectHeight;    // 矩形的高

    private Paint mPaint;
    private int mRectCount;     // 矩形的个数
    private int offset = 5;     // 偏移量
    private double mRandom;     // 随机数
    private double inWidth = 0.8;     // 整个音频占屏幕宽度的百分比
    private LinearGradient mLinearGradient;

    public VolumeView(Context context) {
        super(context);
        initView();
    }

    public VolumeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public VolumeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mRectCount = 36;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = getWidth();
        mRectHeight = getHeight();
        mRectWidth = (int) (mWidth * inWidth / mRectCount);

        //渐变效果
        mLinearGradient = new LinearGradient(
                0,
                0,
                mRectWidth,
                mRectHeight,
                Color.YELLOW,
                Color.BLUE,
                Shader.TileMode.CLAMP);
        mPaint.setShader(mLinearGradient);
    }

    /**
     * @param canvas 可调用invalidate进行重绘
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < mRectCount; i++) {
            mRandom = Math.random();    //0~1的小数，就当View高的百分比了
            float currentHeight = (float) (mRectHeight * mRandom);  //每个小矩形的高

            canvas.drawRect(
                    (float) (mWidth * (1 - inWidth) / 2 + mRectWidth * i + offset),
                    currentHeight,
                    (float) (mWidth * (1 - inWidth) / 2 + mRectWidth * (i + 1)),
                    mRectHeight,
                    mPaint);
        }
        postInvalidateDelayed(160); //进行View的延迟绘制
    }
}
