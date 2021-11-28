package com.example.idlock;


import android.annotation.SuppressLint;


import android.content.Intent;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;

import androidx.core.content.ContextCompat;





import java.util.concurrent.Executor;

public class biometriclock extends AppCompatActivity {


    @SuppressLint({"WrongViewCast", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.biometric_activity);





        TextView msg_txt = findViewById(R.id.txt_msg);
        Button login_btn = findViewById(R.id.login_btn);


        BiometricManager biometricManager = androidx.biometric.BiometricManager.from(this);
        switch (biometricManager.canAuthenticate()) {
            case BiometricManager.BIOMETRIC_SUCCESS:

                break;

            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                msg_txt.setText("Wystąpił błąd, spróbuj ponownie!");
                login_btn.setVisibility(View.GONE);
                break;
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                msg_txt.setText("Sensor jest niedostępny");
                login_btn.setVisibility(View.GONE);
                break;
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                msg_txt.setText("Twoje urządzenie nia ma wbudowanego czytnika lini papilarnych!");
                login_btn.setVisibility(View.GONE);
                break;
        }


        Executor executor = ContextCompat.getMainExecutor(this);
        BiometricPrompt biometricPrompt = new BiometricPrompt(biometriclock.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);

                Toast.makeText(getApplicationContext(), "Autoryzacja przebiegła pomyślnie!", Toast.LENGTH_SHORT).show();



                openactivity3();












            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        });

        final BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Autoryzacja")
                .setDescription("Zeskanuj odcisk palca w celu otworzenia aplikacji")
                .setNegativeButtonText("Anuluj")
                .build();


        login_btn.setOnClickListener(view -> biometricPrompt.authenticate(promptInfo));


    }



    public void openactivity3(){
        Intent intent3 = new Intent(this, menu_activity.class);
        startActivity(intent3);
    }









    }




