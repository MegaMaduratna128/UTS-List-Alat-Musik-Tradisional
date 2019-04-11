package com.example.mega.listalatmusiktradisional;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mega.listalatmusiktradisional.models.DatabaseListAlatMusik;

public class DetailAlatMusik extends AppCompatActivity {
    String id;
    DatabaseListAlatMusik db;
    String nama_alatmusik, asal_provinsi, deskripsi_alatmusik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_alat_musik);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        nama_alatmusik = intent.getStringExtra("nama_alatmusik");
        asal_provinsi = intent.getStringExtra("asal_provinsi");
        deskripsi_alatmusik = intent.getStringExtra("deskripsi_alatmusik");

        TextView text_namaalatmusikd = (TextView) findViewById(R.id.text_namaalatmusik);
        TextView text_asald= (TextView) findViewById(R.id.text_asal);
        TextView text_deskripsid = (TextView) findViewById(R.id.text_deskripsi);
        ImageButton update = (ImageButton) findViewById(R.id.update);
        ImageButton hapus = (ImageButton) findViewById(R.id.hapus);


        text_namaalatmusikd.setText(" " + nama_alatmusik);
        text_asald.setText("Asal Provinsi\n - " +  asal_provinsi);
        text_deskripsid.setText("Deskripsi\n - " + deskripsi_alatmusik);

        db = new DatabaseListAlatMusik(this);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = DetailAlatMusik.this;
                Intent i = new Intent(context, UpdateAlatMusik.class);
                i.putExtra("nama_alatmusik", nama_alatmusik);
                i.putExtra("asal_provinsi", asal_provinsi);
                i.putExtra("deskripsi_alatmusik", deskripsi_alatmusik);
                context.startActivity(i);
                finish();
            }
        });

        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase dbsql = db.getReadableDatabase();
                dbsql.delete("note","nama_alatmusik = '" + nama_alatmusik + "'",null);
                Toast.makeText(DetailAlatMusik.this,"Berhasil dihapus!", Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }
}
