package com.app.project;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class prueba3 extends Fragment {

    public static prueba3 newInstance(int page, String title) {
        prueba3 prueba3 = new prueba3();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        prueba3.setArguments(args);
        return prueba3;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View pp= inflater.inflate(R.layout.fragment_prueba3, container, false);
        return  pp;
    }

}
