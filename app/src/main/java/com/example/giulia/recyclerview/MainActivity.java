package com.example.giulia.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    int n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView myRecyclerView = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);
        Adapter myAdapter = new Adapter(getApplicationContext());
        myRecyclerView.setAdapter(myAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        RecyclerView myRecyclerView = (RecyclerView) findViewById(R.id.rv);
        if (n % 2 == 0) {
            LinearLayoutManager myLayoutManager = new GridLayoutManager(this, 2);
            myRecyclerView.setLayoutManager(myLayoutManager);
            Adapter myAdapter = new Adapter(getApplicationContext());
            myRecyclerView.setAdapter(myAdapter);
            n += 1;
        } else {
            LinearLayoutManager myLayoutManager = new LinearLayoutManager(this);
            myRecyclerView.setLayoutManager(myLayoutManager);
            Adapter myAdapter = new Adapter(getApplicationContext());
            myRecyclerView.setAdapter(myAdapter);
            n += 1;
        }

        return false;
    }
}
