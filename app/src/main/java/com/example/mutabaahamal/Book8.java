package com.example.mutabaahamal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Book8 extends AppCompatActivity {

    PDFView book8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book8);

        book8=(PDFView)findViewById(R.id.pdfbook8);
        book8.fromAsset("WirdulLatif.pdf").load();

    }
}
