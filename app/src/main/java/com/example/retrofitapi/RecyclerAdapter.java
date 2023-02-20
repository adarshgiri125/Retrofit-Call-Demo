package com.example.retrofitapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.viewHolder>{

    private List<RetrofitData> data;

    public RecyclerAdapter(List<RetrofitData> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        holder.text1.setText("" + data.get(position).getUserId());
        holder.text2.setText("" + data.get(position).getId());
        holder.text3.setText("" + data.get(position).getTitle());
        holder.text4.setText("" + data.get(position).getSubTitle());

    }

    @Override
    public int getItemCount() {
        return data.size() ;
    }

    public class viewHolder extends RecyclerView.ViewHolder{

          TextView text1,text2,text3, text4;

         public viewHolder(@NonNull View itemView) {
            super(itemView);

             text1 = itemView.findViewById(R.id.textView);
             text2 = itemView.findViewById(R.id.textView1);
             text3 = itemView.findViewById(R.id.textView2);
             text4 = itemView.findViewById(R.id.textView3);
        }
    }
}
