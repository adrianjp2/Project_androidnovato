package com.app.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class cinco extends AppCompatActivity {
    private EditText texto;
    private TextView ggg;
    private ListView lista;
    private Toolbar appbar;
    ArrayList<String> datos = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinco);
        appbar = (Toolbar)findViewById(R.id.appbar);
        setSupportActionBar(appbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        texto = (EditText)findViewById(R.id.nuevo);
        ggg = (TextView)findViewById(R.id.nnn);
        lista = (ListView)findViewById(R.id.lista);
    }

    public void guardar(View view) {
        String aa= texto.getText().toString();
        if (aa.length()==0){
            Toast.makeText(this,"El campo no puede estar vacio",Toast.LENGTH_SHORT).show();
        }else {
            datos.add(aa);
            texto.setText("");
//        for (int i =0; i < datos.size(); i++ ){
//       // datos.get();
//
//        }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
            lista.setAdapter(adapter);

            lista.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    int posi = position;
                    String  itemValue    = (String) lista.getItemAtPosition(position);
                    Toast.makeText(getApplicationContext(), itemValue, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }





}
