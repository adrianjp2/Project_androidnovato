package com.app.project;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    TextView newregistre;
    EditText tres,cuatro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        newregistre = (TextView) findViewById(R.id.cuatro);


    }

    public void newuser(View view) {
        Intent i = new Intent(login.this, register.class);
        startActivity(i);

    }

    public void entrar(View view) {
        tres = (EditText)findViewById(R.id.tres);
        cuatro = (EditText)findViewById(R.id.cuatro);
        String user = tres.getText().toString();
        String clavew=cuatro.getText().toString();

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"nueva3",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        Cursor fila = bd.rawQuery("select * from user where user='"+user+"' and password1='"+clavew+"'",null);


        if (fila.moveToFirst()){
            Intent intent = new Intent(login.this,ventana2.class);
            startActivity(intent);

        }else{
            Toast.makeText(this, "Usuario o Claves Incorectas", Toast.LENGTH_SHORT).show();

            bd.close();
        }
    }
}
