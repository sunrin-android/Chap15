package com.example.mypaint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class MyPaint extends View {
    Paint paint;
    Path path;
    Bitmap bitmap;
    Canvas mCanvas; // 메모리상 Canvas

    public MyPaint(Context context) {
        super(context);
        init();
    }

    public MyPaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        path = new Path();
        paint.setColor(0xFF0000);
        paint.setStrokeWidth(40);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
    }

    // onDraw() 보다 먼저 호출
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bitmap = bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(bitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawPath(path, paint);
        canvas.drawBitmap(bitmap, 0, 0, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 터치 좌표
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // path 시작
                path.moveTo(x, y);
                mCanvas.drawPath(path, paint);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                mCanvas.drawPath(path, paint);
                break;
            case MotionEvent.ACTION_UP:
                mCanvas.drawPath(path, paint);
                path.reset();
                break;
        }
        invalidate(); // 다시 그리기
        return true;
    }

    public void setColor(String color) {
        paint.setColor(Color.parseColor(color));
    }
}
