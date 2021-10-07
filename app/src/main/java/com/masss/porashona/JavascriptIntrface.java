package com.masss.porashona;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JavascriptIntrface extends MyWebActivityForQuestionAnswer{
    public Context context;


    public JavascriptIntrface(Context context)
    {
        this.context=context;
    }

    @JavascriptInterface
    public void setScore(final String testid,final String name ,final String score,final String remtime,final String school)
    {

        //Toast.makeText(context,(new Integer(score)).toString(),Toast.LENGTH_LONG).show();
        final FirebaseFirestore db;
        db = FirebaseFirestore.getInstance();


        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();

        final String id=user.getUid();
        final String email=user.getEmail();
        db.collection(testid).document(id).get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if(task.isSuccessful())
                        {
                            DocumentSnapshot document = task.getResult();
                            if(document.exists())
                            {
                                Toast.makeText(context, "You have already given the test", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Map<String , String> data = new HashMap<>();

                                data.put("email",email);
                                data.put("score",score);
                                data.put("name",name);
                                data.put("remainingtime",remtime);
                                data.put("school",school);

                                db.collection(testid).document(id).set(data);
                            }
                        }
                        else
                        {
                            Toast.makeText(context,"Task Failed",Toast.LENGTH_LONG).show();
                        }
                    }

                });


    }

    @JavascriptInterface
    public void saveTestData(String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
        String string9 = new DbManager((Context) this.context).addRecord(string2, string3, Integer.parseInt((String)string4), Integer.parseInt((String)string5), Integer.parseInt((String)string6), Integer.parseInt((String)string7), Integer.parseInt((String)string8));
        Toast.makeText((Context)this.context, string9.toString(), Toast.LENGTH_LONG).show();
    }



//    @JavascriptInterface
//    public void save_certificate(String testid,String url)
//    {
//        String newurl = url.split(",")[1];
//        byte[] decodedString = Base64.decode(newurl,Base64.DEFAULT);
//        //Toast.makeText(context,url.toString(),Toast.LENGTH_LONG).show();
//
//        Bitmap img= BitmapFactory.decodeByteArray(decodedString,0,decodedString.length);
//        SaveImage(testid,img);
//
//    }
//    @JavascriptInterface
//    public void SaveImage(String testid, Bitmap finalBitmap) {
//
//        String root = Environment.getExternalStorageDirectory().getAbsolutePath();
//        File myDir = new File(root + "/Porar_Sathi/");
//
//        if(!myDir.exists())
//        {
//            myDir.mkdirs();
//        }
//
//
//        String fname = testid +".png";
//        File file = new File (myDir, fname);
//        if (file.exists())
//        {
//            file.delete();
//        }
//        try {
//            FileOutputStream out = new FileOutputStream(file);
//            //out.write(finalBitmap);
//            finalBitmap.compress(Bitmap.CompressFormat.PNG, 0, out);
//            out.flush();
//            out.close();
//            //MediaStore.Images.Media.insertImage(getContentResolver(),file.getAbsolutePath(),file.getName(),file.getName());
//            Toast.makeText(context,"certificate saved",Toast.LENGTH_LONG);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    @JavascriptInterface
//    public void takeScreenshot(String testid) {
//        Date now = new Date();
//        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);
//
//        try {
//            // image naming and path  to include sd card  appending name you choose for file
//            String mPath = Environment.getExternalStorageDirectory().toString() + "/" + now+ testid + ".jpg";
//
//            // create bitmap screen capture
//            View v1 = getWindow().getDecorView().getRootView();
//            v1.setDrawingCacheEnabled(true);
//            Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
//            v1.setDrawingCacheEnabled(false);
//
//            File imageFile = new File(mPath);
//
//            FileOutputStream outputStream = new FileOutputStream(imageFile);
//            int quality = 100;
//            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
//            outputStream.flush();
//            outputStream.close();
//
//        } catch (Throwable e) {
//            // Several error may come out with file handling or DOM
//            e.printStackTrace();
//        }
//    }

}

