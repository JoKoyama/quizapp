package com.example.intentlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public EditText editTextUsername;
    public EditText editTextPassword;
    public Button buttonNext;

    //key values for the data that you put in the Intent
    //they all start with EXTRA_ and contain the key
    public static final String EXTRA_USERNAME = "username";
    public static final String EXTRA_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // gather the user input from the editText
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                // create an intent and put the extras
                //think of an intent
                Intent targetIntent = new Intent(MainActivity.this,TargetActivity.class);
                targetIntent.putExtra(EXTRA_USERNAME,username);
                targetIntent.putExtra(EXTRA_PASSWORD,password);
                //launch the new activity
                startActivity(targetIntent);
                fileList();
            }
        });
    }

    private void wireWidgets() {
        editTextUsername = findViewById(R.id.edittext_main_login);
        editTextPassword = findViewById(R.id.edittext_main_password);
        buttonNext = findViewById(R.id.button_main_continue);

    }
}
