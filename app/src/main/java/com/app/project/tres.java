package com.app.project;

import android.app.ActionBar;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class tres extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navView;
    Toolbar appbar;
    private EditText dd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tres);
        dd = (EditText)findViewById(R.id.tex1);
        appbar = (Toolbar)findViewById(R.id.appbar);
        setSupportActionBar(appbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        Intent intent = getIntent();
        String accion = intent.getAction();
        Log.e("ver",String.valueOf(accion) );

    }

    public void viajar(View view) {
        if(dd.getText().toString().length()>=5){
        Intent intent = new Intent(tres.this, navigation.class);
        startActivity(intent);
        Bundle bundle = new Bundle();
        Bundle b = new Bundle();
        b.putString("NOMBRE", dd.getText().toString());
        intent.putExtras(b);
        startActivity(intent);
        }else{
            Toast.makeText(this,"El campo debe tener mas de cinco caracteres",Toast.LENGTH_SHORT).show();
        }

    }
    @Nullable
    @Override
    public ActionBar getActionBar() {
        return super.getActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.androidmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // if(id== item){}
        return super.onOptionsItemSelected(item);
    }


}
