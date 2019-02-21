package com.example.win10_ads.servicebounded;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
//import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean isServiceBounded;
    private String randomString;
    private TestService testService;
    private TextView textView;
    private ServiceConnection neededConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            TestService.SpecialBinder i = (TestService.SpecialBinder) iBinder;
            testService = i.getTestService();

            // Set isServiceBounded to True because the service is bounded
            isServiceBounded=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

            // Set isServiceBounded to False because the service is unbounded
            isServiceBounded=false;
        }
    };

    @Override
    protected void onStop() {
        super.onStop();

        // Unbind Service
        unbindService(neededConnection);
        // Set isServiceBounded to False because the service is unbounded
        isServiceBounded=false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent= new Intent(this, TestService.class);
        // Bind service by calling bindService methods and use the required arguments
        // as defined in this class
        bindService(intent,neededConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= (TextView) findViewById(R.id.textView);
        Button fab = (Button)findViewById(R.id.button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isServiceBounded){
                    // Call getRandomString function of the instance of TestService (testService)
                    // and assign it to randomString variable
                    randomString = testService.getRandomString();
                    textView.setText(randomString);
                }
            }
        });
    }

}
