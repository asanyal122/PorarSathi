package com.masss.porashona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ChapterOptionActivity extends AppCompatActivity {

    private ImageView itheory,ivideo,ipractice,iqa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_option);
        Intent previntent=getIntent();
        final String path=previntent.getStringExtra("path");
        itheory=findViewById(R.id.theory_image);
        itheory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ChapterOptionActivity.this,StorageListingActivity.class);
                i.putExtra("path",path+"theory/");
                startActivity(i);
            }
        });

        ivideo=findViewById(R.id.video_image);
        ivideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ChapterOptionActivity.this,StorageListingActivity.class);
                i.putExtra("path",path+"video/");
                startActivity(i);
            }
        });

        iqa=findViewById(R.id.saq_image);
        iqa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ChapterOptionActivity.this,StorageListingActivity.class);
                i.putExtra("path",path+"qa/");
                startActivity(i);
            }
        });



        ipractice=findViewById(R.id.test_image);
        ipractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ChapterOptionActivity.this,StorageListingActivity.class);
                i.putExtra("path",path+"practice/");
                startActivity(i);
            }
        });


    }
}