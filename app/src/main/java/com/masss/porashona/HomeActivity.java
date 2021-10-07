package com.masss.porashona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Rating;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    Toolbar toolbar;
    NavigationView nav;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    int clickeditemid;
    SharedPreferences sp;
    String classval;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nav=findViewById(R.id.navigationview);
        drawerLayout=findViewById(R.id.drawerlayout);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.draweropen,R.string.drawerclose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        sp=getApplication().getSharedPreferences("userdata", Context.MODE_PRIVATE);
        classval=sp.getString("class","");
        Fragment initialFragment;
        if(classval.equals("9"))
        {
            initialFragment=new Class9Fragment(R.id.menu_class9);
            getSupportFragmentManager().beginTransaction().replace(R.id.container,initialFragment).commit();
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else if(classval.equals("10"))
        {
            initialFragment=new Class9Fragment(R.id.menu_class10);
            getSupportFragmentManager().beginTransaction().replace(R.id.container,initialFragment).commit();
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else if(classval.equals("12"))
        {
            initialFragment=new Class9Fragment(R.id.menu_class12);
            getSupportFragmentManager().beginTransaction().replace(R.id.container,initialFragment).commit();
            drawerLayout.closeDrawer(GravityCompat.START);
        }


        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                clickeditemid=id;
                Fragment temp=new Class9Fragment(clickeditemid);
                switch (id)
                {
                    case R.id.menu_myprofile:
                        startActivity(new Intent(getApplicationContext(),MyProfileActivity.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu_myprogress:
                        startActivity(new Intent(getApplicationContext(),MyProgressActivity.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu_mycoins:
                        startActivity(new Intent(getApplicationContext(),MyCoinsActivity.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu_class9:
                        if(classval.equals("9"))
                        {
                            getSupportFragmentManager().beginTransaction().replace(R.id.container,temp).commit();
                            drawerLayout.closeDrawer(GravityCompat.START);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"You can not access other classes",Toast.LENGTH_LONG).show();
                        }
                        break;
                    case R.id.menu_class10:
                        if(classval.equals("10"))
                        {
                            getSupportFragmentManager().beginTransaction().replace(R.id.container,temp).commit();
                            drawerLayout.closeDrawer(GravityCompat.START);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"You can not access other classes",Toast.LENGTH_LONG).show();
                        }
                        break;
                    case R.id.menu_class12:
                        if(classval.equals("12"))
                        {
                            getSupportFragmentManager().beginTransaction().replace(R.id.container,temp).commit();
                            drawerLayout.closeDrawer(GravityCompat.START);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"You can not access other classes",Toast.LENGTH_LONG).show();
                        }

                        break;
                    case R.id.menu_neet:
                        if(classval.equals("12"))
                        {
                            getSupportFragmentManager().beginTransaction().replace(R.id.container,temp).commit();
                            drawerLayout.closeDrawer(GravityCompat.START);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"You can not access other classes",Toast.LENGTH_LONG).show();
                        }
                        break;
                    case R.id.menu_jenpauh:
                        if(classval.equals("12"))
                        {
                            getSupportFragmentManager().beginTransaction().replace(R.id.container,temp).commit();
                            drawerLayout.closeDrawer(GravityCompat.START);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"You can not access other classes",Toast.LENGTH_LONG).show();
                        }
                        break;
                    case R.id.menu_results:
                        Intent i=new Intent(HomeActivity.this,ResultsListingActivity.class);
                        i.putExtra("path","class"+classval+"/results/");
                        startActivity(i);
                        break;
                    case R.id.menu_notice:
                        Intent i2=new Intent(HomeActivity.this,ResultsListingActivity.class);
                        i2.putExtra("path","class"+classval+"/notice/");
                        startActivity(i2);
                        break;
                    case R.id.menu_signout:
                        FirebaseAuth.getInstance().signOut();
                        Intent i1=new Intent(HomeActivity.this,MainActivity.class);
                        i1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i1);
                        break;
                    case R.id.menu_rating:
//                        Intent i1=new Intent(getApplicationContext(),RatingActivity.class);
//                        startActivity(i1);

                        launchMarket();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu_share:
                        try {
                            Intent shareIntent = new Intent(Intent.ACTION_SEND);
                            shareIntent.setType("text/plain");
                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                            String shareMessage= "\nLet me recommend you this application\n\n";
                            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
                            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                            startActivity(Intent.createChooser(shareIntent, "choose one"));
                        } catch(Exception e) {
                            //e.toString();
                        }
                        break;
                }
                return true;
            }
        });



    }
    private void launchMarket() {
        Uri uri = Uri.parse("market://details?id=" + getPackageName());
        Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            startActivity(myAppLinkToMarket);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getApplicationContext(), " unable to find market app", Toast.LENGTH_LONG).show();
        }
    }
}