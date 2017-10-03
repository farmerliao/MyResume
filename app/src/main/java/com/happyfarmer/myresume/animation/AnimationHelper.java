package com.happyfarmer.myresume.animation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.happyfarmer.myresume.R;



/**
 * Created by 10309022 on 2017/9/30.
 */

public class AnimationHelper {


    public static void slideViews(View... views) {
        int minMillisec = 500;
        int addition = 200;
        Animation animation;
        for (int i=0;i<views.length;i++) {
            animation = AnimationUtils.loadAnimation(views[i].getContext(), R.anim.animation_scale1);
            animation.setDuration(minMillisec + addition*i);
            views[i].startAnimation(animation);
        }
    }
}
