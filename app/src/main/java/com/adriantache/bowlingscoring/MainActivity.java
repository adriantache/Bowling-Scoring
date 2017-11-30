package com.adriantache.bowlingscoring;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static java.lang.Boolean.FALSE;

public class MainActivity extends AppCompatActivity {

    // declare the array that contains the images for number of downed pins
    // and the pointer to the position in the array and the downedPins ImageView
    // and all score TextViews to prevent always searching for them.
    // Thanks a lot to @Thor on Slack for the solution to the downedPins mechanism!
    int downedPinsPointer = -1;
    TypedArray downedPins;
    ImageView imageViewDownedPins;
    ImageView activePlayer1;
    ImageView activePlayer2;
    TextView frame1Score1Player1;
    TextView frame1Score2Player1;
    TextView frame2Score1Player1;
    TextView frame2Score2Player1;
    TextView frame3Score1Player1;
    TextView frame3Score2Player1;
    TextView frame4Score1Player1;
    TextView frame4Score2Player1;
    TextView frame5Score1Player1;
    TextView frame5Score2Player1;
    TextView frame6Score1Player1;
    TextView frame6Score2Player1;
    TextView frame7Score1Player1;
    TextView frame7Score2Player1;
    TextView frame8Score1Player1;
    TextView frame8Score2Player1;
    TextView frame9Score1Player1;
    TextView frame9Score2Player1;
    TextView frame10Score1Player1;
    TextView frame10Score2Player1;
    TextView frame10Score3Player1;
    TextView frame1Score1Player2;
    TextView frame1Score2Player2;
    TextView frame2Score1Player2;
    TextView frame2Score2Player2;
    TextView frame3Score1Player2;
    TextView frame3Score2Player2;
    TextView frame4Score1Player2;
    TextView frame4Score2Player2;
    TextView frame5Score1Player2;
    TextView frame5Score2Player2;
    TextView frame6Score1Player2;
    TextView frame6Score2Player2;
    TextView frame7Score1Player2;
    TextView frame7Score2Player2;
    TextView frame8Score1Player2;
    TextView frame8Score2Player2;
    TextView frame9Score1Player2;
    TextView frame9Score2Player2;
    TextView frame10Score1Player2;
    TextView frame10Score2Player2;
    TextView frame10Score3Player2;
    TextView frame1TotalScorePlayer1;
    TextView frame2TotalScorePlayer1;
    TextView frame3TotalScorePlayer1;
    TextView frame4TotalScorePlayer1;
    TextView frame5TotalScorePlayer1;
    TextView frame6TotalScorePlayer1;
    TextView frame7TotalScorePlayer1;
    TextView frame8TotalScorePlayer1;
    TextView frame9TotalScorePlayer1;
    TextView frame10TotalScorePlayer1;
    TextView frame1TotalScorePlayer2;
    TextView frame2TotalScorePlayer2;
    TextView frame3TotalScorePlayer2;
    TextView frame4TotalScorePlayer2;
    TextView frame5TotalScorePlayer2;
    TextView frame6TotalScorePlayer2;
    TextView frame7TotalScorePlayer2;
    TextView frame8TotalScorePlayer2;
    TextView frame9TotalScorePlayer2;
    TextView frame10TotalScorePlayer2;

    // declare the variable arrays that contain the scores
    // and the pointers to indicate frame
    int[] frameScoresPlayer1 = new int[22];
    int[] frameScoresPlayer2 = new int[22];
    int[] frameTotalScoresPlayer1 = new int[11];
    int[] frameTotalScoresPlayer2 = new int[11];

    // declare various other variables
    int frameNumber = 1;
    int activePlayer = 1;
    boolean frameEnd = FALSE;
    int maxPins = 10;
    int lastScore = 0;
    int strikeScore = 0;
    int scorePointer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the array from arrays.xml
        downedPins = getResources().obtainTypedArray(R.array.number_of_pins);

        // define the ImageView for downedPins to use later
        imageViewDownedPins = findViewById(R.id.downedPins);

        // define activePlayer ImageViews
        activePlayer1 = findViewById(R.id.activePlayer1);
        activePlayer2 = findViewById(R.id.activePlayer2);

