package com.happyfarmer.myresume;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;

import static android.R.attr.min;

/**
 * Created by 10309022 on 2017/8/29.
 */

public class BackgroundView extends View {
    private Paint paint = new Paint();
    private int width, height;
    private Path path;
    public BackgroundView(Context context) {
        super(context);
    }

    public BackgroundView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BackgroundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        width = getWidth();
        height = getHeight();
        paint.setColor(Color.GRAY);
        paint.setAlpha(0x33);
        paint.setStrokeWidth(10);

        path = new Path();
        path.moveTo((int)(width*0.75), 0);
        path.lineTo(0, height);
        path.lineTo(width, height);
        path.lineTo(width, 0);
        path.close();
        canvas.drawPath(path, paint);

        paint.setColor(Color.BLACK);
        path = new Path();
        path.moveTo(0, 0);
        path.lineTo((int)(width*0.75), 0);
        path.lineTo((int)(width*0.63), (int)(height*0.16));
        path.lineTo(0, (int)(height*0.25));
        path.close();
        canvas.drawPath(path, paint);

        path = new Path();
        path.moveTo(0, height);
        path.lineTo((int)(width*0.1), (int)(height*0.95));
        path.lineTo((int)(width*0.95), height);
        path.close();
        canvas.drawPath(path, paint);

        int radius = 150;
        paint.setColor(Color.BLUE);
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.me);
        Bitmap bmp_resize = Bitmap.createScaledBitmap(bmp, radius*2, radius*2, false);
        path = new Path();
        path.addCircle((int)(width*0.66), (int)(height*0.12), radius, Path.Direction.CW);
        canvas.clipPath(path);
        canvas.drawBitmap(bmp_resize, (int)(width*0.66)-radius, (int)(height*0.12)-radius, paint);
    }
}
