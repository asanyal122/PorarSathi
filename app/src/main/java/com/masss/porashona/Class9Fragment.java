package com.masss.porashona;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Class9Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Class9Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private int clickeditemid;



    public Class9Fragment(int clickeditemid) {
        // Required empty public constructor
        this.clickeditemid=clickeditemid;
    }
    public Class9Fragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Class9Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Class9Fragment newInstance(String param1, String param2,int clickeditemid) {
        Class9Fragment fragment = new Class9Fragment(clickeditemid);
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_class9, container, false);
        HomeActivity home=(HomeActivity) getActivity();
        Context context=getContext();
        RecyclerView recyclerView=view.findViewById(R.id.rcv);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(context,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(new PorarSathiGridAdapter(getData(clickeditemid,view),getContext()));
        return view;
    }

    private ArrayList<GridItemModel> getData(int id,View view) {


        ArrayList<GridItemModel> arr=new ArrayList<>();
        TextView tv=view.findViewById(R.id.class_header);

        switch(id){
            case R.id.menu_class9:
                arr.add(new GridItemModel(R.string.class_9,R.string.submath,R.drawable.ic_math));
                arr.add(new GridItemModel(R.string.class_9,R.string.subphy,R.drawable.ic_thermo));
                arr.add(new GridItemModel(R.string.class_9,R.string.sublife,R.drawable.ic_tree));
                arr.add(new GridItemModel(R.string.class_9,R.string.mock,R.drawable.ic_bulb));
                tv.setText(R.string.class_9_b);

                break;

            case R.id.menu_class10:
                arr.add(new GridItemModel(R.string.class_10,R.string.submath,R.drawable.ic_math));
                arr.add(new GridItemModel(R.string.class_10,R.string.subphy,R.drawable.ic_thermo));
                arr.add(new GridItemModel(R.string.class_10,R.string.sublife,R.drawable.ic_tree));
                arr.add(new GridItemModel(R.string.class_10,R.string.mock,R.drawable.ic_bulb));
                tv.setText(R.string.class_10_b);
                break;

            case R.id.menu_class12:
                arr.add(new GridItemModel(R.string.class_12,R.string.submath,R.drawable.ic_math));
                arr.add(new GridItemModel(R.string.class_12,R.string.subphysics,R.drawable.ic_thermo));
                arr.add(new GridItemModel(R.string.class_12,R.string.subbio,R.drawable.ic_tree));
                arr.add(new GridItemModel(R.string.class_12,R.string.subchem,R.drawable.ic_water_drop));
                arr.add(new GridItemModel(R.string.class_12,R.string.mock,R.drawable.ic_bulb));
                tv.setText(R.string.class_12_b);
                break;

            case R.id.menu_neet:
                arr.add(new GridItemModel(R.string.neet,R.string.subphysics,R.drawable.ic_thermo));
                arr.add(new GridItemModel(R.string.neet,R.string.subbio,R.drawable.ic_tree));
                arr.add(new GridItemModel(R.string.neet,R.string.subchem,R.drawable.ic_water_drop));
                arr.add(new GridItemModel(R.string.neet,R.string.mock,R.drawable.ic_bulb));
                tv.setText(R.string.neet);
                break;

            case R.id.menu_jenpauh:
                arr.add(new GridItemModel(R.string.bscnur,R.string.subphysics,R.drawable.ic_thermo));
                arr.add(new GridItemModel(R.string.bscnur,R.string.subbio,R.drawable.ic_tree));
                arr.add(new GridItemModel(R.string.bscnur,R.string.subchem,R.drawable.ic_water_drop));
                arr.add(new GridItemModel(R.string.bscnur,R.string.mock,R.drawable.ic_bulb));
                tv.setText(R.string.bscnur);
                break;
        }



        return arr;
    }


    public void fun(View v)
    {
        Intent i = new Intent(getActivity(),Main2Activity.class);
        startActivity(i);
    }

}