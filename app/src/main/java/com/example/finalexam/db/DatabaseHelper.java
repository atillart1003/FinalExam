package com.example.finalexam.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "login.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "list_name";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_USER = "username";
    public static final String COL_PASSWORD = "password";

    private static final String SQL_CRATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_NAME + " TEXT, "
                    + COL_USER + " TEXT, "
                    + COL_PASSWORD + " TEXT"
                    + ")";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CRATE_TABLE);
        insertInitialData(db);
    }

    private void insertInitialData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, "Android Studio");
        cv.put(COL_USER, "android");
        cv.put(COL_PASSWORD, "123456");
        db.insert(TABLE_NAME, null, cv);
    }
        @Override
        public void onUpgrade (SQLiteDatabase db,int i, int i1){

    }
}
