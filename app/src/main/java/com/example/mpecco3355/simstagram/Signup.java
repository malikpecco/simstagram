package com.example.mpecco3355.simstagram;

import android.content.Context;
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

    Context context;

    private EditText ed_email,ed_password,ed_user;
    private  String  email, password, username;
    Button Createbtn;
    User userExisting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sginup);

        context = this;
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
        else{

            new signupTask().execute();

        }

    }
    public void onSigninSuccess(){
        Toast.makeText(this, "Account made!", Toast.LENGTH_SHORT).show();
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

            if (username.isEmpty() || username.equals(null) ) {
                ed_user.setError("Please enter in a Username ");
                valid = false;
            }



        return valid;

    }
    public void intialise(){
        email = ed_email.getText().toString().trim();
        password = ed_password.getText().toString().trim();
        username = ed_user.getText().toString().trim();




    }

    protected class  signupTask extends AsyncTask<Void , Void , Boolean>{



        @Override
        protected Boolean doInBackground(Void... params) {

            try {
                userExisting = App.db.userDAO().getUser(username);
                if (userExisting != null) {
                    return false;
                }

                User user = new User(username,password,email);
                App.db.userDAO().addUser(user);

                return true;
            }
            catch (Exception e){

                Log.e("DBSignup", e.getMessage());
                return false;
            }
        }

        @Override
        protected void onPostExecute(final Boolean success){
            if(success){

                onSigninSuccess();
            }
            else{

                Toast.makeText(context, "Registration Failed", Toast.LENGTH_SHORT).show();

            }
        }



    }

}
