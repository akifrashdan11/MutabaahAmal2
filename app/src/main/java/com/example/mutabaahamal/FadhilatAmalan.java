package com.example.mutabaahamal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.example.mutabaahamal.Adapter.AmalanAdapterr;
import com.example.mutabaahamal.Model.AmalanLatest;
import com.example.mutabaahamal.Utils.Commonn;
import com.example.mutabaahamal.Utils.IFirebaseLoadDone;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.Annotation;
import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;
import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class FadhilatAmalan extends AppCompatActivity implements IFirebaseLoadDone {


    IFirebaseLoadDone iFirebaseLoadDone;
    DatabaseReference dbRef;
    AlertDialog dialog;
    FeatureCoverFlow coverFlow;
    TextSwitcher title;
    AmalanAdapterr amalanAdapterr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);







        iFirebaseLoadDone = this;
        loadData();


        dialog = new SpotsDialog.Builder().setContext(FadhilatAmalan.this)
                .setMessage("Tunggu sat...")
                .setCancelable(false)
                .build();
        dialog.show();

        dbRef = FirebaseDatabase.getInstance().getReference("AmalanLatest");
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {

            List<AmalanLatest> amalanLatests = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot amalanSnapShot : dataSnapshot.getChildren()){

                    AmalanLatest amalanLatest = amalanSnapShot.getValue(AmalanLatest.class);
                    amalanLatests.add(amalanLatest);
                }
                iFirebaseLoadDone.onFirebaseLoadSuccess(amalanLatests);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                iFirebaseLoadDone.onFirebaseLoadFailed(databaseError.getMessage());

            }
        });





    }




    private void loadData() {
    }

    @Override
    public void onFirebaseLoadSuccess(List<AmalanLatest> amalanLatestList) {
        dialog.dismiss();
        setupUI();
        Commonn.amalanLoaded = amalanLatestList;


        amalanAdapterr = new AmalanAdapterr(this,amalanLatestList);
        coverFlow.setAdapter(amalanAdapterr);
        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                title.setText(Commonn.amalanLoaded.get(position).getName());


            }

            @Override
            public void onScrolling() {

            }
        });
        coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(FadhilatAmalan.this,AmalanDetail.class);
                intent.putExtra("amalan_index",i);
                startActivity(intent);

            }
        });


    }

    private void setupUI() {
        setContentView(R.layout.activity_fadhilat_amalan);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.fadhail);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.pdf:
                        startActivity(new Intent(getApplicationContext(),Pdf.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.fadhail:
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






        coverFlow =(FeatureCoverFlow)findViewById(R.id.coverFlow);
        title = (TextSwitcher)findViewById(R.id.mtitle);
        title.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(FadhilatAmalan.this);
                TextView txt = (TextView)inflater.inflate(R.layout.layout_title,null);
                return txt;
            }
        });

        Animation in = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right);
        title.setInAnimation(in);
        title.setOutAnimation(out);

        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float density = getResources().getDisplayMetrics().density;
        float dpHeight = outMetrics.heightPixels/density;
        float dpWiidth = outMetrics.widthPixels/density;

        coverFlow.setCoverHeight((int)dpHeight);
        coverFlow.setCoverHeight((int)dpWiidth);







    }

    @Override
    public void onFirebaseLoadFailed(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();

    }
}
