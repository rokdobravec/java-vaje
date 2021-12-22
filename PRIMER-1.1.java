package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);                        //prikaz activity2
        Intent intent = getIntent();                                    //USTVARIMO INTENT
        String ime = intent.getStringExtra("IME");                      
        Toast.makeText(this, ime, Toast.LENGTH_SHORT).show();
    }
    public void zapiranje(View view)
    {
        finish();                                                   
    }
}