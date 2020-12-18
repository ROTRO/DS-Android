package com.tp.basicproject;

import android.content.Intent;
import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Authentification extends AppCompatActivity {
    EditText username;
    EditText pass;
    TextView create;
    Button Blogin;


    private static final String url = "http://192.168.137.1:8080/requests/login.php";
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        Blogin = (Button) findViewById(R.id.button);
       // create = (TextView) findViewById((R.id.textView));
        /*create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //version 1 intent
                Intent intent = new Intent(MainActivity.this, Inscription.class);
                intent.putExtra("id","");
                startActivity(intent);
                //version 2
                startActivity(new Intent(getApplicationContext(), Inscription.class));

            }
        }); */
        Blogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String email = username.getText().toString().trim();
                String password= pass.getText().toString().trim();
                System.out.println(password);
                System.out.println(email);
                Intent intent=new Intent(getApplicationContext(),Dashboard.class);
                Bundle bundle=new Bundle();
                if (!email.isEmpty()|| !password.isEmpty()){
                  //  LoginFunction(email,password);
                    if(email.equals("bilel@gmail.com")&& password.equals("123456")){

                        bundle.putString("nom","bilel");
                        bundle.putString("prenom","hedhli");
                        bundle.putString("email","bilel@gmail.com");
                        intent.putExtra("user",bundle);
                        startActivity(intent);
                        Toast.makeText(Authentification.this, "Connecté avec succée", Toast.LENGTH_SHORT).show();

                    }
                 else if(email.equals("Ahmed@gmail.com")&& password.equals("Bilel1998")){
                        bundle.putString("nom","Ahmed");
                        bundle.putString("prenom","Benzarti");
                        bundle.putString("email","Ahmed@gmail.com");
                        intent.putExtra("user",bundle);
                        startActivity(intent);
                        Toast.makeText(Authentification.this, "Connecté avec succée", Toast.LENGTH_SHORT).show();
                    }
                    else if(email.equals("Omar@gmail.com")&& password.equals("123456")){
                        bundle.putString("nom","Omar");
                        bundle.putString("prenom","Agrebi");
                        bundle.putString("email","Omar@gmail.com");
                        intent.putExtra("user",bundle);
                        startActivity(intent);
                        Toast.makeText(Authentification.this, "Connecté avec succée", Toast.LENGTH_SHORT).show();
                    }
                    else if(email.equals("mohamed@gmail.com")&& password.equals("987654")){
                        bundle.putString("nom","mohamed");
                        bundle.putString("prenom","Kraiem");
                        bundle.putString("email","Mohamed@gmail.com");
                        intent.putExtra("user",bundle);
                        startActivity(intent);
                        Toast.makeText(Authentification.this, "Connecté avec succée", Toast.LENGTH_SHORT).show();
                    } else
                    {
                        Toast.makeText(Authentification.this, "Votre Email/Mdp est Erroné", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    username.setError("Inserez votre email");
                    pass.setError("Inserez votre mot de pass");
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


 /*   public void loginin() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Log.e("error","here onresponse");

                        try {
                            Log.e("error","here try");
                            //converting response to json object
                            JSONObject obj = new JSONObject(response);
                            Log.e("",""+response);
                            Log.e("",""+obj);
                            //if no error in response
                            if (!obj.getBoolean("error")) {
                                Log.e("error","here if");
                                Toast.makeText(getApplicationContext(), "error", 100).show();

                                //getting the user from the response
                                JSONObject userJson = obj.getJSONObject("user");
                                 Log.e("testing"," "+userJson);
                                //creating a new user object
                                User user = new User(

                                        userJson.getString("username"),
                                        userJson.getString("firstname"),
                                        userJson.getString("lastname"),
                                        userJson.getString("email")

                                );

                                //storing the user in shared preferences

                                //starting the profile activity
                                finish();
                                startActivity(new Intent(getApplicationContext(), Dashboard.class));
                            } else {
                               if (obj.getInt("errcode")==1)
                               {username.setError("Invalid Username or Password");}
                               else if (obj.getInt("errcode")==2)
                                {username.setError(obj.getString("message"));}

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("error","here catch");
                            Log.e("",""+e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {



                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", username.getText().toString().trim());
                params.put("password", password.getText().toString().trim());

            return params;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        queue.add(stringRequest);

    }*/

}
