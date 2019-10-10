package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splashmywallet extends AppCompatActivity {
    private TextView splashtextview;
    private ImageView splashimgview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashmywallet);

        splashtextview = (TextView) findViewById(R.id.splashtextview);
        splashimgview = (ImageView) findViewById(R.id.splashimgview);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransitions);
        splashtextview.startAnimation(myanim);
        splashimgview.startAnimation(myanim);
        final Intent i = new Intent(this,Daily.class);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startActivity(i);
                    finish();

                }
            }
        };
        timer.start();


    }
}

