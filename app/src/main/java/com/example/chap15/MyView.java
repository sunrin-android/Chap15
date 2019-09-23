package com.example.chap15;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class MyView extends View {
    int color, count;
    OnMyChangeListener listener;

    public MyView(Context context){
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs){
        super(context,  attrs);
        setBackgroundColor(Color.YELLOW);

        if(attrs != null){
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyView);
            color = typedArray.getColor(R.styleable.MyView_customColor, Color.RED);
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = new Rect(15, 15, 160, 160);
        Paint paint = new Paint();
        paint.setColor(color);

        canvas.drawRect(rect, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if(widthMode == MeasureSpec.AT_MOST) {
            widthSize = 600;
        }
        if(heightMode == MeasureSpec.AT_MOST){
            heightSize = 600;
        }
        setMeasuredDimension(widthSize, heightSize);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        color = 0xFFFF0000;
        invalidate();
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            count++;
            listener.onChange(count);
        }
        Toast.makeText(getContext(), "이벤트발생", Toast.LENGTH_SHORT).show();
        return true;
    }

    public void setOnMyChangeListener(OnMyChangeListener listener){
        this.listener = listener;
    }
}
