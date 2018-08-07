package com.example.a17010233.dynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1;
    Spinner spn2;
    Button btnUpdate;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.buttonUpdate);


        /*
        alNumbers.add("2");
        alNumbers.add("4");
        alNumbers.add("6");
        */

        alNumbers = new ArrayList<>();
        aaNumbers = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, alNumbers);


        String[] strNumbers = getResources().getStringArray(R.array.even);
        alNumbers.addAll(Arrays.asList(strNumbers));

        spn2.setAdapter(aaNumbers);



        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear();

                if(pos == 0) {
                    String[] strNumbers = getResources().getStringArray(R.array.even);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                } else {
                    String[] strNumbers = getResources().getStringArray(R.array.odd);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                }
                aaNumbers.notifyDataSetChanged();
            }
        });




        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        alNumbers.clear();
                        spn2.setSelection(2);
                        String[] evenNumbers = getResources().getStringArray(R.array.even);
                        alNumbers.addAll(Arrays.asList(evenNumbers));

                        break;

                    case 1:
                        alNumbers.clear();
                        spn2.setSelection(1);
                        String[] oddNumbers = getResources().getStringArray(R.array.odd);
                        alNumbers.addAll(Arrays.asList(oddNumbers));
                        break;
                }
                aaNumbers.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}
