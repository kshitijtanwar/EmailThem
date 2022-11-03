package com.example.emailthem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText mail_address;
    EditText subject;
    EditText body;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail_address = findViewById(R.id.mail_address);
        subject = findViewById(R.id.subject);
        body = findViewById(R.id.body);
        send = findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String addressTxt = mail_address.getText().toString();
                String[] address_as_string = {addressTxt};
                String subjectTxt = subject.getText().toString();
                String bodyTxt = body.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_EMAIL, address_as_string);
                intent.putExtra(Intent.EXTRA_SUBJECT, subjectTxt);
                intent.putExtra(Intent.EXTRA_TEXT, bodyTxt);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}