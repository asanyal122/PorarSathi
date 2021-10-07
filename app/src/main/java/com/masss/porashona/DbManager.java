package com.masss.porashona;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DbManager extends SQLiteOpenHelper
{
    private static final String dbname="myprogress.db";
    private SQLiteDatabase db;
    Context context;
    SQLiteDatabase thisdb;
    public DbManager(Context context)
    {
        super(context,dbname,null,1);
        this.context=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        thisdb=db;
        String qry="create table progress (id string primary key,subject string,totalmarks integer,obtainedmarks integer,correctattempt integer,wrongattempt integer,unattempt integer)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table progress");
        onCreate(db);
    }

    public void dropTable()
    {
        if (db == null || !db.isOpen())
            db = getWritableDatabase();
        db.execSQL("DELETE FROM progress");
    }


    public String addRecord(String id,String subject,Integer totalmarks,Integer obtainedmarks,Integer correctattempt,Integer wrongattempt,Integer unattempt)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("id",id);
        cv.put("subject",subject);
        cv.put("totalmarks",totalmarks);
        cv.put("obtainedmarks",obtainedmarks);
        cv.put("correctattempt",correctattempt);
        cv.put("wrongattempt",wrongattempt);
        cv.put("unattempt",unattempt);
        long res=db.insert("progress",null,cv);
        if(res==-1)
        {
            return "Failed to save progress";
        }
        else
        {
            return "Added to My Progress";
        }

    }

    Cursor getData(String sub)
    {

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor crs;
        if(sub.equals(""))
        {
            crs=db.rawQuery("select * from progress",null);
        }
        else
        {

            crs=db.rawQuery("select * from progress where subject='"+sub+"' order by wrongattempt desc",null);
        }

        return crs;
    }
}
