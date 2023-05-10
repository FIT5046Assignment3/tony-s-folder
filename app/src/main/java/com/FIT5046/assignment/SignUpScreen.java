package com.FIT5046.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignUpScreen extends AppCompatActivity {




    private EditText emailinput,passwordinput,confrimpasswordinput;

    private static String getEmail;

    private TextView gotologin;

    private Button continueButton;

    public String getemail;

    public String getPassword;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);



        emailinput = findViewById(R.id.emailinput);
        passwordinput = findViewById(R.id.passwordinput);
        confrimpasswordinput = findViewById(R.id.conirmpasswordinput);
        gotologin = findViewById(R.id.gotologin);
        continueButton = findViewById(R.id.continueButton);




        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentforLoginScreen = new Intent(SignUpScreen.this,loginScreen.class);
                startActivity(intentforLoginScreen);
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email_input =emailinput.getText().toString();
                String password_input = passwordinput.getText().toString();
                String confrim_password_input =  confrimpasswordinput.getText().toString();



                if(email_input.isEmpty())
                {
                    emailinput.setError("email is required");

                }
                else if(password_input.isEmpty())
                {
                    passwordinput.setError("password is required");
                }
                else if(!password_input.equals(confrim_password_input))
                {
                    Toast.makeText(SignUpScreen.this, "password and confirm password should be the same", Toast.LENGTH_SHORT).show();
                }
                else
                {


                    //store email and password into authentication

                                Intent intentforcontinueScreen = new Intent(SignUpScreen.this,MainActivity.class);
                                intentforcontinueScreen.putExtra("Email",email_input);
                                intentforcontinueScreen.putExtra("password",password_input);
                                startActivity(intentforcontinueScreen);
                            }


                        }
                    });


                }
            }


















