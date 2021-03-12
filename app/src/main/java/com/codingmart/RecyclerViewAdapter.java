package com.codingmart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public  class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ClubViewHolder> {

    List<Recycle.club> courses;

    RecyclerViewAdapter(List<Recycle.club> courses){
        this.courses = courses;
    }
    public static class  ClubViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView textView;
        ImageView imageView;

        ClubViewHolder(View itemView){
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview);
            textView = itemView.findViewById(R.id.clubname);
            imageView = itemView.findViewById(R.id.logo);
        }
    }

    @NonNull
    @Override
    public ClubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout,parent,false);


        return new ClubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubViewHolder holder, int position) {
        holder.textView.setText(courses.get(position).name);
        holder.imageView.setImageResource(courses.get(position).logoId);

    }



    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {

        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }
}
