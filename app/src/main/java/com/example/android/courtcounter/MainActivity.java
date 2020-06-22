/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.courtcounter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import static com.example.android.courtcounter.R.mipmap.team_launcher;
import static com.example.android.courtcounter.R.mipmap.team2_launcher;
import static com.example.android.courtcounter.R.mipmap.team3_launcher;
import static com.example.android.courtcounter.R.mipmap.team4_launcher;


/**
 * This activity keeps track of the basketball score for 2 teams.
 */
public class MainActivity extends AppCompatActivity {

    // Tracks the score for Team A
    int scoreTeamA = 0;

    // Tracks the score for Team B
    int scoreTeamB = 0;

    // Team A and B View
    EditText teamAName = null;
    EditText teamBName = null;

    //Click count
    int clickcount = 0;
    int clickcount2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teamAName = (EditText)findViewById(R.id.editText);
        teamBName = (EditText)findViewById(R.id.editText2);
        String jamesbond = "hi";
        String jamesBond = "hello";
        String s = jamesBond + jamesbond;
        Toast toast = Toast.makeText(getApplicationContext(), "3.2 Welcome-zluo2", Toast.LENGTH_LONG);
        toast.show();
        // Display the correct socre if there is already one.
        if (savedInstanceState != null) {
            // Restore value of members from saved state
            scoreTeamA = savedInstanceState.getInt("a",0);
            scoreTeamB = savedInstanceState.getInt("b",0);
            displayForTeamA(scoreTeamA);
            displayForTeamB(scoreTeamB);
        } else {
            displayForTeamA(0);
            displayForTeamB(0);
        }
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

        //noinspection SimpSlifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Save the current score
     * @param savedInstanceState
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("a",scoreTeamA);
        savedInstanceState.putInt("b",scoreTeamB);
        super.onSaveInstanceState(savedInstanceState);

    }
    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
        changeTextcolor();
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
        changeTextcolor();
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
        changeTextcolor();
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
        changeTextcolor();
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
        changeTextcolor();
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    public void addThreeForTeamB(View v) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
        changeTextcolor();
    }

    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        changeTextcolor();
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Send scores by eamil
     */
    public void sendScore(View v) {
        String body,subject = "";
        TextView scoreAView = (TextView) findViewById(R.id.team_a_score);
        TextView scoreBView = (TextView) findViewById(R.id.team_b_score);
        String teamA = teamAName.getText().toString();
        String teamB = teamBName.getText().toString();
        String scoreA = scoreAView.getText().toString();
        String scoreB = scoreBView.getText().toString();
        String winTeam = "";
        if(Integer.parseInt(scoreA) > Integer.parseInt(scoreB)) {
            winTeam = teamA;
        } else if(Integer.parseInt(scoreA) < Integer.parseInt(scoreB)) {
            winTeam = teamA;
        } else {
            winTeam = teamA + "=" + teamB;
        }
        body = String.format("Wining Team: %s \n TeamA: %s has: %s \n TeamB: %s has: %s",winTeam,teamA,scoreA,teamB,scoreB);
        subject = String.format("Scores for Team: %s and Team: %s", teamA, teamB);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT   , body);
        startActivity(Intent.createChooser(intent, ""));
    }

    /**
     * Change team picture by clicking on the picture
     */
    public void changeImage1(View v) {
        ImageView team1 = (ImageView) findViewById(R.id.imageView);
        if((clickcount % 4) == 1) {
            team1.setImageResource(team2_launcher);
        } else if((clickcount % 4) == 2) {
            team1.setImageResource(team3_launcher);
        } else if((clickcount % 4) == 3) {
            team1.setImageResource(team4_launcher);
        } else if((clickcount % 4) == 0) {
            team1.setImageResource(team_launcher);
        }
        clickcount++;
    }
    public void changeImage2(View v) {
        ImageView team2 = (ImageView) findViewById(R.id.imageView2);
        if((clickcount2 % 4) == 1) {
            team2.setImageResource(team3_launcher);
        } else if((clickcount2 % 4) == 2) {
            team2.setImageResource(team4_launcher);
        } else if((clickcount2 % 4) == 3) {
            team2.setImageResource(team_launcher);
        } else if((clickcount2 % 4) == 0) {
            team2.setImageResource(team2_launcher);
        }
        clickcount2++;
    }

    /**
     * Showing the winning team by changing text color
     */
    public void changeTextcolor() {
        TextView scoreAView = (TextView) findViewById(R.id.team_a_score);
        TextView scoreBView = (TextView) findViewById(R.id.team_b_score);
        String scoreA = scoreAView.getText().toString();
        String scoreB = scoreBView.getText().toString();
        if(Integer.parseInt(scoreA) > Integer.parseInt(scoreB)) {
            scoreAView.setTextColor(Color.rgb(0,255,0));
            scoreBView.setTextColor(Color.rgb(255,0,0));
        } else if(Integer.parseInt(scoreA) < Integer.parseInt(scoreB)) {
            scoreBView.setTextColor(Color.rgb(0,255,0));
            scoreAView.setTextColor(Color.rgb(255,0,0));
        } else {
            scoreAView.setTextColor(Color.rgb(0,0,0));
            scoreBView.setTextColor(Color.rgb(0,0,0));
        }

    }
}
