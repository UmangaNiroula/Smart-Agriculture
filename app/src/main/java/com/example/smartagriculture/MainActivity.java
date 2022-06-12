package com.example.smartagriculture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity
{
    EditText phone;
    Button signupMain;
    FirebaseAuth firebaseAuth;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    String codeSent, phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //calling the onCreate parameterized method of that parent AppCompatActivity class
        super.onCreate(savedInstanceState);

        //showing the activity of the this class
        setContentView(R.layout.activity_main);

        startActivity(new Intent(MainActivity.this, Dashboard.class));
        phone = findViewById(R.id.phone);
        signupMain = findViewById(R.id.signupMain);
        firebaseAuth = FirebaseAuth.getInstance();

        signupMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = phone.getText().toString();

                if (number.isEmpty())
                {
                    phone.setError("Enter Phone Number");
                }
                else if(number.length()<10)
                {
                    phone.setError("Enter Valid Phone Number");
                }
                else if(number.length()>10)
                {
                    phone.setError("Enter Valid Phone Number");
                }
                else
                {
                    phoneNumber = "+977"+phone;

                    PhoneAuthOptions options = PhoneAuthOptions.newBuilder(firebaseAuth)
                            .setPhoneNumber(phoneNumber)
                            .setTimeout(60L, TimeUnit.SECONDS)
                            .setActivity(MainActivity.this)
                            .setCallbacks(mCallbacks)
                            .build();


                    PhoneAuthProvider.verifyPhoneNumber(options);
                }
            }
        });

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {

            }

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                codeSent = s;
                Log.d("xxxqwaa","hh");
                Intent intent = new Intent(MainActivity.this, SendOTP.class);
                intent.putExtra("otp", codeSent);
                startActivity(intent);
            }
        };
        
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(FirebaseAuth.getInstance().getCurrentUser() != null)
        {
            Intent intent = new Intent(MainActivity.this, Dashboard.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}