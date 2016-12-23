package com.example.android.practiceset2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int teamAPoints = 0;
    int teamBPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickTeamA(View view) {
        switch (view.getId()) {
            case R.id.tA1:
                teamAPoints += 1;
                displayA(String.valueOf(teamAPoints));
                break;
            case R.id.tA2:
                teamAPoints += 2;
                displayA(String.valueOf(teamAPoints));
                break;
            case R.id.tA3:
                teamAPoints += 3;
                displayA(String.valueOf(teamAPoints));
                break;
            default:
                break;
        }
    }

    public void clickTeamB(View view) {
        switch (view.getId()) {
            case R.id.tB1:
                teamBPoints += 1;
                displayB(String.valueOf(teamBPoints));
                break;
            case R.id.tB2:
                teamBPoints += 2;
                displayB(String.valueOf(teamBPoints));
                break;
            case R.id.tB3:
                teamBPoints += 3;
                displayB(String.valueOf(teamBPoints));
                break;
            default:
                break;
        }
    }

    public void resetButton(View view) {
        teamAPoints = 0;
        teamBPoints = 0;
        displayA(String.valueOf(teamAPoints));
        displayB(String.valueOf(teamBPoints));
    }

    private void displayA(String inputScore) {
        TextView viewATeam = (TextView) findViewById(R.id.teamAScoreBoard);
        viewATeam.setText(inputScore);
    }

    private void displayB(String inputScore) {
        TextView viewATeam = (TextView) findViewById(R.id.teamBScoreBoard);
        viewATeam.setText(inputScore);
    }
}
