package com.example.abrig.general_gestures;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_main);
        allPokemon = parseCSV();
        allPokemon = capitalizeTypeNames(allPokemon);
        try {
            corrector = new Spelling(allPokemon);
        } catch (IOException e) {
            //e.printStackTrace();
        }
        final TextView resultsMessageDisplay = (TextView) findViewById(R.id.results_window);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        resultsMessageDisplay.setText("Beginning: " + allPokemon[0][0] + "\n" + allPokemon[908][0]);
                    }
                });
            }
        };*/
    }
    // This example shows an Activity, but you would use the same approach if
// you were subclassing a View.
    @Override
    public boolean onTouchEvent(MotionEvent event){

        int action = MotionEventCompat.getActionMasked(event);

        switch(action) {
            case (MotionEvent.ACTION_DOWN) :
                Toast.makeText(getApplicationContext(), "Action was DOWN", Toast.LENGTH_SHORT).show();
                //Log.d(DEBUG_TAG,"Action was DOWN");
                return true;
            case (MotionEvent.ACTION_MOVE) :
                Toast.makeText(getApplicationContext(), "Action was MOVE", Toast.LENGTH_SHORT).show();
                //Log.d(DEBUG_TAG,"Action was MOVE");
                return true;
            case (MotionEvent.ACTION_UP) :
                Toast.makeText(getApplicationContext(), "Action was UP", Toast.LENGTH_SHORT).show();
                //Log.d(DEBUG_TAG,"Action was UP");
                return true;
            case (MotionEvent.ACTION_CANCEL) :
                Toast.makeText(getApplicationContext(), "Action was CANCEL", Toast.LENGTH_SHORT).show();
                //Log.d(DEBUG_TAG,"Action was CANCEL");
                return true;
            case (MotionEvent.ACTION_OUTSIDE) :
                Toast.makeText(getApplicationContext(), "Action was Movement occurred outside bounds", Toast.LENGTH_SHORT).show();
                //Log.d(DEBUG_TAG,"Movement occurred outside bounds " +
                //        "of current screen element");
                return true;
            default :
                return super.onTouchEvent(event);
        }
    }
}