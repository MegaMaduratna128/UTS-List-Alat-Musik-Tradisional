package com.example.mega.listalatmusiktradisional;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ListYoutube extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_youtube);
    }
    public void openYoutube1 (View view){
        Uri webpage = Uri.parse("https://www.youtube.com/watch?v=ZritaVDicl0");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        } else {
            Log.d("ImplicitIntens", "Can't handle this intent!");
        }
    }

    public void openYoutube2 (View view){
        Uri webpage = Uri.parse("https://www.youtube.com/watch?v=6NGz8MWf4JM");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        } else {
            Log.d("ImplicitIntens", "Can't handle this intent!");
        }
    }

    public void openYoutube3 (View view){
        Uri webpage = Uri.parse("https://www.youtube.com/watch?v=6NGz8MWf4JM");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        } else {
            Log.d("ImplicitIntens", "Can't handle this intent!");
        }
    }

    public void openYoutube4 (View view){
        Uri webpage = Uri.parse("https://www.youtube.com/watch?v=8AhMgjk9at8");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        } else {
            Log.d("ImplicitIntens", "Can't handle this intent!");
        }
    }

}
