package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        // Находим кнопки
        findViewById(R.id.button_guess_number).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Обработчик для кнопки 1
                Intent intent = new Intent(MenuActivity.this, FirstFragment.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.button_cam_nog_bum).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Обработчик для кнопки 2
                Intent intent = new Intent(MenuActivity.this, SecondFragment.class);
                startActivity(intent);
            }
        });
    }
}