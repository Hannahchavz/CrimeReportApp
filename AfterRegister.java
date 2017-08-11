package com.example.asus.crimereportapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by ASUS on 7/11/2017.
 */

public class AfterRegister extends Activity{

    //your account has been registered

    private EditText et_username;
    private EditText et_password;
private Button bt_login;

private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    //proceed to login
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        et_username = (EditText) findViewById(R.id.etUserName);
        et_password = (EditText) findViewById(R.id.etPassword);

        bt_login = (Button) findViewById(R.id.btLogin);
        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if (firebaseAuth.getCurrentUser() != null) {
                    //Intent user account
                    Toast.makeText(AfterRegister.this, "login succesful..", Toast.LENGTH_LONG).show();

                }


            }
        };

//hsdksahdkajshjksahkshaksjaha

    }

    @Override

protected void onStart(){


     super.onStart();
}



    }


