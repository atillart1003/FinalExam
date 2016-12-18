package com.example.finalexam;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.finalexam.adapter.contactListAdapter;
import com.example.finalexam.db.DatabaseHelper;
import com.example.finalexam.model.Contact;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity{
    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;

    private ArrayList<Contact> mContactList = new ArrayList<Contact>();

    private ListView mContactListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        mHelper = new DatabaseHelper(this);
        mDb = mHelper.getWritableDatabase();
        mContactListView = (ListView) findViewById(R.id.contact_list_view);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Cursor cursor = mDb.query(DatabaseHelper.TABLE_NAME, null, null, null, null, null, null);   //null  ==> new String[] {DatabaseHelper.colName} (เรียกทั้งหมดใช้ null ถ้าเรียกเฉพาะ col ให้ใช้ new Str...)

        mContactList.clear();
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME));
            String phone = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_USER));
            String image = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PASSWORD));

            Contact contact = new Contact(name, phone, image);
            mContactList.add(contact);
        }

        contactListAdapter adapter = new contactListAdapter(
                this,
                R.layout.listview_item,
                mContactList
        );

        mContactListView.setAdapter(adapter);
    }

}
