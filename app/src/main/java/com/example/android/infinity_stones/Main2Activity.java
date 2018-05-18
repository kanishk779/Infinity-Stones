package com.example.android.infinity_stones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //OBTAINING THE ARRAY_LIST FROM MAIN_ACTIVITY
        ArrayList<String> ar1=getIntent().getExtras().getStringArrayList("list");

        //CREATING OBJECT OF ARRAY_ADAPTER CLASS
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ar1);

        ListView listView = (ListView) findViewById(R.id.simple_list_view);

        //ASSOCIATING THE ARRAY_ADAPTER WITH THE LIST VIEW
        listView.setAdapter(itemsAdapter);
    }


}
