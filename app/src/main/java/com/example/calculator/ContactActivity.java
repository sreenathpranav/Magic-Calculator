package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {

    private static final int RESULT_PICK_CONTACT = 1;
    private TextView txt_phone;
    private Button btn_contact;
    private Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        txt_phone = findViewById(R.id.txt_phone);
        btn_contact = findViewById(R.id.btn_contact);

        btn_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
                startActivityForResult (in, RESULT_PICK_CONTACT);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case RESULT_PICK_CONTACT:
                    contactPicked(data);
                    break;
            }
        } else {
            Toast.makeText(this, "Failed To pick contact", Toast.LENGTH_SHORT).show();
        }
    }

    public void contactPicked(Intent data) {
        Cursor cursor = null;
        try {
            String phoneNo = null;
            Uri uri = data.getData();
            cursor = getContentResolver().query(uri, null, null, null, null);
            cursor.moveToFirst();
            int phoneIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            phoneNo = cursor.getString(phoneIndex);
//            txt_phone.setText(phoneNo);

            String str_getMOBILE;
            if(phoneNo.startsWith("+") || phoneNo.length()==13)
            {
                    str_getMOBILE=phoneNo.substring(3);
                    phoneNo=str_getMOBILE;
                    txt_phone.setText(phoneNo);
                }
                 else
                {
                    txt_phone.setText(phoneNo);
                 }

            btn_back = findViewById(R.id.btn_back);
            String finalPhoneNo = phoneNo.replaceAll("\\s","");;
            btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_back = new Intent(ContactActivity.this, MainActivity.class);
                intent_back.putExtra("phoneNo", finalPhoneNo);
                startActivity(intent_back);
                
            }
        });

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}