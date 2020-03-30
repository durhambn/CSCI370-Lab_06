package com.introtoandroid.lab6;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.introtoandroid.lab6.entities.Person;

import java.util.List;

@Dao
public interface PersonDao {
    @Insert
    void insertPerson(Person person);

    @Query("SELECT * FROM Person")
    List<Person> getAllPersons();
}
