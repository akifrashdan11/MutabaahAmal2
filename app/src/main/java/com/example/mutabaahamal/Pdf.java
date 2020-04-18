package com.example.mutabaahamal;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Pdf extends AppCompatActivity {

    Button bu1,bu2,bu3,bu4,bu5,bu6,bu7,bu8,bu9,bu10,bu11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf);



        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.pdf);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.pdf:

                        return true;
                    case R.id.fadhail:
                        startActivity(new Intent(getApplicationContext(),FadhilatAmalan.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.main:
                        startActivity(new Intent(getApplicationContext(),AmalanList.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.update:
                        startActivity(new Intent(getApplicationContext(),UpdateAmalan.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.other:
                        startActivity(new Intent(getApplicationContext(),AboutUs.class));
                        overridePendingTransition(0,0);

                        return true;
                }
                return false;
            }
        });











        bu1 = (Button) findViewById(R.id.button1);
        bu2 = (Button) findViewById(R.id.button2);
        bu3 = (Button) findViewById(R.id.button3);
        bu4 = (Button) findViewById(R.id.button4);
        bu5 = (Button) findViewById(R.id.button5);
        bu6 = (Button) findViewById(R.id.button6);
        bu7 = (Button) findViewById(R.id.button7);
        bu8 = (Button) findViewById(R.id.button8);
        bu9 = (Button) findViewById(R.id.button9);
        bu10 = (Button) findViewById(R.id.button10);
        bu11 = (Button) findViewById(R.id.button11);


        bu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Pdf.this,Book1.class);
                startActivity(i);
            }
        });


        bu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(Pdf.this,Book2.class);
                startActivity(i1);
            }
        });

        bu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(Pdf.this,Book3.class);
                startActivity(i2);
            }
        });

        bu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3=new Intent(Pdf.this,Book4.class);
                startActivity(i3);
            }
        });

        bu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4=new Intent(Pdf.this,Book5.class);
                startActivity(i4);
            }
        });

        bu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i5=new Intent(Pdf.this,Book6.class);
                startActivity(i5);
            }
        });

        bu7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i6=new Intent(Pdf.this,Book7.class);
                startActivity(i6);
            }
        });

        bu8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i7=new Intent(Pdf.this,Book8.class);
                startActivity(i7);
            }
        });

        bu9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i8=new Intent(Pdf.this,Book9.class);
                startActivity(i8);
            }
        });

        bu10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i9=new Intent(Pdf.this,Book10.class);
                startActivity(i9);
            }
        });

        bu11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i10=new Intent(Pdf.this,Book11.class);
                startActivity(i10);
            }
        });



    }




}
