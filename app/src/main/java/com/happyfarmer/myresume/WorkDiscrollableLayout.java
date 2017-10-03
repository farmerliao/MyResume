package com.happyfarmer.myresume;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.flavienlaurent.discrollview.lib.Discrollvable;

/**
 * Created by 10309022 on 2017/9/14.
 */

public class WorkDiscrollableLayout extends RelativeLayout implements Discrollvable {


    private View viewItem1;
    private View viewItem2;
    private View viewItem3;
    private View viewItem4;
    private View viewLine;

    public WorkDiscrollableLayout(Context context) {
        super(context);
    }

    public WorkDiscrollableLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WorkDiscrollableLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        viewItem1 = findViewById(R.id.view_ex_item1);
        viewItem2 = findViewById(R.id.view_ex_item2);
        viewItem3 = findViewById(R.id.view_ex_item3);
        viewItem4 = findViewById(R.id.view_ex_item4);
        viewLine = findViewById(R.id.view_line);
        viewItem1.setPivotX(0f);
        viewItem1.setPivotY(0f);
        viewItem2.setPivotX(0f);
        viewItem2.setPivotY(0f);
        viewItem3.setPivotX(0f);
        viewItem3.setPivotY(0f);
        viewItem4.setPivotX(0f);
        viewItem4.setPivotY(0f);
        viewLine.setPivotX(0.5f);
        viewLine.setPivotY(0f);
    }

    @Override
    public void onDiscrollve(float ratio) {
        switch ((int)(ratio/0.25)){
            case 0:
                viewItem1.setScaleX(ratio * 4);
                viewItem1.setScaleY(ratio * 4);
                break;
            case 1:
                viewItem2.setScaleX((ratio-0.25f) * 4);
                viewItem2.setScaleY((ratio-0.25f) * 4);
                break;
            case 2:
                viewItem3.setScaleX((ratio-0.25f*2) * 4);
                viewItem3.setScaleY((ratio-0.25f*2) * 4);
                break;
            case 3:
                viewItem4.setScaleX((ratio-0.25f*3) * 4);
                viewItem4.setScaleY((ratio-0.25f*3) * 4);
                break;
        }

        viewLine.setScaleY(ratio*ratio);
    }

    @Override
    public void onResetDiscrollve() {

    }
}
