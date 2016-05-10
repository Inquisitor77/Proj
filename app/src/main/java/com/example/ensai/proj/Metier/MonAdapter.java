package com.example.ensai.proj.Metier;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ensai.proj.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by ensai on 10/05/16.
 */
public class MonAdapter extends BaseAdapter {

    ArrayList<String> liste = new ArrayList<String>();
    Context context;

    public MonAdapter(ArrayList<String> liste, Context context) {
        this.liste = liste;
        this.context = context;
    }

    @Override
    public int getCount() {
        return liste.size();
    }

    @Override
    public Object getItem(int position) {
        return liste.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Element element = (Element) getItem(position);
        View view = LayoutInflater.from(context).inflate(R.layout.item_liste, parent, false);
        TextView titre = (TextView) view.findViewById(R.id.titre);
        titre.setText(element.getTitre());
        TextView sousTitre = (TextView) view.findViewById(R.id.soustitre);
        sousTitre.setText(element.getSousTitre());

        return null;
    }
}
