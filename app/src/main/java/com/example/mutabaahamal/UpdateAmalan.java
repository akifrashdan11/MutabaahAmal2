package com.example.mutabaahamal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UpdateAmalan extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateamalan);

        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSdM6aMemUzp2TrSjdvVeSoDIMaGllvI7_IAn8LJegDzfLaFbw/viewform?usp=sf_link");








        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.update);
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
                        startActivity(new Intent(getApplicationContext(),AmalanList.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.update:
                        return true;
                    case R.id.other:
                        startActivity(new Intent(getApplicationContext(),AboutUs.class));
                        overridePendingTransition(0,0);

                        return true;
                }
                return false;
            }
        });



        FloatingActionButton fab4 =findViewById(R.id.action4);
        FloatingActionButton fab5 =findViewById(R.id.action5);


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




    }




    public void openActivity4(){
        Intent intent = new Intent(this,UpdateAmalan.class);
        startActivity(intent);
    }
    public void openActivity5(){
        Intent intent = new Intent(this,UpdateUsrah.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
