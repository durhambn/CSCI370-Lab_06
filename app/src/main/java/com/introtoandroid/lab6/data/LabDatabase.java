package com.introtoandroid.lab6.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.introtoandroid.lab6.PersonDao;
import com.introtoandroid.lab6.entities.Person;

@Database(entities = {Person.class}, version = 1)
public abstract class LabDatabase extends RoomDatabase {

        public abstract PersonDao personDao();

}
