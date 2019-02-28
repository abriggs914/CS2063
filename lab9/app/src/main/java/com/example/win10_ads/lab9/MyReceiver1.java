package com.example.win10_ads.lab9;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MyReceiver1 extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        String name=intent.getStringExtra("name");
        String tel=intent.getStringExtra("tel");
        Toast.makeText(context, name+ " "+tel,Toast.LENGTH_LONG).show();

    }
}
