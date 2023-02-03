package com.example.myapplication.Common;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER = 1500;
    //Variables
    ImageView backgroundImage;
    TextView powerByLine;

    //Animations
    Animation sideAnim, bottomAnim;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        //Hooks
        backgroundImage = findViewById(R.id.background_image);
        powerByLine = findViewById(R.id.powered_by_line);

        //Animations
        sideAnim = AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        //set Animations
        backgroundImage.setAnimation(sideAnim);
        powerByLine.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =  new Intent(SplashScreen.this, Login.class);
                startActivity(intent);
                finish();




            }
        },SPLASH_TIMER);


    }


}
