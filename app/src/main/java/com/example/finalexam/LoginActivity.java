package com.example.finalexam;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editPass = (EditText) findViewById(R.id.editText2);
        Button button = (Button) findViewById(R.id.button);
        Button buttonRegis = (Button) findViewById(R.id.button2);


        String strUser = editText.getText().toString();
        String strPass = editPass.getText().toString();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this);
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.activity_main, null);
                dialog.setView(layout);
                dialog.show();
            }

        });

            Intent intent = new Intent();
            intent.putExtra("User",strUser);


        }
    }
