package com.imooc.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    // 图像变换矩阵
    public void btnImageMatrix(View view) {
        startActivity(new Intent(this, ImageMatrixTest.class));
    }

    // 像素快扭曲效果
    public void btnFlag(View view) {
        startActivity(new Intent(this, FlagBitmapMeshTest.class));
    }

    // 刮刮乐效果
    public void btnPorterDuffXfermode(View view) {
        startActivity(new Intent(this, XfermodeViewTest.class));
    }

    // 将一个矩形的图片变成一个圆形的图片
    public void btnRoundRect(View view) {
        startActivity(new Intent(this, RoundRectTest.class));
    }

    // 一个有倒影的图
    public void btnReflect(View view) {
        startActivity(new Intent(this, ReflectViewTest.class));
    }
}
