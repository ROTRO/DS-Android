package com.tp.basicproject;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        String nom =  getIntent().getStringExtra("nom");
        String tel = getIntent().getStringExtra("tel");
        int img = getIntent().getIntExtra("img", 0);

        TextView tvNom = (TextView) findViewById(R.id.tvNom);
        TextView tvtel = (TextView) findViewById(R.id.tvTel);
        ImageView imgCon = (ImageView) findViewById(R.id.img);

        tvNom.setText(nom);
        tvtel.setText(tel);
        imgCon .setImageResource(img);



    }
}