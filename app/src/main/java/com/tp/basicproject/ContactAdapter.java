package com.tp.basicproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contacts> {
    Context context;
    List<Contacts> contacts;
    int resources;
    public ContactAdapter(@NonNull Context context, int resource, @NonNull List<Contacts> objects) {
        super(context, resource, objects);
        this.context=context;
        this.contacts = objects;
        this.resources=resource;


    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater= LayoutInflater.from(context);
        convertView = inflater.inflate(resources, null);

        TextView tvNom = (TextView) convertView.findViewById(R.id.tvNom);
        TextView tvTel = (TextView) convertView.findViewById(R.id.tvTel);
        ImageView img = (ImageView) convertView.findViewById(R.id.imgContact);


        tvNom.setText(contacts.get(position).getNom());
        tvTel.setText(contacts.get(position).getTel());
        img.setImageResource(contacts.get(position).getImage());

        tvNom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DetailsActivity.class );
                intent.putExtra("nom", contacts.get(position).getNom());
                intent.putExtra("tel", contacts.get(position).getTel());
                intent.putExtra("img", contacts.get(position).getImage());
                context.startActivity(intent);


            }
        });


        return convertView;
    }
}