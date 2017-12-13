package com.example.mpecco3355.simstagram;

import android.content.Context;
import android.content.Intent;
import android.graphics.Camera;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ImageButton;
/**
 * Created by malik on 2017-12-09.
 */

public class GallaryFragment extends AppCompatActivity {
    private static final int  CAMERA_REQUEST_CODE = 5;

    ImageButton camara;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_gallery);

        camara = (ImageButton) findViewById(R.id.Camra);



       camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE);

            }
    });
    }

  /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ( requestCode  == CAMRERA_REQUEST_CODE){

        }
    }*/
}
