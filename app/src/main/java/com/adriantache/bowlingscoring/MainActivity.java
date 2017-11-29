package com.adriantache.bowlingscoring;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // declare the array that contains the images for number of downed pins
    // and the pointer to the position in the array and the downedPins ImageView
    // to prevent always searching for it.
    // Thanks a lot to @Thor on Slack for the solution to the downedPins mechanism!
    int downedPinsPointer = -1;
    TypedArray downedPins;
    ImageView imageViewdownedPins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the array from arrays.xml
        downedPins = getResources().obtainTypedArray(R.array.number_of_pins);

        // define the ImageView for downedPins to use later
        imageViewdownedPins = findViewById(R.id.downedPins);
    }

    // declare the variable arrays that contain the scores
    int[] frameScoresPlayer1 = new int[21];
    int[] frameScoresPlayer2 = new int[21];
    int[] frameTotalScoresPlayer1 = new int[10];
    int[] frameTotalScoresPlayer2 = new int[10];

    // update all the TextViews that display scores, by assigning values from
    // the vectors with frame scores and frame total scores (split/condition it per player?)
    public void updateScores(View view) {
        //
    }

    // increment the drawable vector to show number of downed pins
    public void plusDownedPin(View view) {
        if (downedPinsPointer < 10) {
            downedPinsPointer++;
        }

        updateDownedPins();

    }

    // decrement the drawable vector to show number of downed pins
    public void minusDownedPin(View view) {
        if (downedPinsPointer > 0) {
            downedPinsPointer--;
        }

        updateDownedPins();

    }

    private void updateDownedPins(){
        imageViewdownedPins.setImageResource(downedPins.getResourceId(downedPinsPointer, -1) );
    }

    // process the indicated number of downed pins
    // also add the current score to the array, if applicable
    // stop if strike, store spare as special number (negative?/11?)
    public void submitScore(View view) {
        //
    }

    // change player icon when appropriate
    public void activePlayer(View view) {
        //
    }

    // reset the game
    public void reset(View view) {
        //
    }

}
