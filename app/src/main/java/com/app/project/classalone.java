package com.app.project;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by ProjectManager on 3/3/16.
 */
public class classalone extends BaseAdapter {

    private Context context;
    public Integer[] arr = {
            R.drawable.descarga,
            R.drawable.equipo,
            R.drawable.descargaloo,
            R.drawable.detroid,
            R.drawable.ic_action_action_account_balance
    };
    public  classalone (Context c){
        context = c;
    }

    @Override
    public int getCount() {
        return arr.length;
    }

    @Override
    public Object getItem(int position) {
        return arr[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        imageView = new ImageView(context);
        imageView.setImageResource(arr[position]);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        //    imageView.setLayoutParams(new GridView.LayoutParams(200,100));
        return imageView;
//            if (convertView == null) {
//                // if it's not recycled, initialize some attributes
//                imageView = new ImageView(context);
//                imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
//                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//                imageView.setPadding(4, 4, 4, 4);
//            } else {
//                imageView = (ImageView) convertView;
//            }
//
//
//            imageView.setImageResource(arr[position]);
//            return imageView;

    }

}