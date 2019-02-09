package com.csci490bn.intentdemo;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity
{
    private int request;
    private ImageView supermoon;
    private ImageView waterfall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        supermoon = findViewById(R.id.supermoon);
        waterfall = findViewById(R.id.waterfall);


        supermoon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                Toast.makeText(getApplicationContext(), "supermoon", Toast.LENGTH_SHORT).show();
                request = R.drawable.supermoon;
                finish();
            }
        });

        waterfall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "waterfall", Toast.LENGTH_SHORT).show();
                request = R.drawable.waterfall;
                finish();
            }
        });
    }

    @Override
    public void finish()
    {
        Intent intent = new Intent();
        intent.putExtra("request", request);
        setResult(RESULT_OK, intent);
        super.finish();
    }
}
