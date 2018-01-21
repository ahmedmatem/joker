package com.example.android.exposelib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView jokeTextView = (TextView) findViewById(R.id.tv_joke);

        Intent intent = getIntent();
        if(intent.hasExtra("joke")){
            jokeTextView.setText(intent.getStringExtra("joke"));
        } else {
            jokeTextView.setText(R.string.invalid_joke);
        }
    }
}
