package com.masss.porashona;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class TestListAdapter extends RecyclerView.Adapter<TestListAdapter.TestListHolder>{

    ArrayList<TestItemModel> data;
    Context context;
    public TestListAdapter(ArrayList<TestItemModel> data, Context context)
    {
        this.data=data;
        this.context=context;
    }


    @NonNull
    @Override
    public TestListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.test_list_item,parent,false);
        return new TestListAdapter.TestListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestListHolder holder, int position) {

        ArrayList<PieEntry> pieEntries=new ArrayList<>();
        pieEntries.add(new PieEntry(data.get(position).correctattempt,"Correct"));
        pieEntries.add(new PieEntry(data.get(position).wrongattempt,"Wrong"));
        pieEntries.add(new PieEntry(data.get(position).unattempt,"Left"));

        PieDataSet dataSet = new PieDataSet(pieEntries, data.get(position).id);
        dataSet.setColors(Color.rgb(167,245,66),Color.rgb(245,66,102),Color.rgb(0,155,155));
        PieData pieData = new PieData(dataSet);
        pieData.setValueTextSize(12f);
        holder.pieChart.setData(pieData);
        holder.pieChart.setDrawEntryLabels(false);
        Float obt=Float.parseFloat(String.valueOf(data.get(position).obtainedmarks));
        Float tot=Float.parseFloat(String.valueOf(data.get(position).totalmarks));
        Float percnt=(obt/tot)*100;
        percnt= new Float(Math.round((percnt*100.0)/100.0));
        Description description=new Description();
        String chapterename=data.get(position).id;
        String testno=chapterename.replaceAll("[a-z]","");
        chapterename=chapterename.replaceAll("[0-9]","");
        String strid=chapterename+"b";
        Toast.makeText(context, strid, Toast.LENGTH_LONG).show();
        //String chaptername=context.getApplicationContext().getResources().getString(context.getResources().getIdentifier(strid,"string",context.getPackageName()));
        description.setText(chapterename+testno+" "+percnt.toString()+"%");
        description.setTextSize(15f);
        description.setTextColor(Color.rgb(160,18,196));

        holder.pieChart.setDescription(description);

        //dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        Legend legend=holder.pieChart.getLegend();
        legend.setEnabled(true);
        legend.setTextSize(15f);


        holder.pieChart.animateXY(1000, 1000);

    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    class TestListHolder extends RecyclerView.ViewHolder{

        PieChart pieChart;
        public TestListHolder(@NonNull View itemView) {
            super(itemView);
            pieChart=itemView.findViewById(R.id.piechart);
        }
    }
}
