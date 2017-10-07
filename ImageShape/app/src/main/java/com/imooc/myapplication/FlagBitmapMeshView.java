package com.imooc.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class FlagBitmapMeshView extends View {

    private final int WIDTH = 200;  //横向分割线的根数
    private final int HEIGHT = 200; //纵向分割线的根数
    private int COUNT = (WIDTH + 1) * (HEIGHT + 1); //一共能分的格数
    private float[] verts = new float[COUNT * 2];   //数组每两位用来保存一个交织点（x,y）
    private float[] orig = new float[COUNT * 2];
    private Bitmap bitmap;
    private float A;
    private float k = 1;
    private float aFloat;

    public FlagBitmapMeshView(Context context) {
        super(context);
        initView(context);
    }

    public FlagBitmapMeshView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public FlagBitmapMeshView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        setFocusable(true);
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.test);
        float bitmapWidth = bitmap.getWidth();
        float bitmapHeight = bitmap.getHeight();
        int index = 0;
        // 通过循环遍历所有交叉线获取交叉点坐标
        for (int y = 0; y <= HEIGHT; y++) {
            float fy = bitmapHeight * y / HEIGHT;
            for (int x = 0; x <= WIDTH; x++) {
                float fx = bitmapWidth * x / WIDTH;
                orig[index * 2 + 0] = verts[index * 2 + 0] = fx;
                // 加100是为了让图像下移，避免屏幕遮挡
                orig[index * 2 + 1] = verts[index * 2 + 1] = fy + 100;
                index += 1;
            }
        }
        A = 50;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        flagWave();
        k += 0.2F;  //改变速度？
        /**
         * 通过修改每一个图像块修改整个图像
         * 参数：
         * bitmap：要扭曲的图像、
         * WIDTH，HEIGHT：横，纵向网格的数目
         * verts:网格交叉点坐标数组
         * 0:数组中开始跳过的坐标对的数目
         */
        canvas.drawBitmapMesh(bitmap, WIDTH, HEIGHT, verts, 0, null, 0, null);
        invalidate();
    }

    private void flagWave() {
        for (int j = 0; j <= HEIGHT; j++) {
            for (int i = 0; i <= WIDTH; i++) {
                aFloat = verts[(j * (WIDTH + 1) + i) * 2 + 0] += 0;
                // 获取坐标偏移量，给函数增加一个周期
                float offsetY = (float) Math.sin((float) i / WIDTH*2*Math.PI + Math.PI*k);
                verts[(j * (WIDTH + 1) + i) * 2 + 1] = orig[(j*WIDTH+i)*2+1]+offsetY*A;
            }
        }
    }
}