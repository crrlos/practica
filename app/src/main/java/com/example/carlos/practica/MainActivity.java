package com.example.carlos.practica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private View.OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] names =
                {
                        "carlos","alberto","alberto","alberto","alberto","alberto",
                "alberto","alberto","alberto","alberto","alberto","alberto","alberto","alberto",
                "alberto","alberto","alberto","alberto","alberto","alberto","alberto","alberto",
                "alberto","alberto","alberto","alberto","alberto","alberto","alberto","alberto"};

        mRecyclerView = findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(names, new RecyclerOnClickListener() {
            @Override
            public void onClick(View v, int pos) {
                Toast.makeText(MainActivity.this, String.valueOf(pos), Toast.LENGTH_SHORT).show();
            }
        });

        mRecyclerView.setAdapter(mAdapter);
    }
    public interface RecyclerOnClickListener{
         void onClick(View v, int pos);
    }
}
