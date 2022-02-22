package com.example.newprojectninos;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivity2 extends AppCompatActivity {
    ImageView imageView;
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView = findViewById(R.id.IVimage);
        tvName = findViewById(R.id.TVtext);
        Glide.with(this)
                .load(getIntent().getStringExtra("name"))
                .into(imageView);
        tvName.setText(getIntent().getStringExtra("id"));
    }
}