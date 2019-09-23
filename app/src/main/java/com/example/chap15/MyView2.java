package com.example.chap15;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView2 extends View {
    Paint paint;
    public MyView2(Context context) {
        super(context);
        init();
    }
    public MyView2(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        init();
    }
    private void init(){
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(15, 15, 160, 160, paint);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(30);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(15, 200, 350, 200, paint);
    }
}
