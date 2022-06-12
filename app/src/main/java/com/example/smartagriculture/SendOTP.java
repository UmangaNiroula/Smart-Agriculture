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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class SendOTP extends AppCompatActivity implements View.OnClickListener {

    private EditText mOTP;
    private Button mSendOTP;
    private TextView mResendOtp;
    String userOtp;
    FirebaseAuth firebaseAuth;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_otp);

        mOTP = (EditText) findViewById(R.id.otp);
        mSendOTP = (Button) findViewById(R.id.sendOTP);
        mResendOtp = (TextView) findViewById(R.id.resendOTP);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBarSend);
        firebaseAuth = FirebaseAuth.getInstance();

        mSendOTP.setOnClickListener(this);
        mResendOtp.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.resendOTP)
        {
            startActivity(new Intent(SendOTP.this, MainActivity.class));
        }

        else if(view.getId() == R.id.sendOTP)
        {
            String enteredOTP = mOTP.getText().toString();

            if (enteredOTP.isEmpty())
            {
                mOTP.setError("Enter OTP");
            }
            else
            {
                String codeReciever = getIntent().getStringExtra("otp");
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeReciever,enteredOTP);
                signIn(credential);
            }
        }
    }

    private void signIn(PhoneAuthCredential credential)
    {
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    startActivity(new Intent(SendOTP.this, Dashboard.class));
                    finish();
                }
                else
                {
                    if (task.getException() instanceof FirebaseAuthInvalidCredentialsException)
                    {
                        Toast.makeText(SendOTP.this, "Login Fail", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}