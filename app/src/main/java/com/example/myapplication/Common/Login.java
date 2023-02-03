package com.example.myapplication.Common;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.DatabaseHelper.SQLiteHelper;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class Login extends AppCompatActivity {


    Button login;
    EditText email, password;
    String EmailHolder, PasswordHolder;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    SQLiteHelper sqLiteHelper;
    Cursor cursor;
    String TempPassword = "NOT_FOUND" ;
    public static final String UserEmail = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        login = (Button)findViewById(R.id.btnLogin);
        email = (EditText)findViewById(R.id.inputEmail);
        password = (EditText)findViewById(R.id.inputPassword);
        TextView newAcc = (TextView)  this.findViewById(R.id.createNewAccount);
        sqLiteHelper = new SQLiteHelper(this);
        //Adding click listener to log in button.
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Calling EditText is empty or no method.
                CheckEditTextStatus();
                // Calling login method.
                LoginFunction();
            }
        });

        //dothe click


        // Adding click listener to create new account button.
        newAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            // Opening new user registration activity using intent on button click.
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Signup.class));
                finish();
            }
        });
        /*Toast.makeText(getApplicationContext(),"welldone",Toast.LENGTH_LONG).show();
        //do it here*/



    }
    // Login function starts from here.
    @SuppressLint("Range")
    public void LoginFunction(){
        if(EditTextEmptyHolder) {
            // Opening SQLite database write permission.
            sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();
            // Adding search email query to cursor.
            cursor = sqLiteDatabaseObj.query(SQLiteHelper.TABLE_NAME, null, " " + SQLiteHelper.Table_Column_2_Email + "=?", new String[]{EmailHolder}, null, null, null);
            while (cursor.moveToNext()) {
                if (cursor.isFirst()) {
                    cursor.moveToFirst();
                    // Storing Password associated with entered email.
                    TempPassword = cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Column_3_Password));
                    // Closing cursor.
                    cursor.close();
                }
            }
            // Calling method to check final result ..
            //CheckFinalResult();
        }
        else {
            //If any of login EditText empty then this block will be executed.
            Toast.makeText(Login.this,"Please Enter UserName or Password.",Toast.LENGTH_LONG).show();
        }
    }

    // Checking EditText is empty or not.
    public void CheckEditTextStatus(){
        // Getting value from All EditText and storing into String Variables.
        EmailHolder = email.getText().toString();
        PasswordHolder = password.getText().toString();
        // Checking EditText is empty or no using TextUtils.
        if( TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder)){
            EditTextEmptyHolder = false ;
        }
        else {
            EditTextEmptyHolder = true ;
        }
    }




        public void CheckFinalResult(){
            if(TempPassword.equalsIgnoreCase(PasswordHolder))
            {
                Toast.makeText(Login.this,"Login Successful",Toast.LENGTH_LONG).show();
                // Going to Dashboard activity after login success message.
                Intent intent = new Intent(Login.this, MainActivity.class);
                // Sending Email to Dashboard Activity using intent.
                intent.putExtra(UserEmail, EmailHolder);
                startActivity(intent);
            }
            else {
                Toast.makeText(Login.this,"UserName or Password is Wrong, Please Try Again.",Toast.LENGTH_LONG).show();
            }
            TempPassword = "NOT_FOUND" ;
        }


    }



    //do button click method
