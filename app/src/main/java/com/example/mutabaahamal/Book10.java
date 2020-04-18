package com.example.mutabaahamal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Book10 extends AppCompatActivity {

    PDFView book10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book10);

        book10=(PDFView)findViewById(R.id.pdfbook10);
        book10.fromAsset("WiridSakran.pdf").load();
    }
}
