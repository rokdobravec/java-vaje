package com.example.fcinternazionalemilano;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ConstraintLayout ozadje1;                   //NASTAVIMO CONSTRAINT LAYOUT KOT OZADJE

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                     //PRIKAZ ACTIVITY1

        imageView=findViewById(R.id.imageView);                         //NASTAVIMO IMAGE VIEW KOT SPREMENLJIVKO
        registerForContextMenu(imageView);                             // NASTAVIMO DA JE IMAGEVIEW CONTEXT MENU

        ozadje1=findViewById(R.id.ozadje1);                             //NASTAVIMO OZADJE KOT SPREMENLJIVKO
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.meni1, menu);              //PRIKAŽEMO OPTIONS MENU
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Random random = new Random();                                                       //NAREDIMO SPREMENLJIVKO RANDOM
        ozadje1.setBackgroundColor(Color.rgb(random.nextInt(255), random.nextInt(255),random.nextInt(255)));            // NASTAVIMO OZADJE NA RANDOM BARVO
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.meni2, menu);                                                  //PRIKAŽEMO CONTEXT MENU
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.details:
                Intent intent1 = new Intent(this, MainActivity2.class);                                 //OB PRITISKU NA CONTEXT ITEM ODPRE ACTIVITY2
                startActivity(intent1);
                break;
            case R.id.www:
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.inter.it"));         //OB KLIKU NA CONTEXT ITEM ODPRE URL
                startActivity(intent2);
                break;
        }
        return super.onContextItemSelected(item);
    }
}