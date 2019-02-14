package com.example.abrig.animation_mark1;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable wifiAnimation;
    AnimationDrawable arrowAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.image);
        ImageView arrowImageView = (ImageView) findViewById(R.id.arrow_image);
        imageView.setBackgroundResource(R.drawable.animation);
        wifiAnimation = (AnimationDrawable) imageView.getBackground();
        arrowImageView.setBackgroundResource(R.drawable.arrow_animation);
        arrowAnimation = (AnimationDrawable) arrowImageView.getBackground();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        wifiAnimation.start();
        arrowAnimation.start();
    }
}
