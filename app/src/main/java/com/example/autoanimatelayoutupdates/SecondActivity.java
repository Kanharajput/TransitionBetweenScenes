package com.example.autoanimatelayoutupdates;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView labelText;
    private Fade mFade;
    private ViewGroup rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // find out the rootView
        rootView = findViewById(R.id.secondLayout);

    }


    public void AddNewView(View view) {

        // setting up the layout parameters
        //ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);

        mFade = new Fade(Fade.IN);

        // creating a new View to add in the layout
        labelText = new TextView(this);
        //labelText.setLayoutParams(layoutParams);       // on your choice work with or without layout params
        labelText.setText("Bajrang is my hero");
        //labelText.setId(R.id.kanhaTextView);                // necessary when you are trying to add multiple views or you want something get back

        //start recording the changes to update when transition run
        TransitionManager.beginDelayedTransition(rootView,mFade);

        // Adding the new view to rootView
        rootView.addView(labelText);

    }
}