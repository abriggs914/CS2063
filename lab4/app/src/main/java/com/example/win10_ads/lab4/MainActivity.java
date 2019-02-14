package com.example.win10_ads.lab4;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.win10_ads.lab4.R;

public class MainActivity extends AppCompatActivity {
    Button btn;
    ProgressBar progressBar;
    TextView txtpercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        txtpercentage = (TextView) findViewById(R.id.txtpercentage);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                btn.setEnabled(false);
                new DoingAsyncTask().execute();
            }
        });
    }

    private class DoingAsyncTask extends AsyncTask<Void, Integer, Void> {

        int progress_status;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this, "Invoke onPreExecute() Process", Toast.LENGTH_SHORT).show();
            progress_status = 0;
            txtpercentage.setText("Processing 0%");

        }

        @Override
        protected Void doInBackground(Void... params) {
            while (progress_status < 100) {
                progress_status += 5;
                publishProgress(progress_status);
                SystemClock.sleep(200);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
            txtpercentage.setText("Processing " + values[0] + "%");
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Toast.makeText(MainActivity.this, "Invoke onPostExecute() Process", Toast.LENGTH_SHORT).show();
            txtpercentage.setText("Processing complete");
            btn.setEnabled(true);
        }
    }
}