package com.example.quidditchscorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreA = 0;
    int scoreB = 0;
    int hitsA = 0;
    int hitsB = 0;
    boolean newRound = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void displayPointsA(int score) {
        TextView pointsView = (TextView) findViewById(R.id.team_a_points);
        pointsView.setText(String.valueOf(score));
    }

    private void displayPointsB(int score) {
        TextView pointsView = (TextView) findViewById(R.id.team_b_points);
        pointsView.setText(String.valueOf(score));
    }

    private void displayHitsA(int score) {
        TextView hitsView = (TextView) findViewById(R.id.team_a_hits);
        hitsView.setText(String.valueOf(score));
    }

    private void displayHitsB(int score) {
        TextView hitsView = (TextView) findViewById(R.id.team_b_hits);
        hitsView.setText(String.valueOf(score));
    }

    public void displayMessage(String message) {
        TextView messageView = (TextView) findViewById(R.id.message);
        messageView.setText(message);
    }

    public void checkForNewRound() {
        if (newRound) {
            displayMessage("");
            scoreA = 0;
            scoreB = 0;
            hitsA = 0;
            hitsB = 0;
            displayPointsA(0);
            displayPointsB(0);
            displayHitsA(0);
            displayHitsB(0);
            newRound = false;
        }
    }

    public void addTenA(View view) {
        checkForNewRound();
        scoreA += 10;
        displayPointsA(scoreA);
    }

    public void addTenB(View view) {
        checkForNewRound();
        scoreB += 10;
        displayPointsB(scoreB);
    }

    public void addHitA(View view) {
        checkForNewRound();
        displayHitsA(++hitsA);
    }

    public void addHitB(View view) {
        checkForNewRound();
        displayHitsB(++hitsB);
    }

    public void displayWinner() {
        if (scoreA > scoreB)
            displayMessage("TEAM A WINS");
        else if (scoreB > scoreA)
            displayMessage("TEAM B WINS");
        else
            displayMessage("IT'S A DRAW");
    }

    public void snitchA(View view) {
        checkForNewRound();
        scoreA += 30;
        displayPointsA(scoreA);
        newRound = true;
        displayWinner();
    }

    public void snitchB(View view) {
        checkForNewRound();
        scoreB += 30;
        displayPointsB(scoreB);
        newRound = true;
        displayWinner();
    }

    public void reset(View view) {
        newRound = true;
        checkForNewRound();
    }
}