package com.app.project;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;

public class galery extends AppCompatActivity {
    private int [] arr = {
            R.drawable.descarga,
            R.drawable.equipo,
            R.drawable.descargaloo,
            R.drawable.detroid,
            R.drawable.ic_action_action_account_balance
    };
    GridView gale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galery);

        gale = (GridView)findViewById(R.id.gridview);
        gale.setAdapter(new classalone(this));

        gale.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(galery.this,imagealone.class);
                intent.putExtra("id",position);
                startActivity(intent);

            }
        });
    }


}

