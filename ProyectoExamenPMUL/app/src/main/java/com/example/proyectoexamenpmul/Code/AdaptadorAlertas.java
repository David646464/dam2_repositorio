package com.example.proyectoexamenpmul.Code;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectoexamenpmul.Objects.MiniAlert;
import com.example.proyectoexamenpmul.R;

import java.util.ArrayList;

public class AdaptadorAlertas extends BaseAdapter {
    private Context context;
    private ArrayList<MiniAlert> miniAlerts;

    public AdaptadorAlertas(Context context, ArrayList<MiniAlert> miniAlerts) {
        this.context = context;
        this.miniAlerts = miniAlerts;
    }

    @Override
    public int getCount() {
        return miniAlerts.size();
    }

    @Override
    public Object getItem(int position) {
        return miniAlerts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_mini_alert, parent, false);
        }

        MiniAlert miniAlert = (MiniAlert) getItem(position);
        ImageView imageView = convertView.findViewById(R.id.imageView);
        if (miniAlert.getValid() ==1 ){
            imageView.setImageResource(R.drawable.dedo_arriba);
        }else{
            imageView.setImageResource(R.drawable.dedo_abajo);
        }
        TextView textView = convertView.findViewById(R.id.textView);
        textView.setText(miniAlert.toString());

        return convertView;
    }

    public void clear() {
        miniAlerts.clear();
        notifyDataSetChanged();
    }
}