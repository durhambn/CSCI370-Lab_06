package com.introtoandroid.lab6.asyncs;

import android.os.AsyncTask;

import com.introtoandroid.lab6.data.LabDatabase;
import com.introtoandroid.lab6.entities.Person;

public class insert extends AsyncTask<Person, Void, Void> {


        private LabDatabase database;
        public insert(LabDatabase database) {
            this.database = database;
        }
        @Override
        protected Void doInBackground(Person... people) {
            database.personDao().insertPerson(people[0]);
            return null;
        }

}
