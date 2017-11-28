package com.adriantache.bowlingscoring;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // declare the array that contains the images for number of downed pins
    // and the pointer to the position in the array
    int downedPinsPointer = 0;
    int[] downedPins;
    // declare the variable arrays that contain the scores
    int[] frameScoresPlayer1 = new int[21];
    int[] frameScoresPlayer2 = new int[21];
    int[] frameTotalScoresPlayer1 = new int[10];
    int[] frameTotalScoresPlayer2 = new int[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the array from arrays.xml
        downedPins = getResources().getIntArray(R.array.number_of_pins);
    }

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
        /*Drawable drawable = downedPins.getDrawable(downedPinsPointer);*/
        ImageView imageView = (ImageView) this.findViewById(R.id.downedPins);
        imageView.setImageResource(downedPins[downedPinsPointer]);
        imageView.invalidate();
    }

    // decrement the drawable vector to show number of downed pins
    public void minusDownedPin(View view) {
        if (downedPinsPointer > 0) {
            downedPinsPointer--;
        }
        /*Drawable drawable = downedPins.getDrawable(downedPinsPointer);*/
        ImageView imageView = (ImageView) this.findViewById(R.id.downedPins);
        imageView.setImageResource(downedPins[downedPinsPointer]);
        imageView.invalidate();
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
