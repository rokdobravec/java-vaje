package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ImageView imageView;
EditText editText, editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                     //PRIKAZ ACTIVITY
        imageView=findViewById(R.id.imageView);
        editText=findViewById(R.id.editTextTextPersonName);
        editText2=findViewById(R.id.editTextTextPersonName2);
        registerForContextMenu(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.meni,menu);                    //PRIKAZ OPTIONS MENIJA
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {                      //DOGODEK NA OPTIONS MENIJU
        Animation animation =null;
        switch(item.getItemId())
        {
            case R.id.one:
                animation= AnimationUtils.loadAnimation(this,R.anim.animacija);            //KLIC ANIMACIJE
                imageView.startAnimation(animation);
                break;
            case R.id.two:
                Intent intent = new Intent(this,MainActivity2.class);                   //PREHOD NA ACTIVITY_2
                intent.putExtra("IME", editText.getText().toString());
                startActivity(intent);
                break;
            case R.id.three:
                Toast.makeText(this, editText2.getText().toString()+" "+editText.getText().toString() , Toast.LENGTH_SHORT).show();     //POKAŽEMO BESEDILO IZ EDITTEXT V MESSAGE BOX
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        Toast.makeText(this, "Pavza", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.meni,menu);                                                        //PRIKAŽEMO CONTEX MENU
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {          //DOGODEK NA CONTEXT MENIJU
        Animation animation =null;
        switch(item.getItemId())
        {
            case R.id.one:
                animation= AnimationUtils.loadAnimation(this,R.anim.animacija);             //KLIČEMO ANIMACIJO
                imageView.startAnimation(animation);
                break;
            case R.id.two:
                Toast.makeText(this, "two", Toast.LENGTH_SHORT).show();                     //OPOZORILNO OKNO IZPISŠE TWO
                break;
            case R.id.three:
                Toast.makeText(this, "three", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}