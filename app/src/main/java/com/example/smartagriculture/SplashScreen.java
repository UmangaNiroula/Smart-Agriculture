package com.example.smartagriculture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    //creating a variable that is assigned the timer for which the splash Screen is to be shown
    //timer is set to 3seconds i.e 3000
    private static int SPLASH_TIMER = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        //removing the title bar as the splash screen can't contain one
        //Title bar is the one that contain battery percentage, time, wifi status
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //creating a handler to delay the activity such that the Splash Screen is visible till the Splash_timer value
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                //creating an intent object to redirect to the main page of the app
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);

                //starting the activity to redirect to the destination page
                startActivity(intent);

                //finishing the Splash Screen activity such that this page won't be shown again
                finish();
            }

        },SPLASH_TIMER);

    }
}