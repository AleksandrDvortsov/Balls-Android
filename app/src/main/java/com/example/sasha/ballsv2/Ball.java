package com.example.sasha.ballsv2;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Ball
{
    float x;
    float y;
    int radius;
    int color;
    Paint paint = new Paint();
    int dx = 5;
    int dy = 5;

    public Ball(float x, float y, int radius, int color)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        paint.setStrokeWidth(5);
    }

    public int getColor()
    {
        return color;
    }

    public void draw(Canvas canvas)
    {
        paint.setColor(color);
        canvas.drawCircle(x, y, radius, paint);
    }

    public void move()
    {
        if((x - radius) <= 0 || (x + radius) >= 768)
            dx *= -1;
        if((y - radius) <= 0 || (y + radius) >= 1030)
            dy *= -1;
        if((x-radius) <= 0)
            dx = Math.abs(dx);
        if((y-radius) <= 0)
            dy = Math.abs(dy);
        x = x + dx;
        y = y + dy;
    }
}

