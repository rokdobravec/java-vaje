package com.example.rokdobravecbled;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_LAT = "LAT";
    public static final String EXTRA_LON = "LON";

    ConstraintLayout constraintLayout;
    ImageView bled;
    TextView besedilo;
    EditText lat, lon;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.ConstraintLayout);
        bled = findViewById(R.id.imageView2);
        besedilo = findViewById(R.id.textView3);
        lat = findViewById(R.id.editTextNumberDecimal);
        lon = findViewById(R.id.editTextNumberDecimal2);
        btn = findViewById(R.id.button);

        lat.setText("46.361");
        lon.setText("14.095");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num_lat = Double.parseDouble(lat.getText().toString());
                double num_lon = Double.parseDouble(lon.getText().toString());

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra(EXTRA_LAT, num_lat);
                intent.putExtra(EXTRA_LON, num_lon);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, R.string.Pause, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.meni, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Animation animation = null;
        switch(item.getItemId()){
            case R.id.id1:
                constraintLayout.setBackgroundColor(Color.rgb(255, 193, 7));
                break;
            case R.id.id2:
                animation = AnimationUtils.loadAnimation(this, R.anim.vrtenje);
                bled.startAnimation(animation);
                break;
            case R.id.id3:
                besedilo.setTextColor(Color.rgb(255,0,0));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}