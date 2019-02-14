package com.example.win10_ads.myapplication;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int num1;    // the numbers on the left and right buttons
    private int num2;
    private int points=0;  // player's point total; initially 0

    /*
     * Called when the player clicks the left number button.
     */
    public void buttonLeftClicked(View view) {
        check(num1, num2);
    }

    /*
     * Called when the player clicks the right number button.
     */
    public void buttonRightClicked(View view) {
        check(num2, num1);
    }

    /*
     * Updates the player's score based on whether they guessed correctly.
     * Also shows a 'toast' which is a brief popup message.
     */
    private void check(int a, int b) {
        if (a > b) {
            points++;
            Toast.makeText(this, "Correct!",
                    Toast.LENGTH_SHORT).show();
        } else {
            points--;
            Toast.makeText(this, "You are Wrong.",Toast.LENGTH_SHORT).show();
        }

        TextView pointsView = (TextView) findViewById(R.id.pointsTextView);
        pointsView.setText("Points: " + points);
        roll();
    }

    /*
     * Chooses new random integers to appear on the two buttons.
     */
    private void roll() {
        // pick two random numbers
        Random r = new Random();
        num1 = r.nextInt(9);
        num2 = r.nextInt(9);
        while (num2 == num1) {
            num2 = r.nextInt(9);
        }
        // set the buttons to display the random numbers
        Button left = (Button) findViewById(R.id.buttonLeft);
        left.setText("" + num1);     // "" + int -> converts int to String

        Button right = (Button) findViewById(R.id.buttonRight);
        right.setText("" + num2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        roll();   // <-- we added this line to set initial button random numbers


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
