package com.imooc.systemwidget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 自定义的一个正方形
 */
public class TeachingView extends View {

    public TeachingView(Context context) {
        super(context);
    }

    public TeachingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TeachingView(Context context, AttributeSet attrs,
                        int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param widthMeasureSpec：宽
     * @param heightMeasureSpec：高 定义画多大的View
     */
    @Override
    protected void onMeasure(int widthMeasureSpec,
                             int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(
                measureWidth(widthMeasureSpec),
                measureHeight(heightMeasureSpec));
    }

    /**
     * @param measureSpec
     * @return 返回对应模式下的大小
     * MeasureSpec是一个32位的int值，高2位为测量模式，底30位为测量的大小。
     * EXACTLY:精确模式，指定数值或者为match_parent
     * AT_MOST:最大值模式，wrap_content 想使用需重写
     * UNSPECIFIED:绘制自定义View时用
     */
    private int measureWidth(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);    //从MeasureSpec中取出测量模式
        int specSize = MeasureSpec.getSize(measureSpec);    //从MeasureSpec中取出测量的大小

        // exactly:精确模式，参数为具体的值dp或者wrap_content
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = 200;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    private int measureHeight(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = 200;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    /**
     * @param canvas 重写onDraw方法进行绘图
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //在canvas对象上绘制需要的图形
        canvas.drawColor(Color.GRAY);
        int width = getWidth();
        int height = getHeight();
        Log.d("xys", "width : " + width + " height : " + height);
    }
}
