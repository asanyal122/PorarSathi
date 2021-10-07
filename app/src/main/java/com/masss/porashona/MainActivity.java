/*
 * Decompiled with CFR 0.0.
 *
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.Editable
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.Spinner
 *  android.widget.TextView
 *  android.widget.Toast
 *  androidx.appcompat.app.AppCompatActivity
 *  androidx.core.app.ActivityCompat
 *  androidx.core.content.ContextCompat
 *  com.google.android.gms.auth.api.signin.GoogleSignIn
 *  com.google.android.gms.auth.api.signin.GoogleSignInAccount
 *  com.google.android.gms.auth.api.signin.GoogleSignInClient
 *  com.google.android.gms.auth.api.signin.GoogleSignInOptions
 *  com.google.android.gms.auth.api.signin.GoogleSignInOptions$Builder
 *  com.google.android.gms.common.SignInButton
 *  com.google.android.gms.common.api.ApiException
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 *  com.google.firebase.auth.AuthCredential
 *  com.google.firebase.auth.AuthResult
 *  com.google.firebase.auth.FirebaseAuth
 *  com.google.firebase.auth.FirebaseUser
 *  com.google.firebase.auth.GoogleAuthProvider
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.masss.porashona;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.masss.porashona.HomeActivity;

public class MainActivity
        extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {
    private static final int PERMISSION_REQUEST_CODE = 1;
    private static final int RC = 10;
    private boolean check;
    private Spinner classspinner;
    private String classval;
    FirebaseUser currentUser;
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
    private TextView maintext;
    private Button menuButton;
    private String name;
    private EditText nameedittext;
    private String school;
    private EditText schooledittext;
    private String selectedclass;
    private SignInButton signInButton;
    private Button signOutButton;
    SharedPreferences sp;

    private boolean checkPermission() {
        return ContextCompat.checkSelfPermission(this, (String)"android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    private void createRequest() {
        mGoogleSignInClient = GoogleSignIn.getClient((Activity)this, (GoogleSignInOptions)new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail().build());
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount googleSignInAccount) {
        AuthCredential authCredential = GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(), null);
        mAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){

            public void onComplete(Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    currentUser = FirebaseAuth.getInstance().getCurrentUser();
                    maintext.setText(("Welcome " + currentUser.getEmail()));
                    signOutButton.setVisibility(View.VISIBLE);
                    signInButton.setVisibility(View.INVISIBLE);
                    menuButton.setVisibility(View.VISIBLE);
                    findViewById(R.id.nameedittext).setVisibility(View.INVISIBLE);
                    findViewById(R.id.schooledittext).setVisibility(View.INVISIBLE);
                    findViewById(R.id.classspinner).setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "Sign In Successful", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(getApplicationContext(), "Sign In Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void requestPermission() {
//        if (ActivityCompat.shouldShowRequestPermissionRationale(this,"android.permission.WRITE_EXTERNAL_STORAGE")) {
//            Toast.makeText(this, "Write External Storage permission allows us to do store images. Please allow this permission in App Settings.", Toast.LENGTH_SHORT).show();
//            return;
//        }
        ActivityCompat.requestPermissions(this,new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
    }




    private void closeNow() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            finishAffinity();
        } else {
            finish();
        }
    }

    private void signIn() {
        startActivityForResult(mGoogleSignInClient.getSignInIntent(), 10);
    }

    private void signOut() {
        FirebaseAuth.getInstance().signOut();
        signOutButton.setVisibility(View.INVISIBLE);
        menuButton.setVisibility(View.INVISIBLE);
        signInButton.setVisibility(View.VISIBLE);
        maintext.setText("Sign in with Google");
    }

//    public void onActivityResult(int n, int n2, Intent intent) {
//        super.onActivityResult(n, n2, intent);
//        if (n == 10) {
//            Task task = GoogleSignIn.getSignedInAccountFromIntent((Intent)intent);
//            firebaseAuthWithGoogle((GoogleSignInAccount) task.getResult());
//            return;
//        }
//    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == 10) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                //Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                //Log.w(TAG, "Google sign in failed", e);
                // ...
            }
        }
    }

    protected void onCreate(Bundle bundle) {

        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        Spinner spinner;
        sp =getApplicationContext().getSharedPreferences("userdata", 0);
        name = sp.getString("studentname", "");
        school = sp.getString("school", "");
        classval = sp.getString("class", "");
        check = true;
        nameedittext = (EditText)findViewById(R.id.nameedittext);
        schooledittext = (EditText)findViewById(R.id.schooledittext);
         spinner = findViewById(R.id.classspinner);
        spinner.setOnItemSelectedListener(this);
        if (name.equals("") || school.equals("") || classval.equals("")) {
            check = false;
        }
        if (Build.VERSION.SDK_INT >= 23 && !checkPermission()) {
            requestPermission();
        }
        mAuth = FirebaseAuth.getInstance();
        createRequest();
        signInButton = (SignInButton)findViewById(R.id.sign_in_button);
        signOutButton = (Button)findViewById(R.id.sign_out_button);
        menuButton = (Button)findViewById(R.id.menu_button);
        signInButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {

                check=true;
                name = sp.getString("studentname", "");
                school = sp.getString("school", "");
                String string2 = sp.getString("class", "");
                if (!(name.equals("") || school.equals("") || string2.equals("")))
                {
                    signIn();
                }
                else
                {

                    name = nameedittext.getText().toString();
                    school = schooledittext.getText().toString();

                    if (name.equals("") || name.length() < 3) {
                        check=false;
                        Toast.makeText(getApplicationContext(), "Enter Valid Name", Toast.LENGTH_SHORT).show();
                    }
                    else if (school.equals("") || school.length()<2) {
                        check = false;
                        Toast.makeText(getApplicationContext(), "Enter Valid School", Toast.LENGTH_SHORT).show();

                    }
                    else if (classval.equals("")) {
                        check = false;
                        Toast.makeText(getApplicationContext(),"Select Class", Toast.LENGTH_SHORT).show();
                    }

                    if(check==true)
                    {
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("studentname", name);
                        editor.putString("school", school);
                        editor.putString("class", classval);
                        editor.apply();
                        //Toast.makeText(getApplicationContext(), "Before Signin", Toast.LENGTH_SHORT).show();
                        signIn();
                    }
                }




            }
        });
        signOutButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                signOut();
            }
        });
        menuButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int n, long l) {
        classval = adapterView.getSelectedItem().toString();
        //Toast.makeText(getApplicationContext(), classval,Toast.LENGTH_SHORT).show();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void onRequestPermissionsResult(int n, String[] arrstring, int[] arrn) {
        if (n != 1) {
            return;
        }
        if (arrn.length > 0 && arrn[0] == 0) {
            //Log.e((String)"value", (String)"Permission Granted, Now you can use local drive .");
            return;
        }

        //Log.e((String)"value", (String)"Permission Denied, You cannot use local drive .");
    }

    protected void onStart() {
        //Toast.makeText(this,getString(R.string.default_web_client_id).toString(),Toast.LENGTH_LONG).show();
        super.onStart();
        maintext = findViewById(R.id.mainwelcome);
        currentUser = mAuth.getCurrentUser();

        //Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        if (currentUser != null) {
            maintext.setText("Welcome " + currentUser.getEmail());
            findViewById(R.id.sign_in_button).setVisibility(View.INVISIBLE);
            findViewById(R.id.sign_out_button).setVisibility(View.VISIBLE);
            findViewById(R.id.menu_button).setVisibility(View.VISIBLE);
            findViewById(R.id.nameedittext).setVisibility(View.INVISIBLE);
            findViewById(R.id.classspinner).setVisibility(View.INVISIBLE);
            findViewById(R.id.schooledittext).setVisibility(View.INVISIBLE);
            findViewById(R.id.classspinner).setVisibility(View.INVISIBLE);
        }
        else
        {
            name = sp.getString("studentname", "");
            school = sp.getString("school", "");
            classval = sp.getString("class", "");
            //Toast.makeText(this, school.toString(), Toast.LENGTH_SHORT).show();
            check = true;
            if (name.equals("") || school.equals("") || classval.equals("")) {
                check = false;
            }

            if (!check) {
                findViewById(R.id.nameedittext).setVisibility(View.VISIBLE);
                findViewById(R.id.schooledittext).setVisibility(View.VISIBLE);
                findViewById(R.id.classspinner).setVisibility(View.VISIBLE);
                findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);
                maintext.setText("Sign in with Google");
                findViewById(R.id.sign_out_button).setVisibility(View.INVISIBLE);
                findViewById(R.id.menu_button).setVisibility(View.INVISIBLE);
            }
            else
            {
                findViewById(R.id.nameedittext).setVisibility(View.INVISIBLE);
                findViewById(R.id.schooledittext).setVisibility(View.INVISIBLE);
                findViewById(R.id.classspinner).setVisibility(View.INVISIBLE);
                findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);
                maintext.setText("Sign in with Google");
                findViewById(R.id.sign_out_button).setVisibility(View.INVISIBLE);
                findViewById(R.id.menu_button).setVisibility(View.INVISIBLE);
            }

        }



    }

}

