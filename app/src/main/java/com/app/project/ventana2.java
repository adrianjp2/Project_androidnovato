package com.app.project;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class ventana2 extends AppCompatActivity  implements View.OnClickListener {
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES= {R.drawable.descargaloo,R.drawable.descarga,R.drawable.equipo};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    private EditText texd;
    private EditText frame;
    public Button aceptar;
    private Button boton2;
  private viewpager.MyPagerAdapter adapterViewPager;
    private RadioButton ww1,ww2,ww3,ww4;
   // private view view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana2);

      //  texd = (EditText)findViewById(R.id.texto1);

        aceptar = (Button)findViewById(R.id.aceptar);
        aceptar.setOnClickListener((View.OnClickListener) this);
        ww1 = (RadioButton)findViewById(R.id.radio1);
        ww2 = (RadioButton)findViewById(R.id.radio2);
        ww3 = (RadioButton)findViewById(R.id.radio3);
        ww4 = (RadioButton)findViewById(R.id.radio4);

        boton2 =(Button)findViewById(R.id.id1);
        boton2.setOnClickListener((View.OnClickListener) this);
        //init();

     //   viewpager pa = new viewpager();
       // viewpager.MyPagerAdapter dd = new viewpager.MyPagerAdapter();

        ViewPager vpPager = (ViewPager) findViewById(R.id.pager);
        adapterViewPager = new viewpager.MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

//        ViewPager pager = (ViewPager)findViewById(R.id.pager);
//        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
       vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @Override
           public void onPageSelected(int position) {
               if (position == 0) {
                   ww1.setChecked(true);
               } else if (position == 1) {
                   ww2.setChecked(true);
               } else if (position == 2) {
                   ww3.setChecked(true);
               } else if (position == 3) {
                   ww4.setChecked(true);
               }
           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });



        


    }

// setiar el radio buton
    public void radio1(View view) {
        ViewPager vpPager = (ViewPager) findViewById(R.id.pager);
        vpPager.setCurrentItem(0);
        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setContentTitle("Tienes un mensaje")
                        .setContentText("muy pero importar");
        Intent notIntent =    new Intent(ventana2.this, tres.class);
        PendingIntent contIntent = PendingIntent.getActivity(ventana2.this, 0, notIntent, 0);
        mBuilder.setContentIntent(contIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(2, mBuilder.build());

    }
    public void radio2(View view) {
        ViewPager vpPager = (ViewPager) findViewById(R.id.pager);
        vpPager.setCurrentItem(1);
    }
    public void radio3(View view) {
        ViewPager vpPager = (ViewPager) findViewById(R.id.pager);
        vpPager.setCurrentItem(2);
    }
    public void radio4(View view){
        ViewPager vpPager = (ViewPager) findViewById(R.id.pager);
        vpPager.setCurrentItem(3);
    }

    public void kk(View view){
        RadioButton ww;
        ww = (RadioButton)findViewById(R.id.radio1);
        Log.e("siii", String.valueOf(ww));
    }
    private void init() {
        for(int i=0;i<IMAGES.length;i++)
            ImagesArray.add(IMAGES[i]);
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new imageadapter(ventana2.this, ImagesArray));
    }

    public void onClick(View v){

        if(v.getId()==R.id.aceptar){
            String a = ("aveo");
        //    texd.setText(a);
            Intent intent = new Intent(ventana2.this, tres.class);
            startActivity(intent);
         //   frame.setText(" Hi my love");

        }else if(v.getId()==R.id.id1){
            Intent intent = new Intent(ventana2.this, cinco.class);
          //  texd.setText("hi my ");
            startActivity(intent);
        }
    }


//    @Override
//    public boolean onLongClick(View v) {
//        if(v.getId()==R.id.aceptar){
//            String a = ("aveo");
//            texd.setText(a);
//            return true;
//
//        }
//        return false;
//    }

    public void jose (View view){
   //   texd.setText("nuevooooo ");
        String ii = "lo nuevo";
        Toast.makeText(this,ii,Toast.LENGTH_SHORT).show();
    }



}
