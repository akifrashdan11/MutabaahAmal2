package com.example.mutabaahamal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.api.Advice;

public class AmalanList extends AppCompatActivity {

    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amalan_list);

        MobileAds.initialize(this, "ca-app-pub-6165453270461404~3252016272");

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-6165453270461404/2770275325");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed(){
                super.onAdClosed();
                finish();
            }
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.main);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.pdf:
                        startActivity(new Intent(getApplicationContext(),Pdf.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.fadhail:
                        startActivity(new Intent(getApplicationContext(),FadhilatAmalan.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.main:
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


        FloatingActionButton fab1 =findViewById(R.id.action1);
        FloatingActionButton fab2 =findViewById(R.id.action2);
        FloatingActionButton fab3 =findViewById(R.id.action3);
        FloatingActionButton fab4 =findViewById(R.id.action4);
        FloatingActionButton fab5 =findViewById(R.id.action5);
        FloatingActionButton fab6 =findViewById(R.id.action6);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity1();
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });
        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity4();
            }
        });
        fab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity5();
            }
        });
        fab6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity6();
            }
        });





    }

    public void showIntewrestial(){
        if(mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        }else {
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        showIntewrestial();
    }


    public void openActivity1(){
        Intent intent = new Intent(this,AmalanList.class);
        startActivity(intent);
    }

    public void openActivity2(){
        Intent intent = new Intent(this,FadhilatAmalan.class);
        startActivity(intent);
    }

    public void openActivity3(){
        Intent intent = new Intent(this, Pdf.class);
        startActivity(intent);
    }

    public void openActivity4(){
        Intent intent = new Intent(this,UpdateAmalan.class);
        startActivity(intent);
    }
    public void openActivity5(){
        Intent intent = new Intent(this,UpdateUsrah.class);
        startActivity(intent);
    }
    public void openActivity6(){
        Intent intent = new Intent(this,AboutUs.class);
        startActivity(intent);
    }

}
