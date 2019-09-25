package com.example.mypaint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton image1, image2, image3, image4, curImage;
    MyPaint myPaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myPaint = findViewById(R.id.myPaint);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        curImage = image1;

        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);
        image4.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        // 페인트 색 바꾸기
        if (view != curImage) {
            String color = view.getTag().toString();
            myPaint.setColor(color);
            curImage = (ImageButton) view;
        }
    }
}
