package com.adriantache.bowlingscoring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // declaring the variable arrays that contain the scores
    int[] frameScoresPlayer1 = new int[21];
    int[] frameScoresPlayer2 = new int[21];
    int[] frameTotalScoresPlayer1 = new int[10];
    int[] frameTotalScoresPlayer2 = new int[10];

    // this function updates all the TextViews that include scores, by assigning values from
    // the vectors with frame scores and frame total scores
    public void updateScores(View view){


    }

    //


}
