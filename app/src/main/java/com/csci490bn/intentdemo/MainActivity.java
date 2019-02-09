package com.csci490bn.intentdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.constraint.ConstraintLayout;

public class MainActivity extends AppCompatActivity
{
    public static final int code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void backgroundSetter(View v)
    {
        Toast.makeText(getApplicationContext(), "button pressed", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivityForResult(intent, code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == code && resultCode == Activity.RESULT_OK)
        {
            Bundle extras = data.getExtras();
            if (extras != null)
            {
                int request = extras.getInt("request");
                ConstraintLayout currentLayout = findViewById(R.id.mainLayout);
                currentLayout.setBackground(getDrawable(request));
            }
        }
    }
}
