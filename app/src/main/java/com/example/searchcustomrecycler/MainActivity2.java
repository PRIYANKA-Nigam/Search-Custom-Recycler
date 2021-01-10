package com.example.searchcustomrecycler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
int image;String name;
    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView=(ImageView)findViewById(R.id.imageView);
        textView=(TextView)findViewById(R.id.textView);
        Bundle bundle=getIntent().getExtras(); if (bundle!=null) {
            image = bundle.getInt("Image", 0);
            name = bundle.getString("title");
        }
        imageView.setImageResource(image);
        textView.setText(name);
    }
}