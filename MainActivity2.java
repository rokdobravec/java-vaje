package com.example.rokdobravecbled;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView rezultat;
    RadioButton Sestevanje, Odstevanje, Mnozenje, Deljenje;
    Button izracun, naslednaStran;
    EditText x,y;
    ImageView slika;
    Switch stikalo;
    double produkt, kolicnik, sestevek, razlika;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        rezultat = findViewById(R.id.idRezultat);
        Sestevanje = findViewById(R.id.idSestevanje);
        Odstevanje = findViewById(R.id.idOdstevanje);
        Mnozenje = findViewById(R.id.idMnozenje);
        Deljenje = findViewById(R.id.idDeljenje);
        izracun = findViewById(R.id.button2);
        slika = findViewById(R.id.imageView3);
        stikalo = findViewById(R.id.switch1);
        x = findViewById(R.id.editTextNumberDecimal3);
        y = findViewById(R.id.editTextNumberDecimal4);


        Intent intent = getIntent();
        double lat = intent.getDoubleExtra(MainActivity.EXTRA_LAT, 0);
        double lon = intent.getDoubleExtra(MainActivity.EXTRA_LON, 0);

        x.setText(lat + "");
        y.setText(lon + "");

        izracun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double number_x = Double.parseDouble(x.getText().toString());
                double number_y = Double.parseDouble(y.getText().toString());
                produkt = number_x * number_y;
                kolicnik = number_x / number_y;
                sestevek = number_x + number_y;
                razlika = number_x - number_y;
            }
        });
        Odstevanje.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (Odstevanje.isChecked()){
                    String string_razlika = Double.toString(razlika);
                    rezultat.setText(string_razlika);
                }
            }
        });
        Sestevanje.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (Sestevanje.isChecked()){
                    String string_sestevek = Double.toString(sestevek);
                    rezultat.setText(string_sestevek);
                }
            }
        });
        Mnozenje.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (Mnozenje.isChecked()){
                    String string_mnozenje = Double.toString(produkt);
                    rezultat.setText(string_mnozenje);
                }
            }
        });
        Deljenje.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (Deljenje.isChecked()){
                    String string_kolicnik = Double.toString(kolicnik);
                    rezultat.setText(string_kolicnik);
                }
            }
        });
        stikalo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b==false){
                    //services off
                    stopService(new Intent(MainActivity2.this, MyService.class));
                }
                else{
                    // services on
                    startService(new Intent(MainActivity2.this, MyService.class));
                }
            }
        });
        naslednaStran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.meni2, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Animation animation = null;
        switch(item.getItemId()){
            case R.id.idKombAnim:
                animation = AnimationUtils.loadAnimation(this, R.anim.kobinacija);
                slika.startAnimation(animation);
        }
        return super.onContextItemSelected(item);
    }
}