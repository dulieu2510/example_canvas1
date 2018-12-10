package com.codingwithgiap.example_canvas1;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class box {
    private GameSurface gameSurface;
    private int x;
    private int y;
    private int count = 0;
    private Bitmap image;
    private long lastDrawNanoTime =-1;
    public static final float VELOCITY = 0.1f;
    private int movingVectorX = 10;
    private int movingVectorY = 5;
    double movingVectorLength = Math.sqrt(movingVectorX* movingVectorX + movingVectorY*movingVectorY);

    public box(GameSurface gameSurface, Bitmap img, int x, int y) {
        this.gameSurface =gameSurface;
        this.image = img;
        this.x=x;
        this.y=y;
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(image,x, y, null);

        // Thời điểm vẽ cuối cùng (Nano giây).
        this.lastDrawNanoTime= System.nanoTime();
    }
    public void update(){

        // Thời điểm hiện tại theo nano giây.
        long now = System.nanoTime();


        // Chưa vẽ lần nào.
        if(lastDrawNanoTime==-1) {
            lastDrawNanoTime= now;
        }
        // Đổi nano giây ra mili giây (1 nanosecond = 1000000 millisecond).
        int deltaTime = (int) ((now - lastDrawNanoTime)/ 1000000 );


        // Quãng đường mà nhân vật đi được (fixel).
        float distance = VELOCITY * deltaTime;
        // Tính toán vị trí mới của nhân vật.
        this.x = x +  (int)(distance* movingVectorX / movingVectorLength);
        this.y = y +  (int)(distance* movingVectorY / movingVectorLength);
    }
}
