package com.adriantache.bowlingscoring;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // declare the array that contains the images for number of downed pins
    // and the pointer to the position in the array and the downedPins ImageView
    // and all score TextViews to prevent always searching for them.
    // ~~~Thanks a lot to @Thor on Slack for the solution to the downedPins mechanism!~~~
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
    TextView totalScorePlayer1;
    TextView totalScorePlayer2;

    TextView nameOfPlayer1;
    EditText editNamePlayer1;
    Button changePlayer1Name;
    TextView nameOfPlayer2;
    EditText editNamePlayer2;
    Button changePlayer2Name;

    // declare the variable arrays that contain the scores
    // and the pointers to indicate frame
    int[] frameScoresPlayer1 = new int[22];
    int[] frameScoresPlayer2 = new int[22];
    int[] frameTotalScoresPlayer1 = new int[11];
    int[] frameTotalScoresPlayer2 = new int[11];

    // declare various other variables
    int frameNumber = 1;
    int activePlayer = 1;
    boolean frameEnd = false;
    boolean extraScore = false;
    int maxPins = 10;
    int tScorePlayer1 = 0;
    int tScorePlayer2 = 0;

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

        // find all score TextViews (masked by splash screen)
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
        totalScorePlayer1 = findViewById(R.id.totalScorePlayer1);
        totalScorePlayer2 = findViewById(R.id.totalScorePlayer2);

        nameOfPlayer1 = findViewById(R.id.namePlayer1);
        editNamePlayer1 = findViewById(R.id.editNamePlayer1);
        changePlayer1Name = findViewById(R.id.changePlayer1Name);
        nameOfPlayer2 = findViewById(R.id.namePlayer2);
        editNamePlayer2 = findViewById(R.id.editNamePlayer2);
        changePlayer2Name = findViewById(R.id.changePlayer2Name);
    }

    // update all the TextViews that display scores, by assigning values from
    // the vectors with frame scores and frame total scores (split/condition it per player?)
    public void updateScores() {
        if (activePlayer == 1) {

            if (frameScoresPlayer1[1] == 10) {
                frame1Score1Player1.setText("X");
            } else if (frameScoresPlayer1[1] < 0) {
                frame1Score1Player1.setText("/");
            } else if (frameScoresPlayer1[1] == 40) {
                frame1Score1Player1.setText("");
            } else if (frameScoresPlayer1[1] == 0) {
                frame1Score1Player1.setText("-");
            } else {
                frame1Score1Player1.setText(String.format("%d", frameScoresPlayer1[1]));
            }
            if (frameScoresPlayer1[2] == 10) {
                frame1Score2Player1.setText("X");
            } else if (frameScoresPlayer1[2] < 0) {
                frame1Score2Player1.setText("/");
            } else if (frameScoresPlayer1[2] == 40) {
                frame1Score2Player1.setText("");
            } else if (frameScoresPlayer1[2] == 0) {
                frame1Score2Player1.setText("-");
            } else {
                frame1Score2Player1.setText(String.format("%d", frameScoresPlayer1[2]));
            }
            if (frameScoresPlayer1[3] == 10) {
                frame2Score1Player1.setText("X");
            } else if (frameScoresPlayer1[3] < 0) {
                frame2Score1Player1.setText("/");
            } else if (frameScoresPlayer1[3] == 40) {
                frame2Score1Player1.setText("");
            } else if (frameScoresPlayer1[3] == 0) {
                frame2Score1Player1.setText("-");
            } else {
                frame2Score1Player1.setText(String.format("%d", frameScoresPlayer1[3]));
            }
            if (frameScoresPlayer1[4] == 10) {
                frame2Score2Player1.setText("X");
            } else if (frameScoresPlayer1[4] < 0) {
                frame2Score2Player1.setText("/");
            } else if (frameScoresPlayer1[4] == 40) {
                frame2Score2Player1.setText("");
            } else if (frameScoresPlayer1[4] == 0) {
                frame2Score2Player1.setText("-");
            } else {
                frame2Score2Player1.setText(String.format("%d", frameScoresPlayer1[4]));
            }
            if (frameScoresPlayer1[5] == 10) {
                frame3Score1Player1.setText("X");
            } else if (frameScoresPlayer1[5] < 0) {
                frame3Score1Player1.setText("/");
            } else if (frameScoresPlayer1[5] == 40) {
                frame3Score1Player1.setText("");
            } else if (frameScoresPlayer1[5] == 0) {
                frame3Score1Player1.setText("-");
            } else {
                frame3Score1Player1.setText(String.format("%d", frameScoresPlayer1[5]));
            }
            if (frameScoresPlayer1[6] == 10) {
                frame3Score2Player1.setText("X");
            } else if (frameScoresPlayer1[6] < 0) {
                frame3Score2Player1.setText("/");
            } else if (frameScoresPlayer1[6] == 40) {
                frame3Score2Player1.setText("");
            } else if (frameScoresPlayer1[6] == 0) {
                frame3Score2Player1.setText("-");
            } else {
                frame3Score2Player1.setText(String.format("%d", frameScoresPlayer1[6]));
            }
            if (frameScoresPlayer1[7] == 10) {
                frame4Score1Player1.setText("X");
            } else if (frameScoresPlayer1[7] < 0) {
                frame4Score1Player1.setText("/");
            } else if (frameScoresPlayer1[7] == 40) {
                frame4Score1Player1.setText("");
            } else if (frameScoresPlayer1[7] == 0) {
                frame4Score1Player1.setText("-");
            } else {
                frame4Score1Player1.setText(String.format("%d", frameScoresPlayer1[7]));
            }
            if (frameScoresPlayer1[8] == 10) {
                frame4Score2Player1.setText("X");
            } else if (frameScoresPlayer1[8] < 0) {
                frame4Score2Player1.setText("/");
            } else if (frameScoresPlayer1[8] == 40) {
                frame4Score2Player1.setText("");
            } else if (frameScoresPlayer1[8] == 0) {
                frame4Score2Player1.setText("-");
            } else {
                frame4Score2Player1.setText(String.format("%d", frameScoresPlayer1[8]));
            }
            if (frameScoresPlayer1[9] == 10) {
                frame5Score1Player1.setText("X");
            } else if (frameScoresPlayer1[9] < 0) {
                frame5Score1Player1.setText("/");
            } else if (frameScoresPlayer1[9] == 40) {
                frame5Score1Player1.setText("");
            } else if (frameScoresPlayer1[9] == 0) {
                frame5Score1Player1.setText("-");
            } else {
                frame5Score1Player1.setText(String.format("%d", frameScoresPlayer1[9]));
            }
            if (frameScoresPlayer1[10] == 10) {
                frame5Score2Player1.setText("X");
            } else if (frameScoresPlayer1[10] < 0) {
                frame5Score2Player1.setText("/");
            } else if (frameScoresPlayer1[10] == 40) {
                frame5Score2Player1.setText("");
            } else if (frameScoresPlayer1[10] == 0) {
                frame5Score2Player1.setText("-");
            } else {
                frame5Score2Player1.setText(String.format("%d", frameScoresPlayer1[10]));
            }
            if (frameScoresPlayer1[11] == 10) {
                frame6Score1Player1.setText("X");
            } else if (frameScoresPlayer1[11] < 0) {
                frame6Score1Player1.setText("/");
            } else if (frameScoresPlayer1[11] == 40) {
                frame6Score1Player1.setText("");
            } else if (frameScoresPlayer1[11] == 0) {
                frame6Score1Player1.setText("-");
            } else {
                frame6Score1Player1.setText(String.format("%d", frameScoresPlayer1[11]));
            }
            if (frameScoresPlayer1[12] == 10) {
                frame6Score2Player1.setText("X");
            } else if (frameScoresPlayer1[12] < 0) {
                frame6Score2Player1.setText("/");
            } else if (frameScoresPlayer1[12] == 40) {
                frame6Score2Player1.setText("");
            } else if (frameScoresPlayer1[12] == 0) {
                frame6Score2Player1.setText("-");
            } else {
                frame6Score2Player1.setText(String.format("%d", frameScoresPlayer1[12]));
            }
            if (frameScoresPlayer1[13] == 10) {
                frame7Score1Player1.setText("X");
            } else if (frameScoresPlayer1[13] < 0) {
                frame7Score1Player1.setText("/");
            } else if (frameScoresPlayer1[13] == 40) {
                frame7Score1Player1.setText("");
            } else if (frameScoresPlayer1[13] == 0) {
                frame7Score1Player1.setText("-");
            } else {
                frame7Score1Player1.setText(String.format("%d", frameScoresPlayer1[13]));
            }
            if (frameScoresPlayer1[14] == 10) {
                frame7Score2Player1.setText("X");
            } else if (frameScoresPlayer1[14] < 0) {
                frame7Score2Player1.setText("/");
            } else if (frameScoresPlayer1[14] == 40) {
                frame7Score2Player1.setText("");
            } else if (frameScoresPlayer1[14] == 0) {
                frame7Score2Player1.setText("-");
            } else {
                frame7Score2Player1.setText(String.format("%d", frameScoresPlayer1[14]));
            }
            if (frameScoresPlayer1[15] == 10) {
                frame8Score1Player1.setText("X");
            } else if (frameScoresPlayer1[15] < 0) {
                frame8Score1Player1.setText("/");
            } else if (frameScoresPlayer1[15] == 40) {
                frame8Score1Player1.setText("");
            } else if (frameScoresPlayer1[15] == 0) {
                frame8Score1Player1.setText("-");
            } else {
                frame8Score1Player1.setText(String.format("%d", frameScoresPlayer1[15]));
            }
            if (frameScoresPlayer1[16] == 10) {
                frame8Score2Player1.setText("X");
            } else if (frameScoresPlayer1[16] < 0) {
                frame8Score2Player1.setText("/");
            } else if (frameScoresPlayer1[16] == 40) {
                frame8Score2Player1.setText("");
            } else if (frameScoresPlayer1[16] == 0) {
                frame8Score2Player1.setText("-");
            } else {
                frame8Score2Player1.setText(String.format("%d", frameScoresPlayer1[16]));
            }
            if (frameScoresPlayer1[17] == 10) {
                frame9Score1Player1.setText("X");
            } else if (frameScoresPlayer1[17] < 0) {
                frame9Score1Player1.setText("/");
            } else if (frameScoresPlayer1[17] == 40) {
                frame9Score1Player1.setText("");
            } else if (frameScoresPlayer1[17] == 0) {
                frame9Score1Player1.setText("-");
            } else {
                frame9Score1Player1.setText(String.format("%d", frameScoresPlayer1[17]));
            }
            if (frameScoresPlayer1[18] == 10) {
                frame9Score2Player1.setText("X");
            } else if (frameScoresPlayer1[18] < 0) {
                frame9Score2Player1.setText("/");
            } else if (frameScoresPlayer1[18] == 40) {
                frame9Score2Player1.setText("");
            } else if (frameScoresPlayer1[18] == 0) {
                frame9Score2Player1.setText("-");
            } else {
                frame9Score2Player1.setText(String.format("%d", frameScoresPlayer1[18]));
            }
            if (frameScoresPlayer1[19] == 10) {
                frame10Score1Player1.setText("X");
            } else if (frameScoresPlayer1[19] < 0) {
                frame10Score1Player1.setText("/");
            } else if (frameScoresPlayer1[19] == 40) {
                frame10Score1Player1.setText("");
            } else if (frameScoresPlayer1[19] == 0) {
                frame10Score1Player1.setText("-");
            } else {
                frame10Score1Player1.setText(String.format("%d", frameScoresPlayer1[19]));
            }
            if (frameScoresPlayer1[20] == 10) {
                frame10Score2Player1.setText("X");
            } else if (frameScoresPlayer1[20] < 0) {
                frame10Score2Player1.setText("/");
            } else if (frameScoresPlayer1[20] == 40) {
                frame10Score2Player1.setText("");
            } else if (frameScoresPlayer1[20] == 0) {
                frame10Score2Player1.setText("-");
            } else {
                frame10Score2Player1.setText(String.format("%d", frameScoresPlayer1[20]));
            }
            if (frameScoresPlayer1[21] == 10) {
                frame10Score3Player1.setText("X");
            } else if (frameScoresPlayer1[21] < 0) {
                frame10Score3Player1.setText("/");
            } else if (frameScoresPlayer1[21] == 40) {
                frame10Score3Player1.setText("");
            } else if (frameScoresPlayer1[21] == 0) {
                frame10Score3Player1.setText("-");
            } else {
                frame10Score3Player1.setText(String.format("%d", frameScoresPlayer1[21]));
            }
            frame1TotalScorePlayer1.setText(String.format("%d", frameTotalScoresPlayer1[1]));
            frame2TotalScorePlayer1.setText(String.format("%d", frameTotalScoresPlayer1[2]));
            frame3TotalScorePlayer1.setText(String.format("%d", frameTotalScoresPlayer1[3]));
            frame4TotalScorePlayer1.setText(String.format("%d", frameTotalScoresPlayer1[4]));
            frame5TotalScorePlayer1.setText(String.format("%d", frameTotalScoresPlayer1[5]));
            frame6TotalScorePlayer1.setText(String.format("%d", frameTotalScoresPlayer1[6]));
            frame7TotalScorePlayer1.setText(String.format("%d", frameTotalScoresPlayer1[7]));
            frame8TotalScorePlayer1.setText(String.format("%d", frameTotalScoresPlayer1[8]));
            frame9TotalScorePlayer1.setText(String.format("%d", frameTotalScoresPlayer1[9]));
            frame10TotalScorePlayer1.setText(String.format("%d", frameTotalScoresPlayer1[10]));
            totalScorePlayer1.setText(String.format("%d", tScorePlayer1));

        } else {
            if (frameScoresPlayer2[1] == 10) {
                frame1Score1Player2.setText("X");
            } else if (frameScoresPlayer2[1] < 0) {
                frame1Score1Player2.setText("/");
            } else if (frameScoresPlayer2[1] == 40) {
                frame1Score1Player2.setText("");
            } else if (frameScoresPlayer2[1] == 0) {
                frame1Score1Player2.setText("-");
            } else {
                frame1Score1Player2.setText(String.format("%d", frameScoresPlayer2[1]));
            }
            if (frameScoresPlayer2[2] == 10) {
                frame1Score2Player2.setText("X");
            } else if (frameScoresPlayer2[2] < 0) {
                frame1Score2Player2.setText("/");
            } else if (frameScoresPlayer2[2] == 40) {
                frame1Score2Player2.setText("");
            } else if (frameScoresPlayer2[2] == 0) {
                frame1Score2Player2.setText("-");
            } else {
                frame1Score2Player2.setText(String.format("%d", frameScoresPlayer2[2]));
            }
            if (frameScoresPlayer2[3] == 10) {
                frame2Score1Player2.setText("X");
            } else if (frameScoresPlayer2[3] < 0) {
                frame2Score1Player2.setText("/");
            } else if (frameScoresPlayer2[3] == 40) {
                frame2Score1Player2.setText("");
            } else if (frameScoresPlayer2[3] == 0) {
                frame2Score1Player2.setText("-");
            } else {
                frame2Score1Player2.setText(String.format("%d", frameScoresPlayer2[3]));
            }
            if (frameScoresPlayer2[4] == 10) {
                frame2Score2Player2.setText("X");
            } else if (frameScoresPlayer2[4] < 0) {
                frame2Score2Player2.setText("/");
            } else if (frameScoresPlayer2[4] == 40) {
                frame2Score2Player2.setText("");
            } else if (frameScoresPlayer2[4] == 0) {
                frame2Score2Player2.setText("-");
            } else {
                frame2Score2Player2.setText(String.format("%d", frameScoresPlayer2[4]));
            }
            if (frameScoresPlayer2[5] == 10) {
                frame3Score1Player2.setText("X");
            } else if (frameScoresPlayer2[5] < 0) {
                frame3Score1Player2.setText("/");
            } else if (frameScoresPlayer2[5] == 40) {
                frame3Score1Player2.setText("");
            } else if (frameScoresPlayer2[5] == 0) {
                frame3Score1Player2.setText("-");
            } else {
                frame3Score1Player2.setText(String.format("%d", frameScoresPlayer2[5]));
            }
            if (frameScoresPlayer2[6] == 10) {
                frame3Score2Player2.setText("X");
            } else if (frameScoresPlayer2[6] < 0) {
                frame3Score2Player2.setText("/");
            } else if (frameScoresPlayer2[6] == 40) {
                frame3Score2Player2.setText("");
            } else if (frameScoresPlayer2[6] == 0) {
                frame3Score2Player2.setText("-");
            } else {
                frame3Score2Player2.setText(String.format("%d", frameScoresPlayer2[6]));
            }
            if (frameScoresPlayer2[7] == 10) {
                frame4Score1Player2.setText("X");
            } else if (frameScoresPlayer2[7] < 0) {
                frame4Score1Player2.setText("/");
            } else if (frameScoresPlayer2[7] == 40) {
                frame4Score1Player2.setText("");
            } else if (frameScoresPlayer2[7] == 0) {
                frame4Score1Player2.setText("-");
            } else {
                frame4Score1Player2.setText(String.format("%d", frameScoresPlayer2[7]));
            }
            if (frameScoresPlayer2[8] == 10) {
                frame4Score2Player2.setText("X");
            } else if (frameScoresPlayer2[8] < 0) {
                frame4Score2Player2.setText("/");
            } else if (frameScoresPlayer2[8] == 40) {
                frame4Score2Player2.setText("");
            } else if (frameScoresPlayer2[8] == 0) {
                frame4Score2Player2.setText("-");
            } else {
                frame4Score2Player2.setText(String.format("%d", frameScoresPlayer2[8]));
            }
            if (frameScoresPlayer2[9] == 10) {
                frame5Score1Player2.setText("X");
            } else if (frameScoresPlayer2[9] < 0) {
                frame5Score1Player2.setText("/");
            } else if (frameScoresPlayer2[9] == 40) {
                frame5Score1Player2.setText("");
            } else if (frameScoresPlayer2[9] == 0) {
                frame5Score1Player2.setText("-");
            } else {
                frame5Score1Player2.setText(String.format("%d", frameScoresPlayer2[9]));
            }
            if (frameScoresPlayer2[10] == 10) {
                frame5Score2Player2.setText("X");
            } else if (frameScoresPlayer2[10] < 0) {
                frame5Score2Player2.setText("/");
            } else if (frameScoresPlayer2[10] == 40) {
                frame5Score2Player2.setText("");
            } else if (frameScoresPlayer2[10] == 0) {
                frame5Score2Player2.setText("-");
            } else {
                frame5Score2Player2.setText(String.format("%d", frameScoresPlayer2[10]));
            }
            if (frameScoresPlayer2[11] == 10) {
                frame6Score1Player2.setText("X");
            } else if (frameScoresPlayer2[11] < 0) {
                frame6Score1Player2.setText("/");
            } else if (frameScoresPlayer2[11] == 40) {
                frame6Score1Player2.setText("");
            } else if (frameScoresPlayer2[11] == 0) {
                frame6Score1Player2.setText("-");
            } else {
                frame6Score1Player2.setText(String.format("%d", frameScoresPlayer2[11]));
            }
            if (frameScoresPlayer2[12] == 10) {
                frame6Score2Player2.setText("X");
            } else if (frameScoresPlayer2[12] < 0) {
                frame6Score2Player2.setText("/");
            } else if (frameScoresPlayer2[12] == 40) {
                frame6Score2Player2.setText("");
            } else if (frameScoresPlayer2[12] == 0) {
                frame6Score2Player2.setText("-");
            } else {
                frame6Score2Player2.setText(String.format("%d", frameScoresPlayer2[12]));
            }
            if (frameScoresPlayer2[13] == 10) {
                frame7Score1Player2.setText("X");
            } else if (frameScoresPlayer2[13] < 0) {
                frame7Score1Player2.setText("/");
            } else if (frameScoresPlayer2[13] == 40) {
                frame7Score1Player2.setText("");
            } else if (frameScoresPlayer2[13] == 0) {
                frame7Score1Player2.setText("-");
            } else {
                frame7Score1Player2.setText(String.format("%d", frameScoresPlayer2[13]));
            }
            if (frameScoresPlayer2[14] == 10) {
                frame7Score2Player2.setText("X");
            } else if (frameScoresPlayer2[14] < 0) {
                frame7Score2Player2.setText("/");
            } else if (frameScoresPlayer2[14] == 40) {
                frame7Score2Player2.setText("");
            } else if (frameScoresPlayer2[14] == 0) {
                frame7Score2Player2.setText("-");
            } else {
                frame7Score2Player2.setText(String.format("%d", frameScoresPlayer2[14]));
            }
            if (frameScoresPlayer2[15] == 10) {
                frame8Score1Player2.setText("X");
            } else if (frameScoresPlayer2[15] < 0) {
                frame8Score1Player2.setText("/");
            } else if (frameScoresPlayer2[15] == 40) {
                frame8Score1Player2.setText("");
            } else if (frameScoresPlayer2[15] == 0) {
                frame8Score1Player2.setText("-");
            } else {
                frame8Score1Player2.setText(String.format("%d", frameScoresPlayer2[15]));
            }
            if (frameScoresPlayer2[16] == 10) {
                frame8Score2Player2.setText("X");
            } else if (frameScoresPlayer2[16] < 0) {
                frame8Score2Player2.setText("/");
            } else if (frameScoresPlayer2[16] == 40) {
                frame8Score2Player2.setText("");
            } else if (frameScoresPlayer2[16] == 0) {
                frame8Score2Player2.setText("-");
            } else {
                frame8Score2Player2.setText(String.format("%d", frameScoresPlayer2[16]));
            }
            if (frameScoresPlayer2[17] == 10) {
                frame9Score1Player2.setText("X");
            } else if (frameScoresPlayer2[17] < 0) {
                frame9Score1Player2.setText("/");
            } else if (frameScoresPlayer2[17] == 40) {
                frame9Score1Player2.setText("");
            } else if (frameScoresPlayer2[17] == 0) {
                frame9Score1Player2.setText("-");
            } else {
                frame9Score1Player2.setText(String.format("%d", frameScoresPlayer2[17]));
            }
            if (frameScoresPlayer2[18] == 10) {
                frame9Score2Player2.setText("X");
            } else if (frameScoresPlayer2[18] < 0) {
                frame9Score2Player2.setText("/");
            } else if (frameScoresPlayer2[18] == 40) {
                frame9Score2Player2.setText("");
            } else if (frameScoresPlayer2[18] == 0) {
                frame9Score2Player2.setText("-");
            } else {
                frame9Score2Player2.setText(String.format("%d", frameScoresPlayer2[18]));
            }
            if (frameScoresPlayer2[19] == 10) {
                frame10Score1Player2.setText("X");
            } else if (frameScoresPlayer2[19] < 0) {
                frame10Score1Player2.setText("/");
            } else if (frameScoresPlayer2[19] == 40) {
                frame10Score1Player2.setText("");
            } else if (frameScoresPlayer2[19] == 0) {
                frame10Score1Player2.setText("-");
            } else {
                frame10Score1Player2.setText(String.format("%d", frameScoresPlayer2[19]));
            }
            if (frameScoresPlayer2[20] == 10) {
                frame10Score2Player2.setText("X");
            } else if (frameScoresPlayer2[20] < 0) {
                frame10Score2Player2.setText("/");
            } else if (frameScoresPlayer2[20] == 40) {
                frame10Score2Player2.setText("");
            } else if (frameScoresPlayer2[20] == 0) {
                frame10Score2Player2.setText("-");
            } else {
                frame10Score2Player2.setText(String.format("%d", frameScoresPlayer2[20]));
            }
            if (frameScoresPlayer2[21] == 10) {
                frame10Score3Player2.setText("X");
            } else if (frameScoresPlayer2[21] < 0) {
                frame10Score3Player2.setText("/");
            } else if (frameScoresPlayer2[21] == 40) {
                frame10Score3Player2.setText("");
            } else if (frameScoresPlayer2[21] == 0) {
                frame10Score3Player2.setText("-");
            } else {
                frame10Score3Player2.setText(String.format("%d", frameScoresPlayer2[21]));
            }
            frame1TotalScorePlayer2.setText(String.format("%d", frameTotalScoresPlayer2[1]));
            frame2TotalScorePlayer2.setText(String.format("%d", frameTotalScoresPlayer2[2]));
            frame3TotalScorePlayer2.setText(String.format("%d", frameTotalScoresPlayer2[3]));
            frame4TotalScorePlayer2.setText(String.format("%d", frameTotalScoresPlayer2[4]));
            frame5TotalScorePlayer2.setText(String.format("%d", frameTotalScoresPlayer2[5]));
            frame6TotalScorePlayer2.setText(String.format("%d", frameTotalScoresPlayer2[6]));
            frame7TotalScorePlayer2.setText(String.format("%d", frameTotalScoresPlayer2[7]));
            frame8TotalScorePlayer2.setText(String.format("%d", frameTotalScoresPlayer2[8]));
            frame9TotalScorePlayer2.setText(String.format("%d", frameTotalScoresPlayer2[9]));
            frame10TotalScorePlayer2.setText(String.format("%d", frameTotalScoresPlayer2[10]));

            totalScorePlayer2.setText(String.format("%d", tScorePlayer2));
        }
    }

    // increment the drawable vector to show number of downed pins
    public void plusDownedPin(View view) {
        if (downedPinsPointer < maxPins) {
            downedPinsPointer++;
        }

        updateDownedPins();

    }

    // decrement the drawable vector to show number of downed pins
    public void minusDownedPin(View view) {
        if (downedPinsPointer > 0) {
            downedPinsPointer--;
        } else if (downedPinsPointer == -1) {
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
    // stop if strike, store spare as negative number
    public void submitScore(View view) {
        // exit out if player hasn't chosen a score before pressing the button
        if (downedPinsPointer < 0) {
            return;
        }

        // for last frame process three scores instead of two, but only if first two scores sum 10+
        if (frameNumber == 10) {

            if (!frameEnd && !extraScore) {
                if (activePlayer == 1) {
                    frameScoresPlayer1[frameNumber * 2 - 1] = downedPinsPointer;
                } else {
                    frameScoresPlayer2[frameNumber * 2 - 1] = downedPinsPointer;
                }
                if (downedPinsPointer < 10) {
                    maxPins = 10 - downedPinsPointer;
                }
                downedPinsPointer = maxPins;
                updateDownedPins();
                frameEnd = true;
                calculateScore();

            } else if (frameEnd && !extraScore) {
                if (activePlayer == 1) {
                    if (frameScoresPlayer1[frameNumber * 2 - 1] + downedPinsPointer >= 10) {
                        extraScore = true;
                        frameScoresPlayer1[frameNumber * 2] = downedPinsPointer;
                        maxPins = 10;
                        frameEnd = false;
                        calculateScore();
                    } else {
                        frameScoresPlayer1[frameNumber * 2] = downedPinsPointer;
                        frameScoresPlayer1[frameNumber * 2 + 1] = 0;
                        maxPins = 10;
                        frameEnd = false;
                        calculateScore();
                        activePlayer();
                    }
                } else {
                    if (frameScoresPlayer2[frameNumber * 2 - 1] + downedPinsPointer >= 10) {
                        extraScore = true;
                        frameScoresPlayer2[frameNumber * 2] = downedPinsPointer;
                        maxPins = 10;
                        frameEnd = false;
                        calculateScore();
                    } else {
                        frameScoresPlayer2[frameNumber * 2] = downedPinsPointer;
                        frameScoresPlayer2[frameNumber * 2 + 1] = 0;
                        maxPins = 10;
                        frameEnd = false;
                        calculateScore();
                        gameEnd();
                    }
                }
            }

            // add third shot per player if applicable
            else if (extraScore && !frameEnd) {
                if (activePlayer == 1) {
                    frameScoresPlayer1[frameNumber * 2 + 1] = downedPinsPointer;
                    extraScore = false;
                    calculateScore();
                    activePlayer();
                } else {
                    frameScoresPlayer2[frameNumber * 2 + 1] = downedPinsPointer;
                    extraScore = false;
                    calculateScore();
                    gameEnd();
                }
            }
        }

        // score for frames 1-9
        else {

            //process strike
            if (downedPinsPointer == 10 && !frameEnd) {
                if (activePlayer == 1) {
                    frameScoresPlayer1[frameNumber * 2 - 1] = downedPinsPointer;
                    frameScoresPlayer1[frameNumber * 2] = 40;
                    calculateScore();
                    activePlayer();
                } else {
                    frameScoresPlayer2[frameNumber * 2 - 1] = downedPinsPointer;
                    frameScoresPlayer2[frameNumber * 2] = 40;
                    calculateScore();
                    nextFrame();
                    activePlayer();
                }
            }

            //if not strike
            else if (!frameEnd) {
                if (activePlayer == 1) {
                    frameScoresPlayer1[frameNumber * 2 - 1] = downedPinsPointer;
                } else {
                    frameScoresPlayer2[frameNumber * 2 - 1] = downedPinsPointer;
                }
                maxPins = 10 - downedPinsPointer;
                downedPinsPointer = maxPins;
                updateDownedPins();
                frameEnd = true;
                calculateScore();

            } else if (frameEnd) {
                if (activePlayer == 1) {
                    if (frameScoresPlayer1[frameNumber * 2 - 1] + downedPinsPointer == 10) {
                        frameScoresPlayer1[frameNumber * 2] = -downedPinsPointer;
                        maxPins = 10;
                        frameEnd = false;
                        calculateScore();
                        activePlayer();

                    } else {
                        frameScoresPlayer1[frameNumber * 2] = downedPinsPointer;
                        maxPins = 10;
                        frameEnd = false;
                        calculateScore();
                        activePlayer();
                    }
                } else {
                    if (frameScoresPlayer2[frameNumber * 2 - 1] + downedPinsPointer == 10) {
                        frameScoresPlayer2[frameNumber * 2] = -downedPinsPointer;
                        maxPins = 10;
                        frameEnd = false;
                        calculateScore();
                        activePlayer();
                        nextFrame();
                    } else {
                        frameScoresPlayer2[frameNumber * 2] = downedPinsPointer;
                        maxPins = 10;
                        frameEnd = false;
                        calculateScore();
                        activePlayer();
                        nextFrame();
                    }
                }
            }

        }
    }

    // move to next frame
    private void nextFrame() {
        if (frameNumber < 10) {
            frameNumber++;
        }
    }

    // process end of game
    private void gameEnd() {
        //disable submit button
        ImageView image = findViewById(R.id.submit);
        image.setClickable(false);

        //disable pin +/- buttons
        ImageView image2 = findViewById(R.id.minus);
        image2.setClickable(false);
        ImageView image3 = findViewById(R.id.plus);
        image3.setClickable(false);

        //hide active player icon
        activePlayer1.setVisibility(activePlayer1.INVISIBLE);
        activePlayer2.setVisibility(activePlayer2.INVISIBLE);

        // use pin selection ImageView to display winner
        if (tScorePlayer1 > tScorePlayer2) {
            Drawable player1Win = getResources().getDrawable(R.drawable.playeronewin);
            imageViewDownedPins.setImageDrawable(player1Win);
        } else if (tScorePlayer2 > tScorePlayer1) {
            Drawable player2Win = getResources().getDrawable(R.drawable.playertwowin);
            imageViewDownedPins.setImageDrawable(player2Win);
        } else {
            Drawable draw = getResources().getDrawable(R.drawable.draw);
            imageViewDownedPins.setImageDrawable(draw);
        }
    }

    // recursively calculate score for each frame, taking into account strikes and spares
    private void calculateScore() {
        // declaring work variables; k is the score pointer, l is the frame pointer,
        // x is a placeholder to decode scores
        int k;
        int l = frameNumber;
        int x;
        int lastScore;
        int strikeScore;

        // test for active player, so we don't update all scores needlessly
        if (activePlayer == 1) {
            frameTotalScoresPlayer1 = new int[11];

            // process frame 10 first, if it is the current frame
            if (l == 10) {
                k = l * 2 - 2;

                // 1. first process frame 10 scores, since there are no special rules
                frameTotalScoresPlayer1[l] = frameScoresPlayer1[k + 1] + frameScoresPlayer1[k + 2] + frameScoresPlayer1[k + 3];

                // 2. then just use the recursive for the rest of the frames
                while (k > 0) {
                    // add "future" scores for strike and spare calculation and decode
                    lastScore = frameScoresPlayer1[k + k % 2 + 1];
                    if (lastScore == 40) {
                        lastScore = 0;
                    } else if (lastScore < 0) {
                        lastScore = Math.abs(lastScore);
                    }
                    strikeScore = frameScoresPlayer1[k + k % 2 + 2];
                    if (strikeScore == 40) {
                        strikeScore = frameScoresPlayer1[k + k % 2 + 3];
                    } else if (strikeScore < 0) {
                        strikeScore = Math.abs(strikeScore);
                    }

                    // decode scores and add strike or spare scores
                    x = frameScoresPlayer1[k];
                    if (x == 40) {
                        x = 0;
                    } else if (x < 0) {
                        x = Math.abs(x);
                        x += lastScore;
                    } else if (x == 10) {
                        x += lastScore;
                        x += strikeScore;
                    }

                    frameTotalScoresPlayer1[l] += x;
                    k--;
                }

                // 3. then decrease current frame and process frames 1-9 as usual
                l--;
            }

            // calculate scores for current frame and those before it
            while (l > 0) {

                k = l * 2;

                while (k > 0) {
                    // add "future" scores for strike and spare calculation and decode
                    lastScore = frameScoresPlayer1[k + k % 2 + 1];
                    if (lastScore == 40) {
                        lastScore = 0;
                    } else if (lastScore < 0) {
                        lastScore = Math.abs(lastScore);
                    }
                    strikeScore = frameScoresPlayer1[k + k % 2 + 2];
                    if (strikeScore == 40) {
                        strikeScore = frameScoresPlayer1[k + k % 2 + 3];
                    } else if (strikeScore < 0) {
                        strikeScore = Math.abs(strikeScore);
                    }

                    // decode scores and add strike or spare scores
                    x = frameScoresPlayer1[k];
                    if (x == 40) {
                        x = 0;
                    } else if (x < 0) {
                        x = Math.abs(x);
                        x += lastScore;
                    } else if (x == 10) {
                        x += lastScore;
                        x += strikeScore;
                    }

                    frameTotalScoresPlayer1[l] += x;
                    k--;
                }

                l--;
            }
            tScorePlayer1 = frameTotalScoresPlayer1[frameNumber];

            // logic for second player
        } else {
            frameTotalScoresPlayer2 = new int[11];

            // 0. process frame 10 first, if it is the current frame
            if (l == 10) {
                k = l * 2 - 2;

                // 1. first process frame 10 scores, since there are no special rules
                frameTotalScoresPlayer2[l] = frameScoresPlayer2[k + 1] + frameScoresPlayer2[k + 2] + frameScoresPlayer2[k + 3];

                // 2. then just use the recursive for the rest of the frames
                while (k > 0) {
                    // add "future" scores for strike and spare calculation and decode
                    lastScore = frameScoresPlayer2[k + k % 2 + 1];
                    if (lastScore == 40) {
                        lastScore = 0;
                    } else if (lastScore < 0) {
                        lastScore = Math.abs(lastScore);
                    }
                    strikeScore = frameScoresPlayer2[k + k % 2 + 2];
                    if (strikeScore == 40) {
                        strikeScore = frameScoresPlayer2[k + k % 2 + 3];
                    } else if (strikeScore < 0) {
                        strikeScore = Math.abs(strikeScore);
                    }

                    // decode scores and add strike or spare scores
                    x = frameScoresPlayer2[k];
                    if (x == 40) {
                        x = 0;
                    } else if (x < 0) {
                        x = Math.abs(x);
                        x += lastScore;
                    } else if (x == 10) {
                        x += lastScore;
                        x += strikeScore;
                    }

                    frameTotalScoresPlayer2[l] += x;
                    k--;
                }

                // 3. then decrease current frame and process frames 1-9 as usual
                l--;
            }

            // calculate scores for current frame and those before it
            while (l > 0) {

                k = l * 2;

                while (k > 0) {
                    // add "future" scores for strike and spare calculation and decode
                    lastScore = frameScoresPlayer2[k + k % 2 + 1];
                    if (lastScore == 40) {
                        lastScore = 0;
                    } else if (lastScore < 0) {
                        lastScore = Math.abs(lastScore);
                    }
                    strikeScore = frameScoresPlayer2[k + k % 2 + 2];
                    if (strikeScore == 40) {
                        strikeScore = frameScoresPlayer2[k + k % 2 + 3];
                    } else if (strikeScore < 0) {
                        strikeScore = Math.abs(strikeScore);
                    }

                    // decode scores and add strike or spare scores
                    x = frameScoresPlayer2[k];
                    if (x == 40) {
                        x = 0;
                    } else if (x < 0) {
                        x = Math.abs(x);
                        x += lastScore;
                    } else if (x == 10) {
                        x += lastScore;
                        x += strikeScore;
                    }

                    frameTotalScoresPlayer2[l] += x;
                    k--;
                }

                l--;
            }
            tScorePlayer2 = frameTotalScoresPlayer2[frameNumber];
        }

        // trigger visual score update
        updateScores();
    }

    // change active player and icon

    private void activePlayer() {
        if (activePlayer == 1) {
            activePlayer = 2;
            activePlayer1.setVisibility(activePlayer1.INVISIBLE);
            activePlayer2.setVisibility(activePlayer2.VISIBLE);
        } else if (activePlayer == 2) {
            activePlayer = 1;
            activePlayer1.setVisibility(activePlayer1.VISIBLE);
            activePlayer2.setVisibility(activePlayer2.INVISIBLE);
        }
    }

    // reset the game
    public void resetGame(View v) {

        // reset all scores and active player icon
        frameScoresPlayer1 = new int[22];
        frameScoresPlayer2 = new int[22];
        frameTotalScoresPlayer1 = new int[11];
        frameTotalScoresPlayer2 = new int[11];
        tScorePlayer1 = 0;
        tScorePlayer2 = 0;
        activePlayer = 2;
        updateScores();
        activePlayer();
        updateScores();

        // reset relevant variables
        downedPinsPointer = -1;
        frameNumber = 1;
        frameEnd = false;
        extraScore = false;
        maxPins = 10;

        // set number of pins ImageView to the instructions
        Drawable instructions = getResources().getDrawable(R.drawable.instructions);
        imageViewDownedPins.setImageDrawable(instructions);

        //reset submit button
        ImageView image = findViewById(R.id.submit);
        image.setClickable(true);

        //reset pin +/- buttons
        ImageView image2 = findViewById(R.id.minus);
        image2.setClickable(true);
        ImageView image3 = findViewById(R.id.plus);
        image3.setClickable(true);

        resetPlayerNameAndEditText(nameOfPlayer1, editNamePlayer1, 1);
        resetPlayerNameAndEditText(nameOfPlayer2, editNamePlayer2, 2);
    }


    //When this method is called we will hide the TextView and show the editText
    //Or vice-versa
    //And update the text on the button
    public void changePlayer1Name(View v) {
        // If the button was pressed and the text view is visible, that means that we should show the
        // edit text, hide the text view and change the button text to "save"
        if (nameOfPlayer1.getVisibility() == View.VISIBLE) {
            nameOfPlayer1.setVisibility(View.GONE);
            editNamePlayer1.setVisibility(View.VISIBLE);
            changePlayer1Name.setText("Save Name");
        }

        // Now if the edit text is visible, that means that we should show the
        // text view, hide the edit text, change the button text to "save" and set
        // the edit text's text as the text view text
        else if (editNamePlayer1.getVisibility() == View.VISIBLE) {
            editNamePlayer1.setVisibility(View.GONE);
            nameOfPlayer1.setVisibility(View.VISIBLE);
            Editable nameOfPlayer = editNamePlayer1.getText();
            if(nameOfPlayer.equals(""))
                resetPlayerNameAndEditText(nameOfPlayer1, editNamePlayer1, 1);
            else
                nameOfPlayer1.setText(nameOfPlayer);

            changePlayer1Name.setText("Change name");
        }
    }

    public void resetPlayerNameAndEditText(TextView playerName, EditText editNamePlayer, int playerNumber){
        playerName.setText("Player " + playerNumber);
        editNamePlayer.setText("Player " + playerName);
    }

    public void changePlayer2Name(View v) {
        // If the button was pressed and the text view is visible, that means that we should show the
        // edit text, hide the text view and change the button text to "save"
        if (nameOfPlayer2.getVisibility() == View.VISIBLE) {
            nameOfPlayer2.setVisibility(View.GONE);
            editNamePlayer2.setVisibility(View.VISIBLE);
            changePlayer2Name.setText("Save Name");
        }

        // Now if the edit text is visible, that means that we should show the
        // text view, hide the edit text, change the button text to "save" and set
        // the edit text's text as the text view text
        else if (editNamePlayer2.getVisibility() == View.VISIBLE) {
            editNamePlayer2.setVisibility(View.GONE);
            nameOfPlayer2.setVisibility(View.VISIBLE);
            Editable nameOfPlayer = editNamePlayer2.getText();
            if(nameOfPlayer.equals(""))
                resetPlayerNameAndEditText(nameOfPlayer2, editNamePlayer2, 2);
            else
                nameOfPlayer2.setText(nameOfPlayer);

            changePlayer2Name.setText("Change name");
        }
    }
}
