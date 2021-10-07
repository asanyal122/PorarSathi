package com.masss.porashona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.view.View;
import android.view.WindowManager;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageException;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyWebActivityForQuestionAnswer extends AppCompatActivity {

    WebView wv;
    private StorageReference StorageRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_web_for_question_answer);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);



        SharedPreferences sp =getApplicationContext().getSharedPreferences("userdata", 0);
        final String name = sp.getString("studentname", "");
        final String school = sp.getString("school", "");

        wv=findViewById(R.id.wbvqa);
        WebSettings web_settings=wv.getSettings();
        web_settings.setJavaScriptEnabled(true);
        web_settings.setBuiltInZoomControls(true);
        web_settings.setDisplayZoomControls(false);
        web_settings.setJavaScriptCanOpenWindowsAutomatically(true);
        web_settings.setSupportMultipleWindows(true);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.addJavascriptInterface(new JavascriptIntrface(getApplicationContext()),"Android");

        wv.setWebChromeClient(new WebChromeClient() {

            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                AlertDialog dialog = new AlertDialog.Builder(view.getContext()).
                        setTitle("").
                        setMessage(message).
                        setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //do nothing
                            }
                        }).create();
                dialog.show();
                result.confirm();
                return true;
            } });

        wv.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                wv.loadData("<html><body><h1>CONNECTION PROBLEM...<h1></body></html>","text/html","UTF-8");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                    wv.evaluateJavascript("javascript: " + "getName(\"" + name + "\")", null);
                    wv.evaluateJavascript("javascript: " + "getSchool(\"" + school + "\")", null);
                } else {
                    wv.loadUrl("javascript:getName('"+name+"')");
                    wv.loadUrl("javascript:getSchool('"+school+"')");
                }

            }
        }
        );

        wv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
        wv.setLongClickable(false);

        wv.loadUrl(getIntent().getStringExtra("fileurl"));
    }


}
