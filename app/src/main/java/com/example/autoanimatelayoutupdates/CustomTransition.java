package com.example.autoanimatelayoutupdates;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;

public class CustomTransition extends Transition {

    // create a variable to store property in map
    private static final String PROPNAME_BACKGROUND = "customTransition:change_color:background";

    @Override
    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);                // get the value from the first scene
    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);               // get the desired values from the second scene
    }

    // method to capture value and store in the transitionValues map
    private void captureValues(TransitionValues transitionValues) {
        transitionValues.values.put(PROPNAME_BACKGROUND,transitionValues.view.getBackground());
    }

    @Override
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {

        // check startvalues and endvalues are not null
        if(startValues == null || endValues == null) {
            return null;
        }

        final View view = endValues.view;       // as both startValues and endValues have the same view

        // getting the background of the views from the startscene values and endscene values, which are saved by us
        Drawable startBackground = (Drawable) startValues.values.get(PROPNAME_BACKGROUND);
        Drawable endBackground = (Drawable) endValues.values.get(PROPNAME_BACKGROUND);

        // get the color from the Drawable class
        if(startBackground instanceof ColorDrawable && endBackground instanceof ColorDrawable) {
            ColorDrawable startColor = (ColorDrawable) startBackground;
            ColorDrawable endColor = (ColorDrawable) endBackground;

            if(startColor.getColor() != endColor.getColor()) {
                ObjectAnimator colorAnim = ObjectAnimator.ofInt(view, "textColor", startColor.getColor(), endColor.getColor());
                colorAnim.setEvaluator(new ArgbEvaluator());
                colorAnim.setDuration(2000);
                colorAnim.start();

                return colorAnim;
            }
        }
        return null;
    }
}
