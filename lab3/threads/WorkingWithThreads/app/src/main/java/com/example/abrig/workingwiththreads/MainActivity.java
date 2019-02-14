package com.example.abrig.workingwiththreads;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import com.example.abrig.workingwiththreads.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void buttonClick(View view)
    {

        long endTime = System.currentTimeMillis() + 20*1000;

        while (System.currentTimeMillis() < endTime) {
            synchronized (this) {
                try {
                    wait(endTime - System.currentTimeMillis());
                } catch (Exception e) {
                }
            }
        }
        TextView myTextView =
                (TextView)findViewById(R.id.textView);
        myTextView.setText("Button 1 Pressed");

    }

    // Using Threads
    public void clickButton2(View view) {

        Runnable runnable = new Runnable() {
            public void run() {

                long endTime = System.currentTimeMillis() + 20*1000;

                while (System.currentTimeMillis() < endTime) {
                    synchronized (this) {

                        try {
                            wait(endTime - System.currentTimeMillis());
                        } catch (Exception e) {}
                    }
                }

            }
        };
        Thread mythread = new Thread(runnable);
        mythread.start();
        TextView myTextView =
                (TextView)findViewById(R.id.textView);
        myTextView.setText("Button 2 Pressed");
    }
}