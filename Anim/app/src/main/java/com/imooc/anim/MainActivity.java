package com.imooc.anim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 灵动菜单
    public void btnProperty(View view) {
        startActivity(new Intent(this, PropertyTest.class));
    }

    // 轻点计时
    public void btnTimer(View view) {
        startActivity(new Intent(this, TimerTest.class));
    }

    // 下拉展开动画
    public void btnDrop(View view) {
        startActivity(new Intent(this, DropTest.class));
    }

    // 测试平移
    public void btnText(View view) {
//        TranslateAnimation ta = new TranslateAnimation(0, 200, 0, 0);
//        ta.setDuration(1000);
//        view.startAnimation(ta);
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                view,
                "translationX",
                300
        );
        animator.setDuration(300);
        animator.start();
    }

    // 测试旋转
    public void btnText1(View view) {
        PropertyValuesHolder pvh1 = PropertyValuesHolder.ofFloat("translationX", 1f, 200f);
        PropertyValuesHolder pvh2 = PropertyValuesHolder.ofFloat("scaleX", 1f, 0, 1f);
        PropertyValuesHolder pvh3 = PropertyValuesHolder.ofFloat("scaleY", 1f, 0, 1f);
        ObjectAnimator.ofPropertyValuesHolder(view, pvh1, pvh2, pvh3).setDuration(3000).start();
//        ObjectAnimator animator = ObjectAnimator.ofFloat(
//                view,
//                "scaleX",
//                1f,
//                0,
//                1f
//        );
//        animator.setDuration(300);
//        animator.start();
    }

    // 测试缩放
    public void btnText2(View view) {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "translationX", 300);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0, 1f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(view, "scaleY", 1f, 0, 1f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(1000);
        set.playTogether(animator1, animator2, animator3);
        set.start();

        Toast.makeText(this, "Build.FINGERPRINT;" + Build.FINGERPRINT, Toast.LENGTH_SHORT).show();
    }
}
