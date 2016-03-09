package com.app.project;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;


public class prueba1 extends Fragment {
    TextView pru;
    Toolbar appbar;
    RadioButton aa;

    public static prueba1 newInstance(int page, String title) {
        prueba1 fragmentFirst = new prueba1();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View dd = inflater.inflate(R.layout.fragment_prueba1, container, false);

        // Inflate the layout for this fragment
      // String latitude =  getArguments().getString("hola");

        String someTitle = getArguments().getString("hola", "");
        pru = (TextView)dd.findViewById(R.id.prueba12);
        pru.setText(someTitle);

        return dd;


    }




}
