package com.happyfarmer.myresume;

import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.happyfarmer.myresume.animation.AnimationHelper;
import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;

public class MainActivity extends AppCompatActivity {
    public ResideMenu resideMenu;
    private ResideMenuItem itemApps;
    private ResideMenuItem itemProducts;
    private ResideMenuItem itemAutomated;
    private ResideMenuItem itemAI;
    private View view1;
    private View view2;
    private View view3;
    private View view4;
    private FloatingActionButton mainFAB;
    private ImageView ivNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FAB setting
        mainFAB = (FloatingActionButton) findViewById(R.id.fab);
        mainFAB.setOnClickListener(fabListener);

        // attach to current activity;
        resideMenu = new ResideMenu(this);
        resideMenu.setUse3D(true);
        resideMenu.setBackground(R.drawable.background);
        resideMenu.attachToActivity(this);
        //resideMenu.setMenuListener(menuListener);
        //valid scale factor is between 0.0f and 1.0f. leftmenu'width is 150dip.
        resideMenu.setScaleValue(0.9f);

        // create menu items;
        itemApps     = new ResideMenuItem(this, R.drawable.apps,     "Apps");
        itemProducts  = new ResideMenuItem(this, R.drawable.products,  "Products");
        itemAutomated = new ResideMenuItem(this, R.drawable.automated, "Automatics");
        itemAI = new ResideMenuItem(this, R.drawable.ai, "Intelligence");
        itemApps.setOnClickListener(sideItemListener);
        itemProducts.setOnClickListener(sideItemListener);
        itemAutomated.setOnClickListener(sideItemListener);
        itemAI.setOnClickListener(sideItemListener);

        //Add to right menu
        resideMenu.addMenuItem(itemApps, ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemProducts, ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemAutomated, ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemAI, ResideMenu.DIRECTION_RIGHT);

        view1 = findViewById(R.id.view_info_item1);
        view2 = findViewById(R.id.view_info_item2);
        view3 = findViewById(R.id.view_info_item3);
        view4 = findViewById(R.id.view_info_item4);

        AnimationHelper.slideViews(view1, view2, view3, view4);


        ivNext = (ImageView) findViewById(R.id.iv_next);
        ivNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(1);
            }
        });
    }

    private View.OnClickListener fabListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AnimationHelper.slideViews(view1, view2, view3, view4);
        }
    };

    private View.OnClickListener sideItemListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == itemApps) {

            }else if (view == itemProducts) {

            }else if (view == itemAutomated) {

            }else if (view == itemAI) {

            }
        }
    };

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }

}
