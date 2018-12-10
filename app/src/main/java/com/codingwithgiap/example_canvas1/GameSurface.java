package com.codingwithgiap.example_canvas1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

class GameSurface extends SurfaceView  implements SurfaceHolder.Callback{
    private GameThread gameThread;
    private box bx;
    public GameSurface(Context context) {
        super(context);
        // Đảm bảo Game Surface có thể focus để điều khiển các sự kiện.
        this.setFocusable(true);


        // Sét đặt các sự kiện liên quan tới Game.
        this.getHolder().addCallback(this);
    }
    // Thi hành phương thức của interface SurfaceHolder.Callback
    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        Bitmap tieu= BitmapFactory.decodeResource(this.getResources(),R.drawable.chibi1);
        this.bx = new box(this,tieu,100,50);
        this.gameThread = new GameThread(this,holder);
        this.gameThread.setRunning(true);
        this.gameThread.start();
    }

    // Thi hành phương thức của interface SurfaceHolder.Callback
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }


    // Thi hành phương thức của interface SurfaceHolder.Callback
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry= true;
        while(retry) {
            try {
                this.gameThread.setRunning(false);


                // Luồng cha, cần phải tạm dừng chờ GameThread kết thúc.
                this.gameThread.join();
            }catch(InterruptedException e)  {
                e.printStackTrace();
            }
            retry= true;
        }
    }

    public void update() {
        bx.update();
    }
    @Override
    public void draw(Canvas canvas)  {
        super.draw(canvas);
        this.bx.draw(canvas);
        //this.chibi1.draw(canvas);
    }
}
