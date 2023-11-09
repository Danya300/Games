package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class SecondFragment extends AppCompatActivity {

    private ImageView playerChoiceImageView, computerChoiceImageView;
    private TextView resultTextView;

    private static final int ROCK = 0;
    private static final int PAPER = 1;
    private static final int SCISSORS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_second);

        playerChoiceImageView = findViewById(R.id.imageViewPlayerChoice);
        computerChoiceImageView = findViewById(R.id.imageViewComputerChoice);
        resultTextView = findViewById(R.id.textViewResult);

        Button rockButton = findViewById(R.id.buttonRock);
        Button paperButton = findViewById(R.id.buttonPaper);
        Button scissorsButton = findViewById(R.id.buttonScissors);

        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playGame(ROCK);
            }
        });

        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playGame(PAPER);
            }
        });

        scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playGame(SCISSORS);
            }
        });
    }

    private void playGame(int playerChoice) {
        int computerChoice = generateComputerChoice();

        setChoiceImage(playerChoiceImageView, playerChoice);
        setChoiceImage(computerChoiceImageView, computerChoice);

        int result = determineWinner(playerChoice, computerChoice);
        displayResult(result);
    }

    private int generateComputerChoice() {
        Random random = new Random();
        return random.nextInt(3); // 0 for Rock, 1 for Paper, 2 for Scissors
    }

    private void setChoiceImage(ImageView imageView, int choice) {
        switch (choice) {
            case ROCK:
                imageView.setImageResource(R.drawable.rock); // Замените "rock" на имя вашего изображения для камня
                break;
            case PAPER:
                imageView.setImageResource(R.drawable.paper); // Замените "paper" на имя вашего изображения для бумаги
                break;
            case SCISSORS:
                imageView.setImageResource(R.drawable.scissors); // Замените "scissors" на имя вашего изображения для ножниц
                break;
        }
    }

    private int determineWinner(int playerChoice, int computerChoice) {
        if (playerChoice == computerChoice) {
            return 0; // Draw
        } else if ((playerChoice == ROCK && computerChoice == SCISSORS) ||
                (playerChoice == PAPER && computerChoice == ROCK) ||
                (playerChoice == SCISSORS && computerChoice == PAPER)) {
            return 1; // Player wins
        } else {
            return -1; // Computer wins
        }
    }

    private void displayResult(int result) {
        if (result == 0) {
            resultTextView.setText("Ничья!");
        } else if (result == 1) {
            resultTextView.setText("Вы победили!");
        } else {
            resultTextView.setText("Компьютер победил!");
        }
    }
}
