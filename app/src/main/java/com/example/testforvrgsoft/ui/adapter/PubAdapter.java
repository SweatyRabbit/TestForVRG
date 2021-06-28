package com.example.testforvrgsoft.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.testforvrgsoft.Application;
import com.example.testforvrgsoft.R;
import com.example.testforvrgsoft.interfaces.OnPhotoClickListener;
import com.example.testforvrgsoft.models.PostBody;

import java.util.ArrayList;

public class PubAdapter extends RecyclerView.Adapter<PubAdapter.ViewHolder> {
    private final ArrayList<PostBody> publications;
    private final OnPhotoClickListener onPhotoClickListener;

    public PubAdapter(ArrayList<PostBody> publications, OnPhotoClickListener onPhotoClickListener) {
        this.publications = publications;
        this.onPhotoClickListener = onPhotoClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PubAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pub, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PubAdapter.ViewHolder holder, int position) {
        holder.getAuthor().setText(publications.get(position).getData().getAuthor_fullname());
        holder.getComments().setText(String.valueOf(publications.get(position).getData().getNum_comments()));
        holder.getHours().setText(String.format(Application.getContext().getString(R.string.hours_ago), publications.get(position).getData().getCreated()));
        if (publications.get(position).getData().getThumbnail().startsWith("https")) {
            Glide
                    .with(Application.getContext())
                    .load(publications.get(position).getData().getThumbnail())
                    .into(holder.getPhoto());
        }

        holder.getPhoto().setOnClickListener(v -> {
            if (publications.get(position).getData().getThumbnail().startsWith("https")) {
                onPhotoClickListener.onPhotoClick(publications.get(position).getData().getThumbnail());
            }
        });

    }

    @Override
    public int getItemCount() {
        return publications.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView author;
        private final TextView comments;
        private final AppCompatImageView photo;
        private final TextView hours;

        public ViewHolder(View view) {
            super(view);
            author = view.findViewById(R.id.author);
            comments = view.findViewById(R.id.comments);
            photo = view.findViewById(R.id.photo);
            hours = view.findViewById(R.id.date);
        }

        public TextView getAuthor() {
            return author;
        }

        public TextView getComments() {
            return comments;
        }

        public AppCompatImageView getPhoto() {
            return photo;
        }

        public TextView getHours() {
            return hours;
        }
    }
}
