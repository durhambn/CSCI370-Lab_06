package com.introtoandroid.lab6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.introtoandroid.lab6.data.LabDatabase;
import com.introtoandroid.lab6.entities.Person;

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
            }
        });

    }
}
