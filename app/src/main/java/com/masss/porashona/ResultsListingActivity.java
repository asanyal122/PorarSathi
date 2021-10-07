package com.masss.porashona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import static com.google.firebase.storage.FirebaseStorage.getInstance;

public class ResultsListingActivity extends AppCompatActivity {
    private LinearLayout l;
    private int j;
    private InterstitialAd mInterstitialAd;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_listing);
        String path=getIntent().getStringExtra("path");

        final StorageReference listRef = getInstance().getReference().child(path);
        l=findViewById(R.id.linres);



        j=0;


        listRef.listAll()
                .addOnSuccessListener(new OnSuccessListener<ListResult>() {
                    @Override
                    public void onSuccess(ListResult listResult) {


                        for (final StorageReference item : listResult.getItems()) {



                            item.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {



                                    if(findViewById(R.id.txt) != null)
                                    {
                                        TextView t=findViewById(R.id.txt);
                                        l.removeView(t);
                                    }


                                    final Button btn=new Button(getApplicationContext());
                                    final Space spc=new Space(getApplicationContext());

                                    btn.setTag(uri.toString());
                                    String btnname=item.getName();
                                    String btnnewname=btnname.substring(0,btnname.length()-5);
                                    btn.setText(btnnewname);


                                    btn.setBackgroundResource(R.drawable.btn_grad_purple);

                                    btn.setTextColor(getResources().getColor(R.color.colorWhite));
                                    btn.setTextSize(20);

                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {

                                            Intent i=new Intent(ResultsListingActivity.this,MyWebActivityForResults.class);
                                            i.putExtra("fileurl",btn.getTag().toString());
                                            startActivity(i);

                                        }
                                    });
                                    spc.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                                    spc.getLayoutParams().height=20;

                                    btn.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));



                                    l.addView(spc);
                                    l.addView(btn);

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                }
                            });

                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Uh-oh, an error occurred!
                    }
                });




        final Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(findViewById(R.id.txt) != null)
                {
                    TextView t=findViewById(R.id.txt);
                    t.setText("Will be available soon!");
                    t.setTextColor(getResources().getColor(R.color.colorFacebook));
                }
            }
        },10000);



    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();

    }



}


