package com.checkerbot.checkerbot;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Square {

    private int x=0;
    private int y=0;
    private int piece=0;
    private int color=0;
    private int state=0;

    public Square(){
    }

    public void draw(Canvas canvas,int width) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(this.color);
        Rect r = new Rect(x*width,y*width,width+x*width,width+y*width);
        canvas.drawRect(r,paint);
        switch(piece){
            case 0:
                break;
            case 1:
                paint.setColor(Color.WHITE);
                if ((x + y) % 2 != 0) {
                    canvas.drawCircle(r.centerX(), r.centerY(), width / 3, paint);
                }
                break;
            case 2:
                paint.setColor(Color.BLACK);
                if ((x + y) % 2 != 0) {
                    canvas.drawCircle(r.centerX(), r.centerY(), width / 3, paint);
                }
                break;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String toString(){
        return "X: "+x+" Y: "+y;
    }

    public boolean isKing(){
        if(state==3){
            return true;
        }
        return false;
    }
}

