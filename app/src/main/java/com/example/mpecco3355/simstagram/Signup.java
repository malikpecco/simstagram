package com.example.mpecco3355.simstagram;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.mpecco3355.simstagram.database.User;

public class Signup extends AppCompatActivity {




    private EditText ed_email,ed_password,ed_user;
    private  String  email, password,user;
    Button Createbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sginup);


        ed_email = (EditText) findViewById(R.id.EmailAdress);
        ed_user = (EditText) findViewById(R.id.UserName);
        ed_password = (EditText) findViewById(R.id.word);
        Createbtn = (Button) findViewById(R.id.Createbtn);
        Createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Reg();
            }

        });
    }
    public  void Reg(){
        intialise();
        if (!validate()){
            Toast.makeText(this, "Sign in Failed", Toast.LENGTH_SHORT).show();
        }
        else {
            try {
                User userAdd = new User(user,password,email);
                App.get().getDb().userDAO().addUser(userAdd);
            }
            catch (Exception e){
                Log.e("db" , e.getMessage());
                Toast.makeText(this, "registration", Toast.LENGTH_SHORT).show();

            }
            onSigninSuccess();
        }

    }
    public void onSigninSuccess(){
        Intent intent = new Intent(Signup.this ,MainActivity.class);
        startActivity(intent);
    }
    public boolean validate(){
        boolean valid = true;
        //TODO: make sure only one account per email

            if( email.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                ed_email.setError("Plese Enter a Vaild Email Address");
                valid = false;
            }
            if (password.isEmpty()|| password.equals(null)){
                ed_password.setError("Please enter in a password ");
                valid = false;
            }

            if (user.isEmpty() ||user.equals(null) ) {
                ed_user.setError("Please enter in a Username ");
                valid = false;
            }



        return valid;

    }
    public void intialise(){
        email = ed_email.getText().toString().trim();
        password = ed_password.getText().toString().trim();
        user = ed_user.getText().toString().trim();




    }
 /*
    protected class  signupTask extends AsyncTask<Void , Void , Boolean>{



        @Override
        protected Boolean doInBackground(Void... params) {
            User existing;
            try(
                  existing = App.db.userDAO().getUser(user);
                    if (existing != null){
                       return false;
                        }




            return true;
        }

 )*/



}
