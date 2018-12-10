package com.example.qonitpptb.eventku;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {


    private static final String SHARED_PREF_NAME = "mysharedpref";
    private static final String KEY_NAME = "keyname";

    EditText editTextNP;
    TextView textViewKosong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        editTextNP = findViewById(R.id.editTextNP);
        textViewKosong = findViewById(R.id.textViewKosong);

        findViewById(R.id.buttonSavepro).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveName();
                displayName();
            }
        });
    }

    private void saveName() {
        String name = editTextNP.getText().toString();

        if (name.isEmpty()) {
            editTextNP.setError("Name required");
            editTextNP.requestFocus();
            return;
        }

        SharedPreferences sp = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString(KEY_NAME, name);

        editor.apply();

        editTextNP.setText("");
    }

    private void displayName() {
        SharedPreferences sp = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String name = sp.getString(KEY_NAME, null);

        if (name != null) {
            textViewKosong.setText("Welcome " + name);
        }
    }

    @Override
    public void onBackPressed() {

        finish();
        startActivity(new Intent(this, Main1Activity.class));

    }

}