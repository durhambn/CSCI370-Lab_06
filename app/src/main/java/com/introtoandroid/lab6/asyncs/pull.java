package com.introtoandroid.lab6.asyncs;

import android.content.Intent;
import android.os.AsyncTask;

import com.introtoandroid.lab6.entities.Person;
import com.introtoandroid.lab6.entities.PersonsActivity;

import java.util.ArrayList;

public class pull extends AsyncTask {
    @Override
    protected Void doInBackground(Object... objects) {
        /*ArrayList<String> personNames = new ArrayList<>();
        for(Person p: persons) {
            personNames.add(p.getName());
        }

        Intent i = new Intent(context, PersonsActivity.class);
        i.putExtra("Persons", personNames);
        context.startActivity(i);
        return null;*/
        return null;
    }
}
