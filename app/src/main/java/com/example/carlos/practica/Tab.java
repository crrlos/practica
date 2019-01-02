package com.example.carlos.practica;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Tab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("toolbar :)");
        setSupportActionBar(toolbar);


        TabLayout tab = findViewById(R.id.tabs);


        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment());
        adapter.addFragment(new Tab2Fragment());
        adapter.addFragment(new Tab3Fragment());

        ViewPager pager = findViewById(R.id.pager);
        pager.setAdapter(adapter);

        tab.setupWithViewPager(pager);

    }

}