        // find all score TextViews
        frame1Score1Player1 = findViewById(R.id.frame1Score1Player1);
        frame1Score2Player1 = findViewById(R.id.frame1Score2Player1);
        frame2Score1Player1 = findViewById(R.id.frame2Score1Player1);
        frame2Score2Player1 = findViewById(R.id.frame2Score2Player1);
        frame3Score1Player1 = findViewById(R.id.frame3Score1Player1);
        frame3Score2Player1 = findViewById(R.id.frame3Score2Player1);
        frame4Score1Player1 = findViewById(R.id.frame4Score1Player1);
        frame4Score2Player1 = findViewById(R.id.frame4Score2Player1);
        frame5Score1Player1 = findViewById(R.id.frame5Score1Player1);
        frame5Score2Player1 = findViewById(R.id.frame5Score2Player1);
        frame6Score1Player1 = findViewById(R.id.frame6Score1Player1);
        frame6Score2Player1 = findViewById(R.id.frame6Score2Player1);
        frame7Score1Player1 = findViewById(R.id.frame7Score1Player1);
        frame7Score2Player1 = findViewById(R.id.frame7Score2Player1);
        frame8Score1Player1 = findViewById(R.id.frame8Score1Player1);
        frame8Score2Player1 = findViewById(R.id.frame8Score2Player1);
        frame9Score1Player1 = findViewById(R.id.frame9Score1Player1);
        frame9Score2Player1 = findViewById(R.id.frame9Score2Player1);
        frame10Score1Player1 = findViewById(R.id.frame10Score1Player1);
        frame10Score2Player1 = findViewById(R.id.frame10Score2Player1);
        frame10Score3Player1 = findViewById(R.id.frame10Score3Player1);
        frame1Score1Player2 = findViewById(R.id.frame1Score1Player2);
        frame1Score2Player2 = findViewById(R.id.frame1Score2Player2);
        frame2Score1Player2 = findViewById(R.id.frame2Score1Player2);
        frame2Score2Player2 = findViewById(R.id.frame2Score2Player2);
        frame3Score1Player2 = findViewById(R.id.frame3Score1Player2);
        frame3Score2Player2 = findViewById(R.id.frame3Score2Player2);
        frame4Score1Player2 = findViewById(R.id.frame4Score1Player2);
        frame4Score2Player2 = findViewById(R.id.frame4Score2Player2);
        frame5Score1Player2 = findViewById(R.id.frame5Score1Player2);
        frame5Score2Player2 = findViewById(R.id.frame5Score2Player2);
        frame6Score1Player2 = findViewById(R.id.frame6Score1Player2);
        frame6Score2Player2 = findViewById(R.id.frame6Score2Player2);
        frame7Score1Player2 = findViewById(R.id.frame7Score1Player2);
        frame7Score2Player2 = findViewById(R.id.frame7Score2Player2);
        frame8Score1Player2 = findViewById(R.id.frame8Score1Player2);
        frame8Score2Player2 = findViewById(R.id.frame8Score2Player2);
        frame9Score1Player2 = findViewById(R.id.frame9Score1Player2);
        frame9Score2Player2 = findViewById(R.id.frame9Score2Player2);
        frame10Score1Player2 = findViewById(R.id.frame10Score1Player2);
        frame10Score2Player2 = findViewById(R.id.frame10Score2Player2);
        frame10Score3Player2 = findViewById(R.id.frame10Score3Player2);
        frame1TotalScorePlayer1 = findViewById(R.id.frame1TotalScorePlayer1);
        frame2TotalScorePlayer1 = findViewById(R.id.frame2TotalScorePlayer1);
        frame3TotalScorePlayer1 = findViewById(R.id.frame3TotalScorePlayer1);
        frame4TotalScorePlayer1 = findViewById(R.id.frame4TotalScorePlayer1);
        frame5TotalScorePlayer1 = findViewById(R.id.frame5TotalScorePlayer1);
        frame6TotalScorePlayer1 = findViewById(R.id.frame6TotalScorePlayer1);
        frame7TotalScorePlayer1 = findViewById(R.id.frame7TotalScorePlayer1);
        frame8TotalScorePlayer1 = findViewById(R.id.frame8TotalScorePlayer1);
        frame9TotalScorePlayer1 = findViewById(R.id.frame9TotalScorePlayer1);
        frame10TotalScorePlayer1 = findViewById(R.id.frame10TotalScorePlayer1);
        frame1TotalScorePlayer2 = findViewById(R.id.frame1TotalScorePlayer2);
        frame2TotalScorePlayer2 = findViewById(R.id.frame2TotalScorePlayer2);
        frame3TotalScorePlayer2 = findViewById(R.id.frame3TotalScorePlayer2);
        frame4TotalScorePlayer2 = findViewById(R.id.frame4TotalScorePlayer2);
        frame5TotalScorePlayer2 = findViewById(R.id.frame5TotalScorePlayer2);
        frame6TotalScorePlayer2 = findViewById(R.id.frame6TotalScorePlayer2);
        frame7TotalScorePlayer2 = findViewById(R.id.frame7TotalScorePlayer2);
        frame8TotalScorePlayer2 = findViewById(R.id.frame8TotalScorePlayer2);
        frame9TotalScorePlayer2 = findViewById(R.id.frame9TotalScorePlayer2);
        frame10TotalScorePlayer2 = findViewById(R.id.frame10TotalScorePlayer2);

    }

    // update all the TextViews that display scores, by assigning values from
    // the vectors with frame scores and frame total scores (split/condition it per player?)
    public void updateScores() {
        if (activePlayer == 1) {
            frame1Score1Player1.setText("" + frameScoresPlayer1[1]);
            frame1Score2Player1.setText("" + frameScoresPlayer1[2]);
            frame2Score1Player1.setText("" + frameScoresPlayer1[3]);
            frame2Score2Player1.setText("" + frameScoresPlayer1[4]);
            frame3Score1Player1.setText("" + frameScoresPlayer1[5]);
            frame3Score2Player1.setText("" + frameScoresPlayer1[6]);
            frame4Score1Player1.setText("" + frameScoresPlayer1[7]);
            frame4Score2Player1.setText("" + frameScoresPlayer1[8]);
            frame5Score1Player1.setText("" + frameScoresPlayer1[9]);
            frame5Score2Player1.setText("" + frameScoresPlayer1[10]);
            frame6Score1Player1.setText("" + frameScoresPlayer1[11]);
            frame6Score2Player1.setText("" + frameScoresPlayer1[12]);
            frame7Score1Player1.setText("" + frameScoresPlayer1[13]);
            frame7Score2Player1.setText("" + frameScoresPlayer1[14]);
            frame8Score1Player1.setText("" + frameScoresPlayer1[15]);
            frame8Score2Player1.setText("" + frameScoresPlayer1[16]);
            frame9Score1Player1.setText("" + frameScoresPlayer1[17]);
            frame9Score2Player1.setText("" + frameScoresPlayer1[18]);
            frame10Score1Player1.setText("" + frameScoresPlayer1[19]);
            frame10Score2Player1.setText("" + frameScoresPlayer1[20]);
            frame10Score3Player1.setText("" + frameScoresPlayer1[21]);
            frame1TotalScorePlayer1.setText("" + frameTotalScoresPlayer1[1]);
            frame2TotalScorePlayer1.setText("" + frameTotalScoresPlayer1[2]);
            frame3TotalScorePlayer1.setText("" + frameTotalScoresPlayer1[3]);
            frame4TotalScorePlayer1.setText("" + frameTotalScoresPlayer1[4]);
            frame5TotalScorePlayer1.setText("" + frameTotalScoresPlayer1[5]);
            frame6TotalScorePlayer1.setText("" + frameTotalScoresPlayer1[6]);
            frame7TotalScorePlayer1.setText("" + frameTotalScoresPlayer1[7]);
            frame8TotalScorePlayer1.setText("" + frameTotalScoresPlayer1[8]);
            frame9TotalScorePlayer1.setText("" + frameTotalScoresPlayer1[9]);
            frame10TotalScorePlayer1.setText("" + frameTotalScoresPlayer1[10]);
        } else {
            frame1Score1Player2.setText("" + frameScoresPlayer2[1]);
            frame1Score2Player2.setText("" + frameScoresPlayer2[2]);
            frame2Score1Player2.setText("" + frameScoresPlayer2[3]);
            frame2Score2Player2.setText("" + frameScoresPlayer2[4]);
            frame3Score1Player2.setText("" + frameScoresPlayer2[5]);
            frame3Score2Player2.setText("" + frameScoresPlayer2[6]);
            frame4Score1Player2.setText("" + frameScoresPlayer2[7]);
            frame4Score2Player2.setText("" + frameScoresPlayer2[8]);
            frame5Score1Player2.setText("" + frameScoresPlayer2[9]);
            frame5Score2Player2.setText("" + frameScoresPlayer2[10]);
            frame6Score1Player2.setText("" + frameScoresPlayer2[11]);
            frame6Score2Player2.setText("" + frameScoresPlayer2[12]);
            frame7Score1Player2.setText("" + frameScoresPlayer2[13]);
            frame7Score2Player2.setText("" + frameScoresPlayer2[14]);
            frame8Score1Player2.setText("" + frameScoresPlayer2[15]);
            frame8Score2Player2.setText("" + frameScoresPlayer2[16]);
            frame9Score1Player2.setText("" + frameScoresPlayer2[17]);
            frame9Score2Player2.setText("" + frameScoresPlayer2[18]);
            frame10Score1Player2.setText("" + frameScoresPlayer2[19]);
            frame10Score2Player2.setText("" + frameScoresPlayer2[20]);
            frame10Score3Player2.setText("" + frameScoresPlayer2[21]);
            frame1TotalScorePlayer2.setText("" + frameTotalScoresPlayer2[1]);
            frame2TotalScorePlayer2.setText("" + frameTotalScoresPlayer2[2]);
            frame3TotalScorePlayer2.setText("" + frameTotalScoresPlayer2[3]);
            frame4TotalScorePlayer2.setText("" + frameTotalScoresPlayer2[4]);
            frame5TotalScorePlayer2.setText("" + frameTotalScoresPlayer2[5]);
            frame6TotalScorePlayer2.setText("" + frameTotalScoresPlayer2[6]);
            frame7TotalScorePlayer2.setText("" + frameTotalScoresPlayer2[7]);
            frame8TotalScorePlayer2.setText("" + frameTotalScoresPlayer2[8]);
            frame9TotalScorePlayer2.setText("" + frameTotalScoresPlayer2[9]);
            frame10TotalScorePlayer2.setText("" + frameTotalScoresPlayer2[10]);
        }
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
        } else if (downedPinsPointer==-1) {
            downedPinsPointer++;
        }

        updateDownedPins();

    }

    // update downedPins ImageView
    private void updateDownedPins() {
        imageViewDownedPins.setImageResource(downedPins.getResourceId(downedPinsPointer, -1));
    }

    // process the indicated number of downed pins and calculate current score
    // also add the current score to the array, if applicable
    // stop if strike, store spare as special number (negative?/11?)
    public void submitScore(View view) {
        if (frameNumber == 10) {
            // process three scores instead of two
        } else {
        }
        activePlayer();
    }

    // set up a new frame
    private void newFrame() {
        // reset maxPins, minPins, call activePlayer, etc.
    }

    // retroactively calculate score for strikes and spares
    private void calculateScore() {
        // process score vectors as appropriate using lastScore and strikeScore and frameNumber
    }

    // change player icon when appropriate
    private void activePlayer() {
        if (activePlayer == 1) {
            activePlayer1.setVisibility(activePlayer1.VISIBLE);
            activePlayer2.setVisibility(activePlayer2.INVISIBLE);
            activePlayer = 2;
        } else if (activePlayer == 2) {
            activePlayer1.setVisibility(activePlayer1.INVISIBLE);
            activePlayer2.setVisibility(activePlayer2.VISIBLE);
            activePlayer = 1;
        }
    }

    // reset the game
    public void resetGame(View v) {
        //remove this, only included for testing
        /*int i = 0;
        while (i < 22) {
            i++;
            frameScoresPlayer1[i] = 0;
            frameScoresPlayer2[i] = 0;
        }
        while (i < 11) {
            i++;
            frameTotalScoresPlayer1[i] = 0;
            frameTotalScoresPlayer2[i] = 0;
        }*/
        updateScores();
        activePlayer = 1;
        //remove this, only included for testing
    }

}
