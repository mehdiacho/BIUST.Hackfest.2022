package com.example.myapplication.DatabaseHelper;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class SQLiteHelper extends SQLiteOpenHelper
{
    static String DATABASE_NAME="UserDataBase";
    public static final String TABLE_NAME="UserTable";
    public static final String Table_Column_first_name="FirstName";
    public static final String Table_Column_1_last_name="LastName";
    public static final String Table_Column_2_Email="Email";
    public static final String Table_Column_3_Password="Password";
    public static final String Table_Column_4_confirm_password="Confirm_Password";
    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase database) {
        String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+Table_Column_first_name+" VARCHAR, "+Table_Column_1_last_name+" VARCHAR, "+Table_Column_2_Email+" VARCHAR, "+Table_Column_3_Password+" VARCHAR, "+Table_Column_4_confirm_password+" VARCHAR)";
        database.execSQL(CREATE_TABLE);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

}


