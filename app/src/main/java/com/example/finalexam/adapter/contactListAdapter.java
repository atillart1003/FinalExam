package com.example.finalexam.adapter;


import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalexam.R;
import com.example.finalexam.model.Contact;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class contactListAdapter extends ArrayAdapter{
    private Context mContact;
    private int mLayoutResId;
    private ArrayList<Contact> mContactList;

    public contactListAdapter(Context context, int resource, ArrayList<Contact> contactList) {
        super(context, resource, contactList);

        this.mContact = context;
        this.mLayoutResId = resource;
        this.mContactList = contactList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemLayout = convertView;

        if (itemLayout == null) {
            itemLayout = View.inflate(mContact, mLayoutResId, null);
        }

        ImageView imageView = (ImageView) itemLayout.findViewById(R.id.image_view);
        TextView nameTextView = (TextView) itemLayout.findViewById(R.id.name_text_view);

        Contact contact = mContactList.get(position);       //เข้าถึง Object หนึ่งๆ ใน mContactList

        String contactName = contact.getName();
        nameTextView.setText(contact.getName());

        return itemLayout;
    }

}
