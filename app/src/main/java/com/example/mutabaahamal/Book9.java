package com.example.mutabaahamal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Book9 extends AppCompatActivity {

    PDFView book9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book9);


        book9=(PDFView)findViewById(R.id.pdfbook9);
        book9.fromAsset("al-Haddad.pdf").load();
    }
}
