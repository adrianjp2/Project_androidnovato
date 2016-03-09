package com.app.project;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link prueba2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link prueba2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class prueba2 extends Fragment {

    public static prueba2 newInstance(int page, String title) {
        prueba2 prueba2 = new prueba2();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        prueba2.setArguments(args);
        return prueba2;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View aa = inflater.inflate(R.layout.fragment_prueba2, container, false);
        return aa;
    }



}
