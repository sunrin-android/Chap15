package com.example.chap15;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
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

        // 사각형
        paint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawRect(15, 15, 160, 160, paint);

        // 선
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(30);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(15, 200, 350, 200, paint);

        // 원
        paint.setColor(Color.YELLOW);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(150,350,100, paint);

        // 호
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        RectF rectF = new RectF(400, 50, 800, 450);
        canvas.drawArc(rectF, -90,180,false, paint);

        // 텍스트
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(50);
        canvas.drawText("텍스트도 그릴 수 있습니다.", 15,550, paint);
    }
}
