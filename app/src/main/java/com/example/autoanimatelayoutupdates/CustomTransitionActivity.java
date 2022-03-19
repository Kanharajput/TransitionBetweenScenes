package com.example.autoanimatelayoutupdates;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class CustomTransitionActivity extends AppCompatActivity {

    private TextView textView;
    private Scene firstScene;
    private Scene secondScene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_transition);

        // change the title color
        textView = findViewById(R.id.title_textview);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator colorAnim = ObjectAnimator.ofInt(v, "textColor", Color.RED, Color.GREEN);
                colorAnim.setEvaluator(new ArgbEvaluator());
                colorAnim.setDuration(2000);
                colorAnim.start();
            }
        });

        FrameLayout container = findViewById(R.id.frame_layout);

        // inflate the scenes
        firstScene =  Scene.getSceneForLayout(container,R.layout.first_scene,this);
        secondScene = Scene.getSceneForLayout(container,R.layout.second_scene,this);

    }

    public void goToSecondScene(View view) {
        CustomTransition customTransition = new CustomTransition();
        TransitionManager.go(secondScene,customTransition);
    }
}