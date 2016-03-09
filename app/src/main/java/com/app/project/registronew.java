package com.app.project;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

public class registronew extends AppCompatActivity {
    private EditText tarea1,tarea2,tarea3;
    private Toolbar appbar;
    private DrawerLayout drawerLayout;
    private NavigationView navView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registronew);

        tarea1 = (EditText) findViewById(R.id.tarea1);
        tarea2 = (EditText) findViewById(R.id.tarea2);
        tarea3 = (EditText) findViewById(R.id.tarea3);
    }

    public void registrar(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Administracion",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = tarea1.getText().toString();
        String des = tarea2.getText().toString();
        String pre = tarea3.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo",cod);
        registro.put("descripcion",des);
        registro.put("precio",pre);
        bd.insert("articulos", null, registro);
        Toast.makeText(this,"se han insertado tantod",Toast.LENGTH_SHORT).show();
        tarea1.setText("");
        tarea2.setText("");
        tarea3.setText("");
    }

    public void consultacod(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Administracion",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = tarea1.getText().toString();
        Cursor fila = bd.rawQuery("select descripcion,precio from articulos where codigo ="+cod,null);
        if (fila.moveToFirst()){
            tarea2.setText(fila.getString(0));
            tarea3.setText(fila.getString(1));
        }else{
            Toast.makeText(this,"no hay nada",Toast.LENGTH_SHORT).show();
            tarea1.setText("");
            tarea2.setText("");
            tarea3.setText("");
            bd.close();
        }
    }

    public void Eliminar(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Administracion",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = tarea1.getText().toString();
        int cant = bd.delete("articulos", "codigo="+cod,null);
        bd.close();
        tarea1.setText("");
        tarea2.setText("");
        tarea3.setText("");
        if(cant==1){
            Toast.makeText(this,"seee elimino",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this," no se encontro el articulo seleccionado",Toast.LENGTH_SHORT).show();
        }
    }

    public void modificar(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Administracion",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = tarea1.getText().toString();
        String des = tarea2.getText().toString();
        String pre = tarea3.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo",cod);
        registro.put("descripcion",des);
        registro.put("precio",pre);
        int cant = bd.update("articulos", registro, "codigo="+cod,null);
        bd.close();
        if(cant==1){
            Toast.makeText(this,"Se modifico",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this," no se encontro el articulo ",Toast.LENGTH_SHORT).show();
        }
    }
}
