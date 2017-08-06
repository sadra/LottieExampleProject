package com.isapanah.lottieeexampleproject;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

/**
 * Created by sadra on 8/1/17.
 */

public class SimpleAnimation  extends AppCompatActivity implements View.OnClickListener{

    LottieAnimationView lottieView;
    float animationSpeed = 1.0f;
    TextView animationSpeedLabel, PauseResumeBtn, changeBoxColor;
    boolean isBoxColorChanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_animation);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lottieView = (LottieAnimationView) findViewById(R.id.simpleAnimation_lottieView);
        lottieView.setAnimation("gift.json");
        lottieView.loop(true);
        lottieView.playAnimation();


        findViewById(R.id.simpleAnimation_btn_pauseAndResume).setOnClickListener(this);
        findViewById(R.id.simpleAnimation_btn_faster).setOnClickListener(this);
        findViewById(R.id.simpleAnimation_btn_slower).setOnClickListener(this);
        findViewById(R.id.simpleAnimation_btn_changeBoxColor).setOnClickListener(this);

        animationSpeedLabel = (TextView) findViewById(R.id.simpleAnimation_txt_animationSpeed);
        PauseResumeBtn = (TextView) findViewById(R.id.simpleAnimation_btn_pauseAndResume);
        changeBoxColor = (TextView) findViewById(R.id.simpleAnimation_btn_changeBoxColor);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.simpleAnimation_btn_pauseAndResume:
                resumeAnimation();
                break;

            case R.id.simpleAnimation_btn_faster:
                reduceSpeed();
                break;

            case R.id.simpleAnimation_btn_slower:
                increaseSpeed();
                break;

            case R.id.simpleAnimation_btn_changeBoxColor:
                changeColor();
                break;
        }

    }

    private void resumeAnimation(){
        if (!lottieView.isAnimating()){
            lottieView.resumeAnimation();
            PauseResumeBtn.setText(R.string.btn_animation_pause);
        } else{
            lottieView.pauseAnimation();
            PauseResumeBtn.setText(R.string.btn_animation_resume);
        }
    }

    private void reduceSpeed(){
        animationSpeed *= 2;
        lottieView.setSpeed(animationSpeed);
        animationSpeedLabel.setText("Speed " + animationSpeed + "X");
    }

    private void increaseSpeed(){
        animationSpeed /= 2;
        lottieView.setSpeed(animationSpeed);
        animationSpeedLabel.setText("Speed " + animationSpeed + "X");
    }

    private void changeColor(){
        if(!isBoxColorChanged){
            final PorterDuffColorFilter colorFilter1 = new PorterDuffColorFilter(Color.parseColor("#CC0321"), PorterDuff.Mode.SRC);
            final PorterDuffColorFilter colorFilter2 = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SRC);
            lottieView.addColorFilterToLayer("body Konturen", colorFilter1);
            lottieView.addColorFilterToLayer("top Konturen", colorFilter2);
            isBoxColorChanged = true;
            changeBoxColor.setText(R.string.btn_animation_clearBoxColor);
        }else{
            lottieView.clearColorFilters();
            isBoxColorChanged = false;
            changeBoxColor.setText(R.string.btn_animation_changeBoxColor);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
