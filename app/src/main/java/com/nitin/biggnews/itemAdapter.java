package com.nitin.biggnews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ModelClass> arrayList;

    public itemAdapter(Context context, ArrayList<ModelClass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public itemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.itemlayout,null,false);

        return new itemAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull itemAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.itemCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, webView.class);
                intent.putExtra("url",arrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });


        holder.mHeading.setText(arrayList.get(position).getTitle());
        holder.mPublished.setText(arrayList.get(position).getPublishedAt());
        holder.mDescription.setText(arrayList.get(position).getDescription());
        holder.mAuthor.setText(arrayList.get(position).getAuthor());
        Glide.with(context).load(arrayList.get(position).getUrlToImage()).into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mHeading,mDescription,mPublished,mAuthor;
        ImageView mImageView;
        CardView itemCardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mHeading=itemView.findViewById(R.id.mHeading);
            mDescription=itemView.findViewById(R.id.mDescription);
            mPublished=itemView.findViewById(R.id.mPublished);
            mAuthor=itemView.findViewById(R.id.mAuthor);
            mImageView=itemView.findViewById(R.id.mImageView);
            itemCardView=itemView.findViewById(R.id.itemCardView);

        }
    }
}
