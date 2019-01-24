package com.example.abrig.workingwithintents;

import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity2 extends AppCompatActivity  {

    TextView txt5,txt7;
    EditText edt4;
    Button btn2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mt("Create Activity2");
        setContentView(R.layout.activity_main2);

        txt5 = (TextView) findViewById(R.id.editText4);
        txt7 = (TextView) findViewById(R.id.editText5);
        edt4 = (EditText) findViewById(R.id.editText6);

        btn2 = (Button) findViewById(R.id.button2);

        Intent intent2 = getIntent();

//��String first = intent2.getStringExtra("first_name");
//��String last = intent2.getStringExtra("last_name");
//��Stringdob = intent2.getStringExtra("date_of_birth");�����
        Bundle bundle = intent2.getExtras();
        String first = bundle.getString("first_name");
        String last = bundle.getString("last_name");
        String dob = bundle.getString("date_of_birth");

        txt5.setText(":��"+first.toString()+" "+last.toString());
        txt7.setText(":��"+dob.toString());

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.putExtra("confirmation", edt4.getText().toString());
                setResult(1, intent2);
                finish();
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        mt("Resume Activity2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        mt("Pause Activity2");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mt("Restart Activity2");
    }

    @Override
    protected void onStart() {
        super.onStart();
        mt("Start Activity2");
    }
    @Override
    protected void onStop() {
        mt("Stop Activity2 ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mt("Destroy Activity2");
        super.onDestroy();
    }

    public void mt(String string){
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}


