package com.example.mega.listalatmusiktradisional;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mega.listalatmusiktradisional.models.DatabaseListAlatMusik;
import com.example.mega.listalatmusiktradisional.models.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public List<User> user;
    public EditText text_username, text_password;
    public Button button_login;
    DatabaseListAlatMusik db;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new Session(this);

        if (session.getSession_SUDAHLOGIN()){
            startActivity(new Intent(MainActivity.this, HalamanUtama.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }

        addUser();

        text_username = (EditText) findViewById(R.id.text_username);
        text_password = (EditText) findViewById(R.id.text_password);
        button_login = (Button) findViewById(R.id.button_login);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User tmpUser = null;
                //for : untuk mengecek apkah username dan password yang di inputkan user sama dengan yang ada pada user
                //if :untuk menyimpan data username di sharedpref yang berhasil login untuk di tampilkan pada halaman berikutnya
                for(User use:user){
                    if(use.getUsername().equals(text_username.getText().toString()) && use.getPassword().equals(text_password.getText().toString())){
                        tmpUser = use;
                    }
                }

                if(tmpUser != null){
                    SharedPreferences spUser = MainActivity.this.getSharedPreferences("Userlogin", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = spUser.edit();

                    edit.putString("sedangLogin",tmpUser.getUsername());
                    edit.apply();

                    session.saveSPBoolean(Session.Session_SUDAH_LOGIN, true);

                    Intent intent = new Intent(MainActivity.this, HalamanUtama.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(MainActivity.this, "Maaf Username atau Password Salah", Toast.LENGTH_LONG).show();
                }
            }
        });

        db = new DatabaseListAlatMusik(this);

    }

    public void addUser(){
        user = new ArrayList<>();
        user.add(new User("mega", "mega"));
    }

}
