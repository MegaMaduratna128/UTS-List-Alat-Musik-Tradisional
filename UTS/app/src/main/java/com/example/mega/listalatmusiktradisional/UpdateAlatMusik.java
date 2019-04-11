package com.example.mega.listalatmusiktradisional;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mega.listalatmusiktradisional.models.DatabaseListAlatMusik;

public class UpdateAlatMusik extends AppCompatActivity {

    EditText text_namaalatmusikd, text_asald, text_deskripsid;
    ImageButton button_saveup;
    DatabaseListAlatMusik db;
    Cursor cursor;
    String nama_alatmusik, asal_provinsi, deskripsi_alatmusik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_alat_musik);

        Intent intent = getIntent();
        nama_alatmusik = intent.getStringExtra("nama_alatmusik");
        asal_provinsi = intent.getStringExtra("asal_provinsi");
        deskripsi_alatmusik  = intent.getStringExtra("deskripsi_alatmusik");

        text_namaalatmusikd = (EditText) findViewById(R.id.text_namaalatmusikup);
        text_asald = (EditText) findViewById(R.id.text_asalup);
        text_deskripsid = (EditText) findViewById(R.id.text_deskripsiup);

        button_saveup = (ImageButton) findViewById(R.id.button_saveup);

        text_namaalatmusikd.setText(nama_alatmusik);
        text_asald.setText(asal_provinsi);
        text_deskripsid.setText(deskripsi_alatmusik);
        db = new DatabaseListAlatMusik(this);

        button_saveup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase dbnya = db.getWritableDatabase();
                dbnya.execSQL("update note set nama_alatmusik='"+ text_namaalatmusikd.getText() +"', asal_provinsi='"+ text_asald.getText() +"', deskripsi_alatmusik='"+ text_deskripsid.getText() +"' where nama_alatmusik='"+ nama_alatmusik +"'");
                finish();
                Toast.makeText(UpdateAlatMusik.this,"DATA BERHASIL DI UPDATE",Toast.LENGTH_LONG).show();
            }
        });
    }
}
