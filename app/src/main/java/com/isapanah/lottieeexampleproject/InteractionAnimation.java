package com.isapanah.lottieeexampleproject;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

/**
 * Created by sadra on 8/1/17.
 */

public class InteractionAnimation  extends AppCompatActivity implements View.OnClickListener {

    LottieAnimationView animatedRadioButton, animatedSwitchButton, animatedHamburger, animatedMuteButton;
    boolean hamburgerIsOpen = false, switchIsOn = false, isMute = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interaction_animation);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.animatedRadioButtonContainer).setOnClickListener(this);
        findViewById(R.id.animatedSwitchButtonContainer).setOnClickListener(this);
        findViewById(R.id.animatedMuteContainer).setOnClickListener(this);
        findViewById(R.id.animatedHamburgerContainer).setOnClickListener(this);

        animatedRadioButton = (LottieAnimationView) findViewById(R.id.animatedRadioButton);
        animatedSwitchButton = (LottieAnimationView) findViewById(R.id.animatedSwitchButton);
        animatedHamburger = (LottieAnimationView) findViewById(R.id.animatedHamburger);
        animatedMuteButton = (LottieAnimationView) findViewById(R.id.animatedMute);

        animatedMuteButton.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(InteractionAnimation.this, isMute? "Sound is mute." : "Sound isn't mute.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });


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

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.animatedRadioButtonContainer:
                selectRadioButton();
                break;
            case R.id.animatedSwitchButtonContainer:
                selectSwitchButton();
                break;
            case R.id.animatedHamburgerContainer:
                selectHamburger();
                break;
            case R.id.animatedMuteContainer:
                selectMuteButton();
                break;
            default:
        }

    }

    private void selectRadioButton(){
        if(animatedRadioButton.getProgress() != 1.0)
            animatedRadioButton.playAnimation();
        else
            animatedRadioButton.setProgress(0.0f);
    }

    private void selectSwitchButton(){
        if(switchIsOn){
            animatedSwitchButton.reverseAnimation();
            switchIsOn = false;
        } else {
            animatedSwitchButton.playAnimation();
            switchIsOn = true;
        }
    }

    private void selectHamburger(){
        ValueAnimator animator;
        if(!hamburgerIsOpen){
            animator = ValueAnimator.ofFloat(0.05f, 0.45f).setDuration(2000);
            hamburgerIsOpen = true;
        } else {
            animator = ValueAnimator.ofFloat(0.45f, 0.05f).setDuration(2000);
            hamburgerIsOpen = false;
        }

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                animatedHamburger.setProgress((Float) animation.getAnimatedValue());
            }
        });
        animator.start();
    }

    private void selectMuteButton(){

        if(!isMute){
            animatedMuteButton.playAnimation();
            isMute = true;
        }else{
            animatedMuteButton.reverseAnimation();
            isMute = false;
        }

    }

}