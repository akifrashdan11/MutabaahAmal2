package com.example.mutabaahamal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Book5 extends AppCompatActivity {

    PDFView book5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book5);

        book5=(PDFView)findViewById(R.id.pdfbook5);
        book5.fromAsset("Sajadah.pdf").load();

    }
}
