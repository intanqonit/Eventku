package com.example.qonitpptb.eventku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main1Activity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;

    //view objects
    private TextView textViewUserEmail;
    private Button buttonLogout, buttonEvent;
    private ImageView profileImageView;
    private Button button_info;
    private Button button_profile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }

        profileImageView = (ImageView) findViewById(R.id.profileImageView);

        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //getting current user
        FirebaseUser user = firebaseAuth.getCurrentUser();

        //initializing views
        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        buttonEvent = (Button) findViewById(R.id.buttonEvent);
        button_info = (Button) findViewById(R.id.button_Info);
        button_profile = (Button) findViewById(R.id.button_Profile);

        //displaying logged in user name
        textViewUserEmail.setText("Welcome to The Event "+user.getEmail());

        //adding listener to button
        buttonLogout.setOnClickListener(this);
        buttonEvent.setOnClickListener(this);
        button_info.setOnClickListener(this);
        button_profile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == buttonLogout){
            //logging out the user
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }
        else if(view == buttonEvent){
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, UploadActivity.class));
        }
        else if (view == button_info){
            finish();
            //starting login activity
            startActivity(new Intent(this, PilihActivity.class));
        }
        else if (view == button_profile){
            finish();
            startActivity(new Intent(this, ProfileActivity.class));
        }
    }

    @Override
    public void onBackPressed() {

        finish();
        startActivity(new Intent(this, Main1Activity.class));

    }

}


