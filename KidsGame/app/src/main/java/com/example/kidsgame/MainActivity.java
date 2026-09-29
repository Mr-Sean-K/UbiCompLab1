package com.example.kidsgame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView gameTitle;
    TextView guessCountDisp;
    EditText guess;
    int guessCount;
    int answer;
    int userGuess;
    Button submitGuess;
    Button restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        gameTitle = findViewById(R.id.gameTitle);
        guessCountDisp = findViewById(R.id.guessCountDisp);
        guess = findViewById(R.id.guess);
        submitGuess = findViewById(R.id.submitGuess);
        restart = findViewById(R.id.restart);

        gameStart(findViewById(R.id.main));
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void gameStart(View view){
        answer = (int) (Math.random() * 31);
        guessCount = 0;
        gameTitle.setText("Guess the Number! I will think of a number between 1 and 30 and you try to guess it below!");
        guessCountDisp.setText("Guess Count: " + guessCount);
        guess.setText("");
    }

    public void gameRunning(View view){
        userGuess = Integer.parseInt(guess.getText().toString());

        if (userGuess == answer) {
            gameTitle.setText("Correct!");
        } else if (userGuess > answer) {
            gameTitle.setText("Too High!");
            guessCount++;
            guessCountDisp.setText("Guess Count: " + guessCount);
        } else if (userGuess < answer) {
            gameTitle.setText("Too Low!");
            guessCount++;
            guessCountDisp.setText("Guess Count: " + guessCount);
        }
    }
}
