package com.example.nikes.assignment5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class CollegeList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_list);

//        Spinner spinner = (Spinner) findViewById(R.id.clgs);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.clg_array, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);



        String[] colgs = {"Centennial College", "Seneca College", "Humber College", "Sheridan College"};
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>( this, android.R.layout.simple_list_item_1,colgs);

        final ListView clgList = findViewById(R.id.lvClg);

        clgList.setAdapter(myAdapter);

        clgList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected =(String) clgList.getItemAtPosition(position);

                Intent intent = new Intent(CollegeList.this, CampusList.class);
                intent.putExtra("name",selected);
                startActivity(intent);
            }
        });




    }
}
