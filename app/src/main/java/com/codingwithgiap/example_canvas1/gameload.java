package com.codingwithgiap.example_canvas1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class gameload  extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Loại bỏ tiêu đề.
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Sét đặt giao diện của Activity.
        this.setContentView(new GameSurface(this));
    }
}