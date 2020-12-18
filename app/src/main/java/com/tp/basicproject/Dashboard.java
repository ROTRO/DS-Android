package com.tp.basicproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {
    ListView lstcontact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        lstcontact = (ListView) findViewById(R.id.lstContact);
        ArrayList<Contacts> contacts = new ArrayList<>();

        Contacts c1 = new Contacts("Maxime", "99112233", R.drawable.person);
        Contacts c2 = new Contacts("Oussama", "21234567", R.drawable.personn);
        Contacts c3 = new Contacts("Amal", "22119988", R.drawable.female);
        Contacts c4 = new Contacts("Mariem", "+33064848844", R.drawable.femalee);
        Contacts c5 = new Contacts("Emir", "98753126", R.drawable.emir);
        Contacts c6 = new Contacts("Mohamed", "54123789", R.drawable.mohamed);
        Contacts c7 = new Contacts("Emine", "55177639", R.drawable.emine);
        contacts.add(c1);
        contacts.add(c2);
        contacts.add(c3);
        contacts.add(c4);
        contacts.add(c5);
        contacts.add(c6);
        contacts.add(c7);

        ContactAdapter adapter = new ContactAdapter(this, R.layout.item_template, contacts);

        lstcontact.setAdapter(adapter);



    }




}
// setContentView(R.layout.activity_dashboard);