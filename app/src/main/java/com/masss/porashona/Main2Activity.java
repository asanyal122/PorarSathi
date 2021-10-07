package com.masss.porashona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Map;

public class Main2Activity extends AppCompatActivity {

    private Button b9phy,b9life,b9math,b10phy,b10life,b10math,b12phy,b12life,b12math,b12chem;
    private Button bneetratedmock,bnurratedmock,b9ratedmock,b10ratedmock,b12ratedmock;
    private Button bneetunratedmock,bnurunratedmock,b9unratedmock,b10unratedmock,b12unratedmock;
    Button btnupdates,btnresults,btnshare;
    private TextView tname;
    private FirebaseAuth mAuth;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        b9life=findViewById(R.id.btn9life);
        b9life.setTag("class9/life/");
        b9phy=findViewById(R.id.btn9phy);
        b9phy.setTag("class9/phy/");
        b9math=findViewById(R.id.btn9math);
        b9math.setTag("class9/math/");


        b10life=findViewById(R.id.btn10life);
        b10life.setTag("class10/life/");
        b10phy=findViewById(R.id.btn10phy);
        b10phy.setTag("class10/phy/");
        b10math=findViewById(R.id.btn10math);
        b10math.setTag("class10/math/");

        b12life=findViewById(R.id.btn12life);
        b12life.setTag("class12/life/");
        b12phy=findViewById(R.id.btn12phy);
        b12phy.setTag("class12/phy/");
        b12chem=findViewById(R.id.btn12chem);
        b12chem.setTag("class12/chem/");
        b12math=findViewById(R.id.btn12math);
        b12math.setTag("class12/math/");


        b9ratedmock=findViewById(R.id.btn9mockrated);
        b9ratedmock.setTag("class9/mock/rated/");
        b10ratedmock=findViewById(R.id.btn10mockrated);
        b10ratedmock.setTag("class10/mock/rated/");
        b12ratedmock=findViewById(R.id.btn12mockrated);
        b12ratedmock.setTag("class12/mock/rated/");
        bnurratedmock=findViewById(R.id.btnnurmockrated);
        bnurratedmock.setTag("nur/mock/rated/");
        bneetratedmock=findViewById(R.id.btnneetmockrated);
        bneetratedmock.setTag("neet/mock/rated/");


        b9unratedmock=findViewById(R.id.btn9mockunrated);
        b9unratedmock.setTag("class9/mock/unrated/");
        b10unratedmock=findViewById(R.id.btn10mockunrated);
        b10unratedmock.setTag("class10/mock/unrated/");
        b12unratedmock=findViewById(R.id.btn12mockunrated);
        b12unratedmock.setTag("class12/mock/unrated/");
        bnurunratedmock=findViewById(R.id.btnnurmockunrated);
        bnurunratedmock.setTag("nur/mock/unrated/");
        bneetunratedmock=findViewById(R.id.btnneetmockunrated);
        bneetunratedmock.setTag("neet/mock/unrated/");

        btnupdates=findViewById(R.id.btnupdates);
        btnupdates.setTag("update/");

        btnresults = findViewById(R.id.btnresults);
        btnresults.setTag("results/");

        btnshare=findViewById(R.id.btnshare);
        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ishare = new Intent(Intent.ACTION_SEND);
                ishare.setType("text/plain");
                String sharesub="Porar Sathi App";
                String sharebody = "https://play.google.com/store/apps/details?id=com.masss.porashona";
                ishare.putExtra(Intent.EXTRA_SUBJECT,sharesub);
                ishare.putExtra(Intent.EXTRA_TEXT,sharebody);
                startActivity(Intent.createChooser(ishare,"Share Using"));

            }
        });



        tname=findViewById(R.id.tname);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user!=null)
        {
            String welcometext="Welcome "+user.getDisplayName()+"..";
            tname.setText(welcometext);
            tname.setTextColor(getResources().getColor(R.color.colorWhite));
            //Toast.makeText(this,user.getEmail(),Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
        }



        //Notification Channel Register
        if(Build.VERSION.SDK_INT  >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("MyNotifications","MyNotifications", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        FirebaseMessaging.getInstance().subscribeToTopic("general")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Successful";
                        if (!task.isSuccessful()) {
                            msg = "Failed";
                        }
                        //Toast.makeText(Main2Activity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        //interstitial
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8853789616007557/6109842775");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());




    }



    public void fun(View v)
    {
        String s = ((Button)v).getTag().toString();
        final Intent i=new Intent(Main2Activity.this,StorageListingActivity.class);
        i.putExtra("path",s);


        SharedPreferences sharedPreferences = getSharedPreferences("BackPressCount",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        Integer cnt = sharedPreferences.getInt("cnt",0);
        Integer putcnt = (cnt+1)%7;
        myEdit.putInt("cnt",putcnt);
        myEdit.apply();


        //Toast.makeText(this,cnt.toString(),Toast.LENGTH_SHORT);
        if(cnt == 6)
        {
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();


                mInterstitialAd.setAdListener(new AdListener() {
                    @Override
                    public void onAdLoaded() {
                        // Code to be executed when an ad finishes loading.
                    }

                    @Override
                    public void onAdFailedToLoad(int errorCode) {
                        // Code to be executed when an ad request fails.

                    }

                    @Override
                    public void onAdOpened() {
                        // Code to be executed when the ad is displayed.

                    }

                    @Override
                    public void onAdClicked() {
                        // Code to be executed when the user clicks on an ad.

                    }

                    @Override
                    public void onAdLeftApplication() {
                        // Code to be executed when the user has left the app.
                    }

                    @Override
                    public void onAdClosed() {
                        // Code to be executed when the interstitial ad is closed.
                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                        startActivity(i);

                    }
                });



            } else {
                startActivity(i);
            }
        }
        else{
            startActivity(i);
        }
    }

    public void funres(View v)
    {
        String s = ((Button)v).getTag().toString();
        Intent i=new Intent(Main2Activity.this,ResultsListingActivity.class);
        i.putExtra("path",s);

        startActivity(i);
    }

}
