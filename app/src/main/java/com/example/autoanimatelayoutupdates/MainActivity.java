package com.example.autoanimatelayoutupdates;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.transition.Scene;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

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
}
