package com.example.nikes.assignment5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CampusList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus_list);

        final ListView camList = findViewById(R.id.lvCampus);

        final String[] centennial = {"Progress Campus", "Morningside Campus", "Ashtonbee Campus", "Story Arts Campus"};
        final String[] seneca = {"Jane Campus", "King Campus", "Markham Campus", "Newnham Campus", "Scarborough Campus"};
        final String[] humber = {"North Campus", "Lakeshore Campus", "Orangeville Campus"};
        final String[] sheridan = { "Davis Campus","Hazel McCallion Campus","Trafalgar Capus" };

        TextView textViewName = findViewById(R.id.txtClgName);
        Intent i = getIntent();

        String name = i.getStringExtra("name");
        textViewName.setText(name);

        String clg = textViewName.getText().toString();
        Log.i("Test",clg);
        //String c = "Centennial College";
        if(clg.equalsIgnoreCase("Centennial College"))
        {
            Log.i("Test1","Pass");
            ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,centennial);
            camList.setAdapter(myAdapter);
        }
        else if(clg.equalsIgnoreCase("Seneca College"))
        {
            ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,seneca);
            camList.setAdapter(myAdapter);
        }
        else if(clg.equalsIgnoreCase("Humber College"))
        {
            ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,humber);
            camList.setAdapter(myAdapter);
        }
        else if(clg.equalsIgnoreCase("Sheridan College"))
        {
            ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,sheridan);
            camList.setAdapter(myAdapter);
        }

        camList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected =(String) camList.getItemAtPosition(position);

                Intent intent = new Intent(CampusList.this, CampusLocation.class);
                intent.putExtra("name",selected);
                startActivity(intent);
            }
        });

    }
}
