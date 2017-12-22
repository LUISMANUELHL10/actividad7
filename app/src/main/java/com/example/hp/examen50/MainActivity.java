package com.example.hp.examen50;

import android.Manifest;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnGetLoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGetLoc = (Button) findViewById(R.id.btnGetloc);
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},123);
        btnGetLoc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                GPStracker g = new GPStracker(getApplicationContext());
                Location l = g.getLocation();
                if(l != null){
                    double lat = l.getLatitude();
                    double lon = l.getLongitude();
                    Toast.makeText(getApplicationContext(), "LAT:  "+lat+" \n   LON :  " + lon,Toast.LENGTH_LONG).show();
                    ((EditText)findViewById(R.id.etLocationLat)).setText("Latitud: " + lat);
                    ((EditText)findViewById(R.id.etLocationLong)).setText("Longitud: " + lon);

                }

            }

        });
    }}
