package com.helloabhi.abhishek.myfirstgame;

import java.util.Random;

/**
 * Created by abhishek on 12/17/2016.
 */
public class Star {

    private int x ,y , speed;
    private int maxX,minX;
    private int maxY,minY;
    public Star(int screenX,int screenY){
        maxX = screenX;
        maxY = screenY;
        minX = 0;
        minY = 0;
        Random generator = new Random();
        speed = generator.nextInt(10);

    }
    public void update(int playerSpeed){
        x-=playerSpeed;
        x-=speed;
        if(x<0){
            x=maxX;
            Random generator = new Random();
            y = generator.nextInt(maxY);
            speed = generator.nextInt(15);

        }
    }
    public float getStarWidth(){
        float minX = 1.0f;
        float maxX = 4.0f;
        Random rand = new Random();
        float finalX = rand.nextFloat()*(maxX-minX) + minX;
        return finalX;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
