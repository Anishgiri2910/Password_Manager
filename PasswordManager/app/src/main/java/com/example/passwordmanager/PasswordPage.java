package com.example.passwordmanager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class  PasswordPage extends AppCompatActivity {

    public static final int ADD_URL_REQUEST = 1;
    private static final int EDIT_URL_REQUEST =2 ;


    private UrlViewModel mUrlViewModel;
    private UrlListAdapter mUrlList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Add New Intent
                Intent intent = new Intent(PasswordPage.this, AddURL.class);
                startActivityForResult(intent, ADD_URL_REQUEST);
            }
        });



        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final UrlListAdapter adapter = new UrlListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mUrlViewModel = ViewModelProviders.of(this).get(UrlViewModel.class);
        mUrlViewModel.getAllUrl().observe(this, new Observer<List<URLs>>() {

            @Override
            public void onChanged(@Nullable final List<URLs> urls) {
                // Update the cached copy of the words in the adapter.
                adapter.setUrl(urls);
            }
        });

        ItemTouchHelper helper = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(0,
                        ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView,
                                          RecyclerView.ViewHolder viewHolder,
                                          RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder,
                                         int direction) {
                        int position = viewHolder.getAdapterPosition();
                        URLs myUrl = adapter.getUrlAtPosition(position);
                        Toast.makeText(PasswordPage.this, "Deleting " +
                                myUrl.getId(), Toast.LENGTH_LONG).show();

                        // Delete the word
                        mUrlViewModel.deleteUrl(myUrl);
                    }
                });
        helper.attachToRecyclerView(recyclerView);

        adapter.setOnItemClickListner(new UrlListAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(URLs url) {
                Intent intent=new Intent(PasswordPage.this,ViewUrlPage.class);
                intent.putExtra(ViewUrlPage.EXTRA_WEBPAGE,url.getWebpage());
                intent.putExtra(ViewUrlPage.EXTRA_USERNAME,url.getUsername());
                intent.putExtra(ViewUrlPage.EXTRA_PASSWORD,url.getPassword());
                intent.putExtra(ViewUrlPage.EXTRA_PHONENUMBER,url.getPhoneNumber());
                intent.putExtra(ViewUrlPage.EXTRA_QUESTION1,url.getQuestion1());
                intent.putExtra(ViewUrlPage.EXTRA_ANSWER1,url.getAnswer1());
                intent.putExtra(ViewUrlPage.EXTRA_QUESTION2,url.getQuestion2());
                intent.putExtra(ViewUrlPage.EXTRA_ANSWER2,url.getAnswer2());
                intent.putExtra(ViewUrlPage.EXTRA_QUESTION3,url.getQuestion3());
                intent.putExtra(ViewUrlPage.EXTRA_ANSWER3,url.getAnswer3());

                startActivityForResult(intent,EDIT_URL_REQUEST);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_URL_REQUEST && resultCode == RESULT_OK) {

//            String id=Integer.toString(mUrlList.getItemCount()+1);
            String webpage = data.getStringExtra("WEBPAGE_ADDED");
            String username = data.getStringExtra("USERNAME_ADDED");
            String password = data.getStringExtra("PASSWORD_ADDED");
            String phoneNumber = data.getStringExtra("PHONENUMBER_ADDED");
            String question1 = data.getStringExtra("QUESTION1_ADDED");
            String answer1 = data.getStringExtra("ANSWER1_ADDED");
            String question2 = data.getStringExtra("QUESTION2_ADDED");
            String answer2 = data.getStringExtra("ANSWER2_ADDED");
            String question3 = data.getStringExtra("QUESTION3_ADDED");
            String answer3 = data.getStringExtra("ANSWER3_ADDED");

            Log.d("Check"," : "+webpage);
            Log.d("Check"," : "+username);
            Log.d("Check"," : "+password);
            Log.d("Check"," : "+phoneNumber);
            Log.d("Check"," : "+question1);
            Log.d("Check"," : "+answer1);

            URLs url = new URLs(webpage, username, password, phoneNumber, question1, answer1, question2, answer2, question3, answer3);
            mUrlViewModel.insert(url);

        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.about_settings) {
            Intent intent = new Intent(PasswordPage.this, AboutUser.class);
            startActivityForResult(intent, 1);
        }

        return super.onOptionsItemSelected(item);
    }
}