package com.example.mutabaahamal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Book11 extends AppCompatActivity {

    PDFView book11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book11);

        book11=(PDFView)findViewById(R.id.pdfbook11);
        book11.fromAsset("Mathurat.pdf").load();

    }
}
