package com.example.carlos.practica;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private List<String> mDataset;
    private MainActivity.RecyclerOnClickListener listener;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<String> myDataset, MainActivity.RecyclerOnClickListener listener) {
        mDataset = myDataset;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.elemento_lista,viewGroup,false);
        return new MyViewHolder(v,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
            viewHolder.mTextView.setText(mDataset.get(i));

    }


    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        MainActivity.RecyclerOnClickListener listener;
        // each data item is just a string in this case
        public TextView mTextView;
        public MyViewHolder(View v, final MainActivity.RecyclerOnClickListener listener) {
            super(v);
            mTextView = v.findViewById(R.id.lst_txtView);
            this.listener = listener;
            v.setOnClickListener(this);
            v.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onLongClick(v,getAdapterPosition());
                    return true;
                }
            });
        }

        @Override
        public void onClick(View v) {

            listener.onClick(v,this.getAdapterPosition());

        }
    }
}
