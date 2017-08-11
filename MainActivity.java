package com.example.asus.crimereportapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {


    private Button mFirebase_btn;
    private EditText et_fn;
    private EditText et_ln;

    private EditText et_age;

    private EditText et_username;
    private EditText et_password;



    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebase_btn = (Button) findViewById(R.id.firebase_btn);
        et_fn = (EditText) findViewById (R.id.etFN);
        et_ln = (EditText) findViewById( R.id.etLN);
        et_age = (EditText) findViewById(R.id.etAge);
        et_username = (EditText) findViewById (R.id.etUserName);
        et_password = (EditText) findViewById (R.id.etPassword);







        //firebase_btn is the name of the button in the design
        mDatabase = FirebaseDatabase.getInstance().getReference(  );


        mFirebase_btn.setOnClickListener(new View.OnClickListener() {  //mahirap ioverride code completion alt shift enter always hula
            @Override
            public void onClick(View v) {
                String firstname = et_fn.getText().toString().trim();
                String lastname = et_ln.getText().toString().trim();
                String age = et_age.getText().toString().trim();
                String username = et_username.getText().toString().trim();
                String password = et_password.getText().toString().trim();



                HashMap <String,String> dataMap = new HashMap<String, String>();
                dataMap.put("First Name", firstname);
                dataMap.put("Last Name", lastname);
                dataMap.put("Age", age);
                dataMap.put("User Name", username);
                dataMap.put("Password", password);

//mobile number
                //password create
                //authentication number has already been registered
                //authentication email had already been regusterd
                mDatabase.push().setValue(dataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {


                        if (task.isSuccessful()) {

                            Toast.makeText(MainActivity.this, "Stored..", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivity.this, AfterRegister.class);
                            startActivity(intent);
                            finish();
                        } else{

                            Toast.makeText(MainActivity.this,"Error..", Toast.LENGTH_LONG).show();
//proceed to afterregister activty


                        }



                        }



                    });
                }









                //1-create root object
                //2-assign value to child obje



        });

    }}
