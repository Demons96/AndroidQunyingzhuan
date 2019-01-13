package com.imooc.vectortest;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends Activity implements View.OnClickListener {

    ImageView imageView0;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.image0).setOnClickListener(this);
        findViewById(R.id.image1).setOnClickListener(this);
        findViewById(R.id.image2).setOnClickListener(this);
        findViewById(R.id.image3).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.image0:
                animate(imageView0);
                break;
            case R.id.image1:
                animate(imageView1);
                break;
            case R.id.image2:
                animate(imageView2);
                break;
            case R.id.image3:
                animate(imageView3);
                break;
        }
    }

    private void animate(ImageView imageView) {
        ((Animatable)imageView.getDrawable()).start();
//        Drawable drawable = imageView.getDrawable();
//        if (drawable instanceof Animatable) {
//            ((Animatable) drawable).start();
//        }
    }
}
