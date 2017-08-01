package com.isapanah.lottieeexampleproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    AppCompatButton simpleAnimationBtn, progressbarAnimationBtn, interactionAnimationBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleAnimationBtn = (AppCompatButton) findViewById(R.id.btn_simple_animation);
        progressbarAnimationBtn = (AppCompatButton) findViewById(R.id.btn_progressbar_animation);
        interactionAnimationBtn = (AppCompatButton) findViewById(R.id.btn_interaction_animation);

    }


}
