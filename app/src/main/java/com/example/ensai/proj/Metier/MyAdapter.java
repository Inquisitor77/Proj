package com.example.ensai.proj.Metier;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ensai.proj.Elements.ContactTel;
import com.example.ensai.proj.R;
import com.example.ensai.proj.SelectionContacts;

import java.util.ArrayList;

/**
 * Created by ensai on 23/05/16.
 */
public class MyAdapter extends ArrayAdapter<ContactTel> {

    private ArrayList<ContactTel> liste;
    Context context;

    public MyAdapter(Context context, int textViewResourceId,
                           ArrayList<ContactTel> liste) {
        super(context, textViewResourceId, liste);
        this.liste = new ArrayList<ContactTel>();
        this.liste.addAll(liste);
    }

    private class ViewHolder {
        TextView code;
        CheckBox name;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        Log.v("ConvertView", String.valueOf(position));


            if (convertView == null) {
                // LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                LayoutInflater vi = LayoutInflater.from(context);
                convertView = vi.inflate(R.layout.list_perso, null);
                //convertView = LayoutInflater.from(context).inflate(R.layout.list_perso, parent, false);

                holder = new ViewHolder();
                holder.code = (TextView) convertView.findViewById(R.id.code);
                holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
                convertView.setTag(holder);

                holder.name.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v;
                        ContactTel contact = (ContactTel) cb.getTag();
                        contact.setSelected(cb.isChecked());
                    }
                });
            } else {
                holder = (ViewHolder) convertView.getTag();
            }


            ContactTel cont = liste.get(position);
            holder.code.setText("");
            holder.name.setText(cont.getNom());
            holder.name.setChecked(cont.isSelected());
            holder.name.setTag(cont);



        return convertView;

    }



}


