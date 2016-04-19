package com.creativeideas.kongkow.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kadek_p on 4/18/2016.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "instachat.db";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table messages (_id integer primary key autoincrement, msg text, email text, email2 text, at datetime default current_timestamp);");
        db.execSQL("create table profile (_id integer primary key autoincrement, name text, email text unique, count integer default 0);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
