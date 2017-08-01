package com.isapanah.lottieeexampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by sadra on 8/1/17.
 */

public class InteractionAnimation  extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_simple_animation).setOnClickListener(this);
        findViewById(R.id.btn_progress_animation).setOnClickListener(this);
        findViewById(R.id.btn_interaction_animation).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_simple_animation:
                break;
            default:
        }

    }
}
