package com.example.abrig.workingwithintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt1,txt2;
    EditText edt1,edt2,edt3;
    Button btn1;
    String appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mt("Create Activity1");
        setContentView(R.layout.activity_main);

        txt1 = (TextView) findViewById(R.id.textView);
        txt2 = (TextView) findViewById(R.id.textView2);
        edt1 = (EditText) findViewById(R.id.editText);
        edt2 = (EditText) findViewById(R.id.editText2);
        edt3 = (EditText) findViewById(R.id.editText3);
        btn1 = (Button) findViewById(R.id.button);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,MainActivity2.class);

                intent1.putExtra("first_name",edt1.getText().toString());
                intent1.putExtra("last_name",edt2.getText().toString());
                intent1.putExtra("date_of_birth",edt3.getText().toString());
//startActivity(intent1);

                startActivityForResult(intent1,1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        txt2.setText(data.getStringExtra("confirmation"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mt("Resume Activity1");
    }
    @Override
    protected void onPause() {
        super.onPause();
        mt("Pause Activity1");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        mt("Restart Activity1");
    }
    @Override
    protected void onStart() {
        super.onStart();
        mt("Start Activity1");

    }

    @Override
    protected void onStop() {
        mt("Stop Activity1 ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mt("Destroy Activity1");
        super.onDestroy();
    }

    public void mt(String string){
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}

