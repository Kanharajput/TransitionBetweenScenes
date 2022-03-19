package com.example.autoanimatelayoutupdates;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.transition.MaterialContainerTransform;

public class MainActivity extends AppCompatActivity {

    // creating objects for scenes
    Scene aScene;
    Scene anotherScene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creating the scene root from the layout file
        ViewGroup sceneRoot = findViewById(R.id.scene_root);

        // create the scenes
        aScene = Scene.getSceneForLayout(sceneRoot, R.layout.a_scene,this);
        anotherScene = Scene.getSceneForLayout(sceneRoot, R.layout.another_scene,this);
    }

    public void changeScene(View view) {
        // these are the only two transitions that are provided by default because AutoTransition is choose one from these two.
        Transition fadeTransition = new Fade();
        Transition changeBound = new ChangeBounds();
        Transition autoTransition = new AutoTransition();
        TransitionManager.go(anotherScene, changeBound);
    }

    public void openSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

}
