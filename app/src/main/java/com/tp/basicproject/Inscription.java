package com.tp.basicproject;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Inscription extends AppCompatActivity {
EditText username,password,email,name,lastname,confirmpass;
public String ch;
Button button;
public String getch()
{return this.ch; }
private static final String url="http://192.168.137.1:8080/requests/add.php";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incription);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
            button = (Button) findViewById(R.id.button);
            username=(EditText)findViewById(R.id.user);
            password=(EditText)findViewById(R.id.pass);
            email=(EditText)findViewById(R.id.emailfield);
            name=(EditText)findViewById(R.id.namefield);
            lastname=(EditText)findViewById(R.id.lastnamefield);
            confirmpass=(EditText)findViewById(R.id.passconfirm);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("result "," "+ValidatePassword(password.getText().toString()));
                if( username.getText().toString().length() == 0 )
                { username.setError( "Username is required!" );}
                else if(name.getText().toString().length() == 0){
                    name.setError( "First name is required!" );
                }
                else if(lastname.getText().toString().length() == 0){
                    lastname.setError( "Last name is required!" );
                }
                else if(email.getText().toString().length() == 0){
                    email.setError( "Email is required!" );
                }
                else if(email.getText().toString().trim().matches(emailPattern)!=true){
                    email.setError( "Please Enter a valid email" );
                }
                else if(password.getText().toString().length() == 0){
                    password.setError( "Password is required!" );
                }
                else if(password.getText().toString().length() < 8 || ValidatePassword(password.getText().toString())){
                    password.setError( "Password Must be at least 8 characters long" );
                }
                else if(confirmpass.getText().toString().length() == 0){
                    confirmpass.setError( "Confirm your Password!" );
                }
                else if(confirmpass.getText().toString().compareTo(password.getText().toString())!=0){
                    confirmpass.setError( "Passwords dont match!" );
                }
                else
                {insertdata();
                }

            }
        });


    }
    private void insertdata()
    {

        final String strusername= username.getText().toString().trim();

        final String strpass=password.getText().toString().trim();

        final String stremail=email.getText().toString().trim();

        final String strname = name.getText().toString().trim();

        final String strlastname = lastname.getText().toString().trim();



        StringRequest request = new StringRequest(Request.Method.POST,url,new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
             username.setText("");
             password.setText("");
             email.setText("");
             name.setText("");
             lastname.setText("");
             confirmpass.setText("");
            // Intent intent=new Intent();
                startActivity(new Intent(getApplicationContext(), Authentification.class));
            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("errort",error.toString());
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG);
            }
        }){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> param = new HashMap<String,String>();
                param.put("user",strusername);
                param.put("name",strname);
                param.put("lastname",strlastname);
                param.put("password",strpass);
                param.put("email",stremail);
                return param;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);

    }
    public static boolean ValidatePassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }
}