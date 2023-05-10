package com.FIT5046.assignment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.FIT5046.assignment.databinding.ActivityMainBinding;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

import org.jetbrains.annotations.NotNull;

public class submitPhotoScreen extends AppCompatActivity {



    private static final int permisionReq = 0;
    private static final int resultForImage = 0;
    Button uploadButton,backtoprofile;
    ImageView upLoadTheImage;

    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.submit_photo);

        uploadButton = findViewById(R.id.uploadButton);

        upLoadTheImage = findViewById(R.id.upLoadTheImage);

        backtoprofile = findViewById(R.id.backtoprofile);


        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectTheImage();

            }
        });
        backtoprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBackToProfile = new Intent(submitPhotoScreen.this,accountscreen.class);
                startActivity(intentBackToProfile);
            }
        });
    }

    private void selectTheImage(){
        Intent selectImageIntent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        selectImageIntent.addCategory(Intent.CATEGORY_OPENABLE);
        selectImageIntent.setType("image/");
        selectImageIntent.setAction(selectImageIntent.ACTION_GET_CONTENT);
        startActivityForResult(selectImageIntent,100);
    }



}
