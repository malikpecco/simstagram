package com.example.mpecco3355.simstagram;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ImageButton;

public class homepage extends AppCompatActivity {

    private TextView ed_name ;
    ImageButton addpic;
    Button addbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        addbtn = (Button) findViewById(R.id.addbtn);
        ed_name = (TextView) findViewById(R.id.Uname);
        addpic = (ImageButton) findViewById(R.id.addpic);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homepage.this ,Profile.class );
                startActivity(intent);
            }
        });


        addpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(homepage.this ,GallaryFragment.class );
                startActivity(intent);
            }
        });


    }
}
