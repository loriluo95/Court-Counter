package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by zluo2 on 11/3/17.
 */

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;


public class WelcomeActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        Toast toast = Toast.makeText(getApplicationContext(), "Click Welcome!!!", Toast.LENGTH_SHORT);
        toast.show();
    }
    /**
     * open the main activity
     */
    public void openMain(View v) {
        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
    }
}
