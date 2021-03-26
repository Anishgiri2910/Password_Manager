package com.example.passwordmanager;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutUser extends AppCompatActivity {
    TextView langs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_user);

        langs=findViewById(R.id.languagesTV);
        langs.setMovementMethod(new ScrollingMovementMethod());
    }

}