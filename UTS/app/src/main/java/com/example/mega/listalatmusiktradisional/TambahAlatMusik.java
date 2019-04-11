package com.example.mega.listalatmusiktradisional;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mega.listalatmusiktradisional.models.DatabaseListAlatMusik;

public class TambahAlatMusik extends AppCompatActivity {

    EditText text_namaalatmusikd,text_asald,text_deskripsid;
    ImageButton button_save;
    DatabaseListAlatMusik db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_alat_musik);

        db = new DatabaseListAlatMusik(this);

        text_namaalatmusikd = (EditText) findViewById(R.id.text_namaalatmusikth);
        text_asald = (EditText) findViewById(R.id.text_asalth);
        text_deskripsid= (EditText) findViewById(R.id.text_deskripsith);
        button_save = (ImageButton) findViewById(R.id.button_save);

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase dbnya = db.getWritableDatabase();
                dbnya.execSQL("insert into note(nama_alatmusik, asal_provinsi, deskripsi_alatmusik) values('" + text_namaalatmusikd.getText().toString() + "','" + text_asald.getText().toString() + "','" + text_deskripsid.getText().toString() + "')");

                Toast.makeText(getApplicationContext(), "DATA BERHASIL DITAMBAH", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(TambahAlatMusik.this, ListAlatMusik.class);
                startActivity(intent);
                finish();
            }
        });

    }

}
