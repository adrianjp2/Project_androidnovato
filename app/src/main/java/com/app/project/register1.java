package com.app.project;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class register1 extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    EditText uno,dos,tres,cuatro;
    Button boto;
    Context context;
    private int mPage;

    public static register1 newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        register1 fragment = new register1();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_register1, container, false);
        uno = (EditText)view.findViewById(R.id.uno1);
        dos = (EditText)view.findViewById(R.id.dos2);
        tres = (EditText)view.findViewById(R.id.tres3);
        cuatro = (EditText)view.findViewById(R.id.cuatro4);
        boto=(Button)view.findViewById(R.id.boton);
        final Context dd = getContext();
        boto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin2 = new AdminSQLiteOpenHelper(dd, "nueva3", null, 1);
                SQLiteDatabase bdd = admin2.getWritableDatabase();
                String user = uno.getText().toString();
                String email = dos.getText().toString();
                String pas1 = tres.getText().toString();
                String pas2 = cuatro.getText().toString();
                if (user.length() == 0 || email.length()==0 || pas1.length()==0 || pas2.length()==0) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(dd);
                    dialog.setMessage("Debe llenar todos los campos");
                    dialog.setCancelable(false);
                    dialog.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    dialog.show();


                    // Toast.makeText(dd,"Debe insertar el usuario",Toast.LENGTH_SHORT).show();
                } else {

                    ContentValues registro = new ContentValues();
                    registro.put("user", user);
                    registro.put("email", email);
                    registro.put("password1", pas1);
                    registro.put("password2", pas2);
                    bdd.insert("user", null, registro);
                    Toast.makeText(dd, "Se ah Registrado Saticfactoriamente", Toast.LENGTH_SHORT).show();
                uno.setText("");
                dos.setText("");
                tres.setText("");
                cuatro.setText("");
                }
            }
        });

        return view;
    }







}



