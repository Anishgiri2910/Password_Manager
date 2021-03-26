package com.example.passwordmanager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewUrlPage extends AppCompatActivity {

    public static final String EXTRA_WEBPAGE = "com.example.passwordmanager.EXTRA_WEBPAGE";
    public static final String EXTRA_USERNAME = "com.example.passwordmanager.EXTRA_USERNAME";
    public static final String EXTRA_PASSWORD = "com.example.passwordmanager.EXTRA_PASSWORD";
    public static final String EXTRA_PHONENUMBER = "com.example.passwordmanager.EXTRA_PHONENUMBER";
    public static final String EXTRA_QUESTION1 = "com.example.passwordmanager.EXTRA_QUESTION1";
    public static final String EXTRA_ANSWER1 = "com.example.passwordmanager.EXTRA_ANSWER1";
    public static final String EXTRA_QUESTION2 = "com.example.passwordmanager.EXTRA_QUESTION2";
    public static final String EXTRA_ANSWER2 = "com.example.passwordmanager.EXTRA_ANSWER2";
    public static final String EXTRA_QUESTION3 = "com.example.passwordmanager.EXTRA_QUESTION3";
    public static final String EXTRA_ANSWER3 = "com.example.passwordmanager.EXTRA_ANSWER3";


    TextView webpageT;
    TextView usernameT;
    TextView passwordT;
    TextView phoneNumberT;
    TextView question1T;
    TextView answer1T;
    TextView question2T;
    TextView answer2T;
    TextView question3T;
    TextView answer3T;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_url_page);

        webpageT=(TextView) findViewById(R.id.webpageTV);
        usernameT=(TextView) findViewById(R.id.usernameTV);
        passwordT=(TextView) findViewById(R.id.passwordTV);
        phoneNumberT=(TextView) findViewById(R.id.phoneNumberTV);
        question1T=(TextView) findViewById(R.id.question1TV);
        answer1T=(TextView) findViewById(R.id.answer1TV);
        question2T=(TextView) findViewById(R.id.question2TV);
        answer2T=(TextView) findViewById(R.id.answer2TV);
        question3T=(TextView) findViewById(R.id.question3TV);
        answer3T=(TextView) findViewById(R.id.answer3TV);

        Intent intent=getIntent();

        webpageT.setText(intent.getStringExtra(EXTRA_WEBPAGE));
        usernameT.setText(intent.getStringExtra(EXTRA_USERNAME));
        passwordT.setText(intent.getStringExtra(EXTRA_PASSWORD));
        phoneNumberT.setText(intent.getStringExtra(EXTRA_PHONENUMBER));
        question1T.setText(intent.getStringExtra(EXTRA_QUESTION1));
        answer1T.setText(intent.getStringExtra(EXTRA_ANSWER1));
        question2T.setText(intent.getStringExtra(EXTRA_QUESTION2));
        answer2T.setText(intent.getStringExtra(EXTRA_ANSWER2));
        question3T.setText(intent.getStringExtra(EXTRA_QUESTION3));
        answer3T.setText(intent.getStringExtra(EXTRA_ANSWER3));

    }

}
