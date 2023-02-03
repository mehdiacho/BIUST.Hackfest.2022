package com.example.myapplication.Common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class Signup extends AppCompatActivity {

    Button signUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        signUp = (Button) findViewById(R.id.btn_signup);
        //do the click


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Signup.this, MainActivity.class));
                finish();
            }
        });
    }


    /*public void CheckFinalResult(){
        // Checking whether email is already exists or not.
        if(F_Result.equalsIgnoreCase("Email Found"))
        {
            // If email is exists then toast msg will display.
            Toast.makeText(Signup.this,"Email Already Exists",Toast.LENGTH_LONG).show();
        }
        else {
            // If email already dose n't exists then user registration details will entered to SQLite database.
            InsertDataIntoSQLiteDatabase();
        }
}*/
}