package com.example.francisco.lista.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.francisco.lista.R;

public class PostViewHolder extends RecyclerView.ViewHolder {

    TextView txt_title, txt_contet, txt_author;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);

        txt_title = (TextView)itemView.findViewById(R.id.txt_title);
        txt_contet = (TextView)itemView.findViewById(R.id.txt_author);
        txt_author = (TextView)itemView.findViewById(R.id.txt_author);





    }
}
