package com.masss.porashona;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class ChapterListAdapter extends RecyclerView.Adapter<ChapterListAdapter.ChapterListHolder> {

    ArrayList<ChapterItemModel> data;
    Context context;

    public ChapterListAdapter(ArrayList<ChapterItemModel> data,Context context)
    {
        this.data=data;
        this.context=context;
    }


    @NonNull
    @Override
    public ChapterListAdapter.ChapterListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.chapter_list_item,parent,false);
        return new ChapterListAdapter.ChapterListHolder(view);
    }

    public void onBindViewHolder(@NonNull final ChapterListAdapter.ChapterListHolder holder, int position) {




        holder.img.setImageResource(data.get(position).getImage_id());
        holder.tv.setText(data.get(position).getName());
        holder.tvloc.setText(data.get(position).getLocation());

        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context,ChapterOptionActivity.class);
                i.putExtra("path",holder.tvloc.getText());
                //Toast.makeText(context,context.toString(),Toast.LENGTH_LONG).show();
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }


    class ChapterListHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView tv;
        TextView tvloc;
        public ChapterListHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.chapter_image);
            tv=itemView.findViewById(R.id.chapter_name);
            tvloc=itemView.findViewById(R.id.chapter_location);
        }

    }
}
