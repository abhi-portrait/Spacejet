package com.helloabhi.abhishek.myfirstgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

/**
 * Created by abhishek on 12/17/2016.
 */
public class Player {

    private Bitmap bitmap;
    private int x,y;
    private int speed = 0 ;
    private boolean boosting;

    private final int GRAVTY = -10;

    private int minY;
    private int maxY;
    private Rect detectCollision;

    private final int MIN_SPEED = 1;
    private final int MAX_SPEED = 20;
    public Player(Context context,int screenX , int screenY){
        x=75;
        y=50;
        speed=1;

        bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.player);
        minY = 0;
        maxY = screenY - bitmap.getHeight();
        boosting = false;
        detectCollision = new Rect(x,y,bitmap.getWidth(),bitmap.getHeight());
    }
    public void setBoosting(){
        boosting = true;
    }
    public void stopBoosting(){
        boosting = false;
    }



    public void update(){
        if(boosting){
            speed += 2;
        }
        else{
            speed -= 5;
        }
        if(speed > MAX_SPEED)
            speed = MAX_SPEED;
        if(speed < MIN_SPEED)
            speed = MIN_SPEED;

        y-=speed + GRAVTY;
        if(y>maxY)
            y = maxY;
        if(y<minY)
            y = minY;
        detectCollision.left = x;
        detectCollision.top = y;
        detectCollision.right = x + bitmap.getWidth();
        detectCollision.bottom = y + bitmap.getHeight();
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public Rect getDetectCollision() {
        return detectCollision;
    }
}
