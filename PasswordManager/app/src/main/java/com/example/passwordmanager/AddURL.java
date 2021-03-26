package com.example.passwordmanager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddURL extends AppCompatActivity {

    public static final String WEBPAGE_ADDED = "com.example.passwordmanager.WEBPAGE_ADDED";
    public static final String USERNAME_ADDED = "com.example.passwordmanager.USERNAME_ADDED";
    public static final String PASSWORD_ADDED = "com.example.passwordmanager.PASSWORD_ADDED";
    public static final String PHONENUMBER_ADDED = "com.example.passwordmanager.PHONENUMBER_ADDED";
    public static final String QUESTION1_ADDED = "com.example.passwordmanager.QUESTION1_ADDED";
    public static final String ANSWER1_ADDED = "com.example.passwordmanager.ANSWER1_ADDED";
    public static final String QUESTION2_ADDED = "com.example.passwordmanager.QUESTION2_ADDED";
    public static final String ANSWER2_ADDED = "com.example.passwordmanager.ANSWER2_ADDED";
    public static final String QUESTION3_ADDED = "com.example.passwordmanager.QUESTION3_ADDED";
    public static final String ANSWER3_ADDED = "com.example.passwordmanager.ANSWER3_ADDED";

    EditText webpagePT;
    EditText usernamePT;
    EditText passwordPT;
    EditText phoneNumberPT;
    EditText question1PT;
    EditText answer1PT;
    EditText question2PT;
    EditText answer2PT;
    EditText question3PT;
    EditText answer3PT;

    private void saveUrl(){
        String webpage = webpagePT.getText().toString();
        String username = usernamePT.getText().toString();
        String password = passwordPT.getText().toString();
        String phoneNumber = phoneNumberPT.getText().toString();
        String question1 = question1PT.getText().toString();
        String answer1 = answer1PT.getText().toString();
        String question2 = question2PT.getText().toString();
        String answer2 = answer2PT.getText().toString();
        String question3 = question3PT.getText().toString();
        String answer3 = answer3PT.getText().toString();

        Log.d("New Webpage","WEg : " +webpage);
        Log.d("New Webpage","WEg : " +username);
        Log.d("New Webpage","WEg : " +password);
        Log.d("New Webpage","WEg : " +phoneNumber);
        Log.d("New Webpage","WEg : " +question1);
        Log.d("New Webpage","WEg : " +answer1);
        Log.d("New Webpage","WEg : " +question2);
        Log.d("New Webpage","WEg : " +answer2);
        Log.d("New Webpage","WEg : " +question3);
        Log.d("New Webpage","WEg : " +answer3);

        if(webpage.trim().isEmpty() && username.trim().isEmpty() && password.trim().isEmpty()){
            Toast.makeText(this,"Enter the webpage, Username and password",Toast.LENGTH_LONG).show();
            return;
        }
        Intent extras=new Intent();

        extras.putExtra("WEBPAGE_ADDED",webpage);
        extras.putExtra("USERNAME_ADDED",username);
        extras.putExtra("PASSWORD_ADDED",password);
        extras.putExtra("PHONENUMBER_ADDED",phoneNumber);
        extras.putExtra("QUESTION1_ADDED",question1);
        extras.putExtra("ANSWER1_ADDED",answer1);
        extras.putExtra("QUESTION2_ADDED",question2);
        extras.putExtra("ANSWER2_ADDED",answer2);
        extras.putExtra("QUESTION3_ADDED",question3);
        extras.putExtra("ANSWER3_ADDED",answer3);

        setResult(RESULT_OK,extras);
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_url);

        webpagePT = findViewById(R.id.webPagePT);
        usernamePT = findViewById(R.id.usernamePT);
        passwordPT = findViewById(R.id.passwordPT);
        phoneNumberPT = findViewById(R.id.phoneNumberPT);
        question1PT = findViewById(R.id.question1PT);
        answer1PT = findViewById(R.id.answer1PT);
        question2PT = findViewById(R.id.question2PT);
        answer2PT = findViewById(R.id.answer2PT);
        question3PT = findViewById(R.id.question3PT);
        answer3PT = findViewById(R.id.answer3PT);

//        final UrlRoomDatabase db= Room.databaseBuilder(getApplicationContext(),UrlRoomDatabase.class,"production")
//                .allowMainThreadQueries().build();

        final Button button = findViewById(R.id.submitBT);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

//                Intent replyIntent = new Intent();
//                Bundle extras=new Bundle();



                saveUrl();

//                    db.urlDao().insert(new URLs("3",webpage,username,password,phoneNumber,question1,answer1,question2,answer2,question3,answer3));
//                    startActivity(new Intent(AddURL.this,PasswordPage.class));
//                    extras.putString("Webpage",webpage);
//                    extras.putString("Username",username);
//                    extras.putString("Password",password);
//                    extras.putString("PhoneNumber",phoneNumber);
//                    extras.putString("Question1",question1);
//                    extras.putString("Answer1",answer1);
//                    extras.putString("Question2",question2);
//                    extras.putString("Answer2",answer2);
//                    extras.putString("Question3",question3);
//                    extras.putString("Answer3",answer3);

//                    replyIntent.putExtra(URL_ADDED,extras);
//                    setResult(RESULT_OK, replyIntent);


                finish();
            }
        });
    }
}
