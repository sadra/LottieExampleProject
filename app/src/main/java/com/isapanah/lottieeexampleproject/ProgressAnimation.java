package com.isapanah.lottieeexampleproject;

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
import android.widget.SeekBar;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

/**
 * Created by sadra on 8/1/17.
 */

public class ProgressAnimation  extends AppCompatActivity{

    LottieAnimationView lottieView;
    SeekBar seekBar;
    TextView progressPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_animation);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lottieView = (LottieAnimationView) findViewById(R.id.progressAnimation_lottieView);
        lottieView.setAnimation("starwars.json");


        seekBar = (SeekBar) findViewById(R.id.progressAnimation_seekBar);
        progressPercent = (TextView) findViewById(R.id.progressAnimation_txt_progressPercent);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lottieView.setProgress( ((float)progress) /100 );
                progressPercent.setText( ((int)(lottieView.getProgress()*100)) + "%" );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

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

}
