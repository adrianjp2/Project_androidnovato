package com.app.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.app.AlertDialog;

public class splas extends AppCompatActivity {
    private EditText edit1;
    private Button BtnAceptar;
    private Spinner CmbOpciones;
    private ListView lista;
    private String nueva;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splas);

        edit1 = (EditText)findViewById(R.id.edit1);
        BtnAceptar = (Button)findViewById(R.id.BtnAceptar);
        CmbOpciones = (Spinner)findViewById(R.id.CmbOpciones);
        lista = (ListView)findViewById(R.id.lista);


        final String [] datos = new String[]{"selec all","ddddwada","dwadaw","yuuuuu","qqqqq","qqqqq"};
        final String [] datos2 = new String[]{"selec all","ddddwada","dwadaw","yuuuuu","qqqqq","qqqqq"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, datos);
        ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, datos2);

        lista.setAdapter(adaptador2);


        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        CmbOpciones.setAdapter(adaptador);

        CmbOpciones.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {
                        if (parent.getItemAtPosition(position) == "selec all") {
                            edit1.setText("");
                        } else {
                            edit1.setText("" + parent.getItemAtPosition(position));
                        }
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        edit1.setText("");
                    }
                });

        String a = getcarro("aveo");
        edit1.setText(a);

        BtnAceptar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if ((edit1.getText().toString().equals(""))) {
                    new AlertDialog.Builder(splas.this).setTitle("Error")
                            .setMessage("Valor Vacio")
                            .setPositiveButton("OK", null).show();
                    // edit1.setText("holaaaa");
                }else {
                    BtnAceptar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intenl = new Intent(splas.this, saludos.class);
                            Bundle b = new Bundle();
                            b.putString("NOMBRE", edit1.getText().toString());
                            intenl.putExtras(b);
                            startActivity(intenl);
                        }
                    });

                    Intent intenl = new Intent(splas.this, saludos.class);
                    Bundle b = new Bundle();
                    b.putString("NOMBRE", edit1.getText().toString());
                    intenl.putExtras(b);
                    startActivity(intenl);
                }}
        });



    }
    public String getcarro (String nueva){
         String otra = "holaa"+ nueva;
             return otra;
    }


}
