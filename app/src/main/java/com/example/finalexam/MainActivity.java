package com.example.finalexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private  UserListActivity mUserList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String typeUser = intent.getStringExtra("ResultName");

        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(typeUser);
    }
}
