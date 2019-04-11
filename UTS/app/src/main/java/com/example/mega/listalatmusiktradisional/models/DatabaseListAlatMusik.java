package com.example.mega.listalatmusiktradisional.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseListAlatMusik extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "notealatmusik.db";
    private static final int DATABASE_VERSION = 1;
    private String sql;

    public DatabaseListAlatMusik(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //membuat table pada database bernama note
        sql = "create table note(no integer primary key, nama_alatmusik text null, asal_provinsi text null, deskripsi_alatmusik text null);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }
}
