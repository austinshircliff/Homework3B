package com.example.shircliffa.homework3b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Homework3B extends AppCompatActivity {

    Button submitbtn;
    EditText name;
    EditText city;
    EditText state;
    EditText zip;
    String Input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework3_b);

        submitbtn = (Button) findViewById(R.id.submitBtn);
        name = (EditText) findViewById(R.id.enteredname);
        city = (EditText) findViewById(R.id.enteredcity);
        state = (EditText) findViewById(R.id.enteredstate);
        zip = (EditText) findViewById(R.id.enteredzip);
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Input = name.getText().toString() + city.getText().toString()
                        + name.getText().toString() + city.getText().toString();
                try {
                    FileOutputStream out = openFileOutput("output.txt",MODE_WORLD_READABLE);
                    OutputStreamWriter output = new OutputStreamWriter(out);

                    try {
                        output.write(Input);
                        output.flush();
                        output.close();
                        Toast.makeText(Homework3B.this, "Data Was Submitted", Toast.LENGTH_SHORT).show();
                        name.setText("");
                        city.setText("");
                        state.setText("");
                        zip.setText("");


                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
