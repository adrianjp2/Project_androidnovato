package com.app.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import static com.app.project.galery.*;

public class imagealone extends AppCompatActivity {
    ImageView aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagealone);


        Intent intent = getIntent();
         int posi = intent.getExtras().getInt("id");
        classalone da = new classalone(this);

        aa= (ImageView)findViewById(R.id.alone);
        aa.setImageResource(da.arr[posi]);
    }
}
