package com.example.intents;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.security.Provider;

public class MiServicio extends Service {
    private static final long DURACION_TOTAL = 5000; // 5 segundos
    private static final long INTERVALO_ACTUALIZACION = 1000; // 1 segundo
    private CountDownTimer countDownTimer;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startCountDown();
        return START_STICKY;
    }

    private void startCountDown() {
        countDownTimer = new CountDownTimer(DURACION_TOTAL, INTERVALO_ACTUALIZACION) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Actualización de tiempo si es necesario
            }

            @Override
            public void onFinish() {
                mostrarMensajeDeFinalizacion();
                stopSelf(); // Detener el servicio cuando finaliza la cuenta regresiva
            }
        };
        countDownTimer.start();
    }

    private void mostrarMensajeDeFinalizacion() {
        Handler handler = new Handler(getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "¡Acabado!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroy() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
