package com.example.mddeloarhossain.bloodbankmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {

    //LinearLayout pic, description;
    //Animation uptodown,downtoup;
    private ProgressBar progressBar;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);


        //pic = findViewById(R.id.picId);
        //description = findViewById(R.id.descriptionId);
        //progressBar = findViewById(R.id.progressbarId);
        //uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        //downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        //pic.setAnimation(uptodown);
        //description.setAnimation(downtoup);
        //description.setAnimation(uptodown);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();

            }
        });
    }
    public void doWork(){
        for (progress=20; progress<=100; progress=progress+20) {
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void startApp(){
        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(intent);
        fileList();
    }
}
