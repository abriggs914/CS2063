package com.example.abrig.lab10;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;

public class Sample extends ContentProvider {

    public static final String dbname="SAMPLEDB";
    public static String result;
    public static final int dbversion=1;
    public static SQLiteDatabase db;
    public static Cursor select_name_from_student;

    @Override
    public boolean onCreate() {
        Context context = getContext();
        DBHelper databaseHelper = new DBHelper(context);
        db=databaseHelper.getWritableDatabase();
        databaseHelper.onCreate(db);
        return db != null;
    }


    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }


    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }


    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    private static class DBHelper extends SQLiteOpenHelper {
        DBHelper(Context context) {
            super(context, dbname, null, dbversion);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("DROP TABLE IF EXISTS Student;");
            db.execSQL("CREATE TABLE Student (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL);");
            ContentValues values= new ContentValues();
            values.put("name","FirstStudent");
            db.insert("Student", "name", values);
            select_name_from_student = db.rawQuery("SELECT name from Student", null);
            int count= select_name_from_student.getCount();
            result = String.valueOf(count) + " student has been added to the database.";
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS Student;");
            onCreate(db);
        }
    }

}
