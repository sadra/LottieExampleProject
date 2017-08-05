package com.isapanah.lottieeexampleproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_simple_animation).setOnClickListener(this);
        findViewById(R.id.btn_progress_animation).setOnClickListener(this);
        findViewById(R.id.btn_interaction_animation).setOnClickListener(this);
        findViewById(R.id.btn_animated_font).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent;

        switch (v.getId()) {
            case R.id.btn_simple_animation:
                intent = new Intent(MainActivity.this, SimpleAnimation.class);
                break;
            case R.id.btn_progress_animation:
                intent = new Intent(MainActivity.this, ProgressAnimation.class);
                break;
            case R.id.btn_interaction_animation:
                intent = new Intent(MainActivity.this, InteractionAnimation.class);
                break;
            case R.id.btn_animated_font:
                intent = new Intent(MainActivity.this, AnimatedFont.class);
                break;
            default:
                intent = new Intent(MainActivity.this, SimpleAnimation.class);
        }

        startActivity(intent);

    }
}
