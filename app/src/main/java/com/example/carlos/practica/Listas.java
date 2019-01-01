package com.example.carlos.practica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Listas extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private View.OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);

        final List<String> names = new ArrayList<>();
        Button agregar = findViewById(R.id.button2);
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                names.add("carlos " + names.size());
                mAdapter.notifyItemInserted(names.size());
            }
        });


        mRecyclerView = findViewById(R.id.recyclerView);

        /*DividerItemDecoration itemDecor = new DividerItemDecoration(mRecyclerView.getContext(), DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecor);*/

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
               //  Toast.makeText(MainActivity.this, String.valueOf(pos), Toast.LENGTH_SHORT).show();
                names.remove(pos);
                mAdapter.notifyItemRemoved(pos);


            }

            @Override
            public void onLongClick(View v, int pos) {
                Toast.makeText(Listas.this, "long click", Toast.LENGTH_SHORT).show();
            }
        });

        mRecyclerView.setAdapter(mAdapter);
    }
    public interface RecyclerOnClickListener{
         void onClick(View v, int pos);
         void onLongClick(View v , int pos);
    }
}
