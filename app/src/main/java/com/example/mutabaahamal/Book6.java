package com.example.mutabaahamal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Book6 extends AppCompatActivity {

    PDFView book6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book6);

        book6=(PDFView)findViewById(R.id.pdfbook6);
        book6.fromAsset("dukhan.pdf").load();
    }
}
