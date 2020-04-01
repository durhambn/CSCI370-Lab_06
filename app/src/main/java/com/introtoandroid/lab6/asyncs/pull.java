package com.introtoandroid.lab6.asyncs;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.introtoandroid.lab6.data.LabDatabase;
import com.introtoandroid.lab6.entities.Person;
import com.introtoandroid.lab6.entities.PersonsActivity;

import java.util.ArrayList;

public class pull extends AsyncTask<Person, Void, Void> {

    LabDatabase database;
    Context context;
    public pull(LabDatabase database) {
        this.database = database;
    }

    @Override
    protected Void doInBackground(Person... people) {
        ArrayList<String> personNames = new ArrayList<>();
        for(Person p: people) {
            personNames.add(p.getName());
        }

        Intent i = new Intent(context, PersonsActivity.class);
        i.putExtra("Persons", personNames);
        context.startActivity(i);


        return null;
    }



}
