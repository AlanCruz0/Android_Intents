package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    private static final long SPLASH_DURATION = 5000; // Duración en milisegundos (5 segundos)
    private CountDownTimer countDownTimer;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        textView = (TextView) findViewById(R.id.txtview);

        countDownTimer = new CountDownTimer(SPLASH_DURATION, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        countDownTimer.start();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}