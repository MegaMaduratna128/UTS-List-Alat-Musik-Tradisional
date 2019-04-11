package com.example.mega.listalatmusiktradisional;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class HalamanUtama extends AppCompatActivity {
    ImageButton logout;
    Session session;
    private static final String LOG_TAG = MainActivity.class.getSimpleName ();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);
    }

    public void kliklogout( View view ) {
        Log.d(LOG_TAG, "Logout");

        session = new Session(this);

        session.saveSPBoolean(Session.Session_SUDAH_LOGIN, false);

        startActivity(new Intent(this,MainActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
        finish();
    }

    public void openListAlatMusik ( View view ) {
        Log.d(LOG_TAG,"Button clicked");
        Intent intent = new Intent ( this,ListAlatMusik.class );
        startActivity(intent);
    }

    public void openListYoutube ( View view ) {
        Log.d(LOG_TAG,"Button clicked");
        Intent intent = new Intent ( this,ListYoutube.class );
        startActivity(intent);
    }
}
