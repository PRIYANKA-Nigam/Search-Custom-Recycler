package com.example.searchcustomrecycler;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
ArrayList<Dish> arrayList=new ArrayList<>();

    public RecyclerAdapter(ArrayList<Dish> arrayList) {
        this.arrayList = arrayList;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        CardView cardView;
        Button b;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView=(CardView)itemView.findViewById(R.id.card);
            imageView=(ImageView)itemView.findViewById(R.id.img);
            textView=(TextView)itemView.findViewById(R.id.tt);
            b=(Button)itemView.findViewById(R.id.but);
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new MyViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
 holder.imageView.setImageResource(arrayList.get(position).getDish_id());
 holder.textView.setText(arrayList.get(position).getName());
 holder.b.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         Intent intent=new Intent(Intent.ACTION_SEND);
         intent.putExtra(Intent.EXTRA_TEXT,"Taste this dish and check it's cuisine  "+arrayList.get(holder.getAdapterPosition()).getDish_id()
         +"name  "+arrayList.get(holder.getAdapterPosition()).getName());
         intent.setType("text/plain");
         view.getContext().startActivity(Intent.createChooser(intent,"Send Through..."));
     }
 });
 holder.cardView.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         Intent intent=new Intent(view.getContext(),MainActivity2.class);
         intent.putExtra("Image",arrayList.get(holder.getAdapterPosition()).getDish_id());
         intent.putExtra("title",arrayList.get(holder.getAdapterPosition()).getName());
           view.getContext().startActivity(intent);
     }
 });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void setFilter(ArrayList<Dish> newList){
        arrayList=new ArrayList<>();
        arrayList.addAll(newList);
        notifyDataSetChanged();
    }
}
