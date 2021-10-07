package com.masss.porashona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAdOptions;
import com.adcolony.sdk.AdColonyAdSize;
import com.adcolony.sdk.AdColonyAdView;
import com.adcolony.sdk.AdColonyAdViewListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyCoinsActivity extends AppCompatActivity {
    private TextView tvc;
    private Button btn;
    private final String APP_ID="appef96ecb5130c4cabaa";
    private final String BANNER_ZONE_ID ="vzc70236870f27417bb3";
    private AdColonyAdOptions adColonyAdOptions;
    private AdColonyAdView colonyAdView;
    private RelativeLayout adContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_coins);


        //Adcolony add
//        final Handler handler=new Handler();
//        final Runnable r = new Runnable(){
//            public void run() {
//                AdColony.configure(MyCoinsActivity.this,APP_ID,BANNER_ZONE_ID);
//                AdColonyAdViewListener listener=new AdColonyAdViewListener() {
//                    @Override
//                    public void onRequestFilled(AdColonyAdView adColonyAdView) {
//                        adContainer=findViewById(R.id.ad_container_my_coins);
//                        adContainer.addView(adColonyAdView);
//                        colonyAdView=adColonyAdView;
//                    }
//                };
//                AdColony.requestAdView(BANNER_ZONE_ID,listener, AdColonyAdSize.BANNER);
//                handler.postDelayed(this, 10000);
//            }
//        };
//        handler.post(r);


        SharedPreferences sp =getApplicationContext().getSharedPreferences("userdata", 0);
        final String classval = sp.getString("class", "");

        final FirebaseFirestore db;
        db = FirebaseFirestore.getInstance();

        final FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        final String email=currentUser.getEmail();




        tvc=findViewById(R.id.mycoinstv);
        tvc.setText("No Data Present");
        btn=findViewById(R.id.fetchcoins);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    DocumentReference docRef = db.collection("coindata"+classval).document(email);
                    docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot document = task.getResult();
                                if (document.exists()) {
                                    String c=document.getString("coins");
                                    Toast.makeText(getApplicationContext(),c,Toast.LENGTH_SHORT).show();
                                    tvc.setTextColor(getApplicationContext().getResources().getColor(R.color.colorAccent));
                                    tvc.setText("Coins: " + c);
                                    //g.d(TAG, "DocumentSnapshot data: " + document.getData());
                                } else {
                                    Toast.makeText(getApplicationContext(),"Failed to fetch coin data",Toast.LENGTH_SHORT).show();
                                    //Log.d(TAG, "No such document");
                                }
                            } else {
                                //Log.d(TAG, "get failed with ", task.getException());
                            }
                        }
                    });



            }
        });

    }

    long findDifference(String start_date,
                   String end_date)
    {

        // SimpleDateFormat converts the
        // string format to date object
        SimpleDateFormat sdf
                = new SimpleDateFormat(
                "dd-MM-yyyy HH:mm:ss");

        // Try Block
        try {

            // parse method is used to parse
            // the text from a string to
            // produce the date
            java.util.Date d1 = sdf.parse(start_date);
            java.util.Date d2 = sdf.parse(end_date);

            // Calucalte time difference
            // in milliseconds
            long difference_In_Time
                    = d2.getTime() - d1.getTime();

            // Calucalte time difference in
            // seconds, minutes, hours, years,
            // and days


            long difference_In_Hours
                    = (difference_In_Time
                    / (1000 * 60 * 60))
                    % 24;

            // Print the date difference in
            // years, in days, in hours, in
            // minutes, and in seconds
            return difference_In_Hours;

        }

        // Catch the Exception
        catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}