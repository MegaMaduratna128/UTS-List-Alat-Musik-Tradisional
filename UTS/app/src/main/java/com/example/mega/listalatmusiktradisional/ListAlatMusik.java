package com.example.mega.listalatmusiktradisional;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.mega.listalatmusiktradisional.models.DatabaseListAlatMusik;

import java.util.ArrayList;

public class ListAlatMusik extends AppCompatActivity {
    RecyclerView recyclerView;
    NoteAdapter adapter;
    ArrayList<NoteAlatMusik> notealatmusik;
    DatabaseListAlatMusik db;
    Cursor cursor;
    ImageButton plus;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_alat_musik);

        db = new DatabaseListAlatMusik(this);

        recyclerView = (RecyclerView) findViewById(R.id.rv_notes);
        plus = (ImageButton) findViewById(R.id.plus);


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListAlatMusik.this, TambahAlatMusik.class);
                startActivity(intent);
                finish();
            }
        });

        addAlatMusik();

    }

    @Override
    protected void onResume() {
        super.onResume();
        addAlatMusik();
    }

    private void addAlatMusik() {
        notealatmusik = new ArrayList<>();
        SQLiteDatabase dbsql = db.getReadableDatabase();
        cursor = dbsql.rawQuery("SELECT * FROM note",null);
        cursor.moveToFirst();

        if(cursor.getCount() > 0){
            do {

                notealatmusik.add(new NoteAlatMusik(cursor.getString(cursor.getColumnIndex("nama_alatmusik")),cursor.getString(cursor.getColumnIndex("asal_provinsi")),cursor.getString(cursor.getColumnIndex("deskripsi_alatmusik"))));

            } while (cursor.moveToNext());
        }

        adapter = new NoteAdapter(notealatmusik);

        layoutManager = new LinearLayoutManager(ListAlatMusik.this);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(layoutManager);

    }

}
