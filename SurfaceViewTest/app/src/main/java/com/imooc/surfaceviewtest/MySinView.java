package com.imooc.surfaceviewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.SurfaceHolder;

/**
 * 使用模板实现的正弦函数
 */
public class MySinView extends SurfaceViewTemplate {
    private int x = 0;
    private int y = 0;
    private Path mPath;
    private Paint mPaint;

    public MySinView(Context context) {
        super(context);
    }

    public MySinView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void initSurfaceView() {
        mPath = new Path();

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mPath.moveTo(0, 400);
        super.surfaceCreated(holder);
    }

    @Override
    public void SurfaceDraw(Canvas canvas) {
        x += 1;
        y = (int) (100 * Math.sin(x * 2 * Math.PI / 180) + 400);
        mPath.lineTo(x, y);
        canvas.drawColor(Color.WHITE);
        canvas.drawPath(mPath, mPaint);
    }
}
