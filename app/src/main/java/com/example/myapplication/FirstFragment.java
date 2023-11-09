package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class FirstFragment extends AppCompatActivity {

    private int randomNumber;
    private EditText guessEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_first);

        guessEditText = findViewById(R.id.editTextGuess);
        resultTextView = findViewById(R.id.textViewResult);
        Button guessButton = findViewById(R.id.buttonGuess);

        // Генерация случайного числа от 1 до 100
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1;

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkGuess();
            }
        });
    }

    private void checkGuess() {
        String guessText = guessEditText.getText().toString();

        if (!guessText.isEmpty()) {
            int userGuess = Integer.parseInt(guessText);

            if (userGuess > 0 && userGuess <= 100) {
                if (userGuess == randomNumber) {
                    displayMessage("Поздравляем! Вы угадали число!");
                } else {
                    String message = "Неверно. Попробуйте " + (userGuess < randomNumber ? "больше" : "меньше");
                    displayMessage(message);
                }
            } else {
                displayMessage("Введите число от 1 до 100");
            }
        } else {
            displayMessage("Введите число");
        }
    }

    private void displayMessage(String message) {
        resultTextView.setText(message);
    }
}
