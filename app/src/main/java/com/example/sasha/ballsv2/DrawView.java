package com.example.sasha.ballsv2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class DrawView extends View
{
    ArrayList<Ball> bb = new ArrayList<Ball>();

    public DrawView(Context context)
    {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawColor(Color.WHITE);
        for(Ball b:bb)
        {
            b.draw(canvas);
            b.move();
            invalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if(event.getAction() == MotionEvent.ACTION_UP)
        {
            Ball ball = new Ball(event.getX(),event.getY(),200, rColor());
            bb.add(ball);
            int delay = 200;
            invalidate();
        }
        return true;
    }

    private int rColor()
    {
        int color;
        Random r = new Random();
        int alpha = r.nextInt(255);
        int red = r.nextInt(255);
        int green = r.nextInt(255);
        int blue = r.nextInt(255);
        color = Color.argb(alpha,red,green,blue);
        return color;
    }
}