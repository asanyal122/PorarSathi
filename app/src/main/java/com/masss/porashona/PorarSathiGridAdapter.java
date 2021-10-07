package com.masss.porashona;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PorarSathiGridAdapter extends RecyclerView.Adapter<PorarSathiGridAdapter.Holder> {
    ArrayList<GridItemModel> data;
    Context context;

    PorarSathiGridAdapter(ArrayList<GridItemModel> data, Context context)
    {
        this.data=data;
        this.context=context;
    }



    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.grid_item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {

        final int image_id=data.get(position).getImage_id();
        final int subject_name=data.get(position).getName();
        final int class_id=data.get(position).getClass_id();

        holder.img.setImageResource(image_id);
        holder.tv.setText(subject_name);
        holder.tvclass.setText(class_id);

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sub =context.getApplicationContext().getResources().getString(subject_name);
                //Toast.makeText(context.getApplicationContext(), "i1", Toast.LENGTH_SHORT).show();
                if(sub.equals("Mock Test"))
                {

                    SharedPreferences sharedPreferences;
                    sharedPreferences =context.getApplicationContext().getSharedPreferences("userdata", 0);
                    String classval = sharedPreferences.getString("class", "");

                    Intent i1=new Intent(context.getApplicationContext(),StorageListingActivity.class);
                    i1.putExtra("path","class"+classval+"/mock/rated/");
                    i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    //Toast.makeText(context.getApplicationContext(), "i1", Toast.LENGTH_SHORT).show();
                    context.getApplicationContext().startActivity(i1);
                }
                else
                {
                    Intent i2=new Intent(context.getApplicationContext(),ChapterListActivity.class);
                    i2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i2.putExtra("subject_image_id",image_id);
                    i2.putExtra("subject_id",subject_name);
                    i2.putExtra("class_id",class_id);
                    //Toast.makeText(context.getApplicationContext(), "i2", Toast.LENGTH_SHORT).show();
                    context.getApplicationContext().startActivity(i2);
                }



            }
        });
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }



    class Holder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv,tvclass;
        public Holder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            tv=itemView.findViewById(R.id.txt);
            tvclass=itemView.findViewById(R.id.class_text);
        }
    }

}
