package com.masss.porashona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MyProgressActivity extends AppCompatActivity {

    private RecyclerView rcv;
    private Button qphy,qlife,qmath,qchem,qweak,qstrong;
    private Cursor csr;
    ArrayList<TestItemModel> arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_progress);
        final DbManager dbManager=new DbManager(this);
        qmath=findViewById(R.id.querymath);
        qphy=findViewById(R.id.queryphy);
        qlife=findViewById(R.id.querylife);
        qchem=findViewById(R.id.querychem);
        qweak=findViewById(R.id.queryweak);
        qstrong=findViewById(R.id.querystrong);

        csr=dbManager.getData("");

        rcv=findViewById(R.id.progressrcv);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        rcv.setLayoutManager(layoutManager);

//        dbManager.addRecord("alo1","phy",200,50,10,8,2);
//        dbManager.addRecord("cholon1","life",100,60,50,8,10);
//
//        dbManager.addRecord("protisoron1","phy",50,10,20,4,2);
//
//        dbManager.addRecord("onupat1","math",40,39,10,8,2);
         arr = new ArrayList<>();


        qmath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                csr=dbManager.getData("math");
                rcv.setAdapter(new TestListAdapter(getData(csr),MyProgressActivity.this));
            }
        });
        qphy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                csr=dbManager.getData("phy");
                rcv.setAdapter(new TestListAdapter(getData(csr),MyProgressActivity.this));
            }
        });
        qlife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                csr=dbManager.getData("life");
                rcv.setAdapter(new TestListAdapter(getData(csr),MyProgressActivity.this));
            }
        });
        qchem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                csr=dbManager.getData("chem");
                rcv.setAdapter(new TestListAdapter(getData(csr),MyProgressActivity.this));
            }
        });

        qweak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(arr,new TestItemModel.WeakSortingComparator());

                rcv.setAdapter(new TestListAdapter(arr,MyProgressActivity.this));
            }
        });

        qstrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(arr,new TestItemModel.StrongSortingComparator());
                rcv.setAdapter(new TestListAdapter(arr,MyProgressActivity.this));
            }
        });

        rcv.setAdapter(new TestListAdapter(getData(csr),MyProgressActivity.this));
    }

    private ArrayList<TestItemModel> getData(Cursor csr) {
        arr = new ArrayList<>();

        Integer i=new Integer(0);

        if(true)
        {
            while(csr.moveToNext())
            {
                TestItemModel test=new TestItemModel(csr.getString(0),csr.getString(1),csr.getInt(2),csr.getInt(3),csr.getInt(4),csr.getInt(5),csr.getInt(6));
                arr.add(test);
                i++;

            }
        }

        //Toast.makeText(getApplicationContext(),i.toString(),Toast.LENGTH_LONG).show();
        return arr;
    }



}