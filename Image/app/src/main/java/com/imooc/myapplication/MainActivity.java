package com.imooc.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 色光属性
    public void btnPrimaryColor(View view) {
        startActivity(new Intent(this, PrimaryColor.class));
    }

    // 颜色矩阵
    public void btnColorMatrix(View view) {
        startActivity(new Intent(this, ColorMatrix.class));
    }

    // 像素点分析以及处理效果
    public void btnPixelsEffect(View view) {
        startActivity(new Intent(this, PixelsEffect.class));
    }
}
