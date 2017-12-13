package com.example.mpecco3355.simstagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mpecco3355.simstagram.database.User;

public class MainActivity extends AppCompatActivity {

    private EditText ed_user,ed_password;
    private  String  user, password;
    Button Sgininbtn;
    Button Sginupbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_user = (EditText) findViewById(R.id.userN);
        ed_password = (EditText) findViewById(R.id.Password);
        Sgininbtn = (Button) findViewById(R.id.Sgininbtn);
        Sginupbtn = (Button) findViewById(R.id.Sginupbtn);
        Sgininbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Reg();
            }
        });
        Sginupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this ,Signup.class);
                startActivity(intent);
            }
        });
    }
    public  void Reg(){
        if (!validate()){
            Toast.makeText(this, "Sign in Failed", Toast.LENGTH_SHORT).show();
        }
        else {
            onSigninSuccess();
        }

    }
    public void onSigninSuccess(){
        Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this ,homepage.class);
        startActivity(intent);

    }
    public boolean validate(){
        user = ed_user.getText().toString().trim();
        password = ed_password.getText().toString().trim();


        boolean valid = true;
        User loggingInUser = null;
        try {
            loggingInUser = App.get().getDb().userDAO().getUser(user);

            if(!password.equals(loggingInUser.password)){
                ed_password.setError("your acount dose not exits  ");
                valid = true;
                App.loginUser = loggingInUser.id;
            }
            else {
                valid = false;
            }
            return valid;
        }catch (Exception e){
            Log.e("my tage",e.getMessage());
            return false;
        }

       /*
       *  boolean valid = true;

        if( user.isEmpty()){
            ed_user.setError("Plese Enter a Vaild userame");
            valid = false;
        }
        User loginUser = App.db.userDAO().getUser(user);

        if(password.equals(loginUser.password)) {
            ed_password.setError("your acount dose not exits");
            valid = true;

        }
        else {
            valid = false;
        }
       * */


    }
    


}
