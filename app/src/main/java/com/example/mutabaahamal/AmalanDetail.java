package com.example.mutabaahamal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mutabaahamal.Model.AmalanLatest;
import com.example.mutabaahamal.Utils.Commonn;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

public class AmalanDetail extends AppCompatActivity {

    TextView title,description;
    KenBurnsView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amalan_detail);

        title = (TextView)findViewById(R.id.amalan_title);
        description = (TextView)findViewById(R.id.amalan_desciption);
        image = (KenBurnsView)findViewById(R.id.amalan_image);


        if(getIntent()!= null)
        {
            int amalan_index =getIntent().getIntExtra("amalan_index",-1);
            if (amalan_index != -1)
                loadAmalanDetail(amalan_index);
        }



    }

    private void loadAmalanDetail(int index) {
        AmalanLatest amalanLatest = Commonn.amalanLoaded.get(index);
        Picasso.get().load(amalanLatest.getImage()).into(image);
        title.setText(amalanLatest.getName());
        description.setText(amalanLatest.getDescription());
    }
}
