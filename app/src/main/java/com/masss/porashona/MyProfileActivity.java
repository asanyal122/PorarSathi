package com.masss.porashona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyProfileActivity extends AppCompatActivity {
    private EditText nameedittext,classedittext,schooledittext;
    private SharedPreferences sp;
    Button upd;
    DbManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        nameedittext=findViewById(R.id.nameedittext);
        classedittext=findViewById(R.id.classedittext);
        schooledittext=findViewById(R.id.schooledittext);
        dbManager=new DbManager(this);
        upd=findViewById(R.id.updateprofile);


        sp=getApplication().getSharedPreferences("userdata", Context.MODE_PRIVATE);
        final String name=sp.getString("studentname","");
        final String classval=sp.getString("class","");
        final String school=sp.getString("school","");
        nameedittext.setText(name);
        classedittext.setText(classval);
        schooledittext.setText(school);



        upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sp.edit();

                String name1=nameedittext.getText().toString();
                String school1=schooledittext.getText().toString();
                String class1=classedittext.getText().toString();

                if(!class1.equals(classval))
                {
                    if(class1.equals("9") || class1.equals("10") || class1.equals("12"))
                    {
                        editor.putString("class",class1);
                        editor.apply();
                        classedittext.setText(sp.getString("class",""));
                        dbManager.dropTable();
                        Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"ENTER VALID CLASS",Toast.LENGTH_LONG).show();
                    }
                }

                if(!name1.equals(name))
                {
                    if(name1.length()>2)
                    {
                        editor.putString("studentname",name1);
                        editor.apply();
                        nameedittext.setText(sp.getString("studentname",""));
                        Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"ENTER VALID NAME",Toast.LENGTH_LONG).show();
                    }
                }

                if(!school1.equals(school))
                {
                    if(school1.length()>2)
                    {
                        editor.putString("school",school1);
                        editor.apply();
                        schooledittext.setText(sp.getString("school",""));
                        Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"ENTER VALID SCHOOL",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

        //Toast.makeText(this,name,Toast.LENGTH_LONG).show();
    }
}