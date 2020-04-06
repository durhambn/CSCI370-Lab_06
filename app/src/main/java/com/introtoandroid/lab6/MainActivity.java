package com.introtoandroid.lab6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Contacts;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.introtoandroid.lab6.asyncs.insert;
import com.introtoandroid.lab6.asyncs.pull;
import com.introtoandroid.lab6.data.LabDatabase;
import com.introtoandroid.lab6.entities.Person;
import com.introtoandroid.lab6.entities.PersonsActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText nameField;
    Button submit;
    Button show;
    LabDatabase labDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = (EditText) findViewById(R.id.nameField);
        submit = (Button) findViewById(R.id.submit);
        show = (Button) findViewById(R.id.show);

        labDB = Room.databaseBuilder(this, LabDatabase.class, "Person")
                .build();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameField.getText().toString();
                Toast t = Toast.makeText(getApplicationContext(), "submit: " + name, Toast.LENGTH_LONG);
                t.show();
                Person p = new Person();
                p.setName(name);
                nameField.getText().clear();
                insert i = new insert(labDB);
                i.execute(p);
                /*new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Person person =new Person();
                        person.setName(name);
                        labDatabase.personDao().insertPerson(person);
                    }
                }) .start();*/
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast t = Toast.makeText(getApplicationContext(), "show button clicked", Toast.LENGTH_LONG);
                t.show();
                //List<Person> pp = labDB.personDao().getAllPersons();
                //List<Person> pp = new ArrayList<Person>();
                //pp.add(labDB.personDao().getAllPersons());
               // List<> = new List<>()labDB.personDao().getAllPersons();
                pull p = new pull(labDB, getApplicationContext());
                p.execute();
                Intent i = new Intent(MainActivity.this, PersonsActivity.class);
                startActivity(i);
            }
        });

    }
}
