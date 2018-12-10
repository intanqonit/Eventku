package com.example.qonitpptb.eventku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PilihActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonFS;
    private Button buttonKM;
    private Button buttonP;
    private Button buttonTR;
    private Button buttonSM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih);

        buttonFS = (Button) findViewById(R.id.buttonFS);
        buttonKM = (Button) findViewById(R.id.buttonKM);
        buttonP = (Button) findViewById(R.id.buttonP);
        buttonTR = (Button) findViewById(R.id.buttonTR);
        buttonSM = (Button) findViewById(R.id.buttonSM);

        buttonFS.setOnClickListener(this);
        buttonKM.setOnClickListener(this);
        buttonP.setOnClickListener(this);
        buttonSM.setOnClickListener(this);
        buttonTR.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == buttonFS){
            finish();
            //starting login activity
            startActivity(new Intent(this, eventActivity.class));
        }
        else if(view == buttonKM){
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, event2Activity.class));
        }
        else if (view == buttonP){
            finish();
            //starting login activity
            startActivity(new Intent(this, event3Activity.class));
        }
        else if (view == buttonTR){
            finish();
            startActivity(new Intent(this, event4Activity.class));
        }

        else if (view== buttonSM){
            finish();
            startActivity(new Intent( this, event5Activity.class));
        }
    }


    @Override
    public void onBackPressed() {

        finish();
        startActivity(new Intent(this, Main1Activity.class));
    }
}