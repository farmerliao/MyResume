package com.happyfarmer.myresume;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.flavienlaurent.discrollview.lib.Discrollvable;

/**
 * Created by 10309022 on 2017/9/7.
 */

public class SkillDiscrollableLayout extends RelativeLayout implements Discrollvable {

    private ProgressBar viewItem1;
    private ProgressBar viewItem2;
    private ProgressBar viewItem3;
    private ProgressBar viewItem4;
    private ProgressBar viewItem5;
    private View viewNext;

    public SkillDiscrollableLayout(Context context) {
        super(context);
    }

    public SkillDiscrollableLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SkillDiscrollableLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        viewItem1 = findViewById(R.id.progressBar_java);
        viewItem2 = findViewById(R.id.progressBar_mfc);
        viewItem3 = findViewById(R.id.progressBar_cplus);
        viewItem4 = findViewById(R.id.progressBar_csharp);
        viewItem5 = findViewById(R.id.progressBar_python);
        viewNext = findViewById(R.id.iv_next);
    }

    @Override
    public void onDiscrollve(float ratio) {
        viewItem1.setProgress((int)(90*ratio));
        viewItem2.setProgress((int)(80*ratio));
        viewItem3.setProgress((int)(80*ratio));
        viewItem4.setProgress((int)(70*ratio));
        viewItem5.setProgress((int)(60*ratio));
        if(ratio >= 0.8f){
            viewNext.setScaleX(1.0f * (ratio-0.8f) * 5);
            viewNext.setScaleY(1.0f * (ratio-0.8f) * 5);
            viewNext.setAlpha(1.0f * (ratio-0.8f) * 5);
        }
    }

    @Override
    public void onResetDiscrollve() {

    }
}
