package com.sonuu.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HealthArticalsDetailsActivity extends AppCompatActivity {
    TextView tv;
    ImageView img;
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_articals_details);

        tv=findViewById(R.id.textViewHADtitle);
        img=findViewById(R.id.imageViewHAD);
        btnback=findViewById(R.id.buttonHADBack);

        Intent intent=getIntent();
        tv.setText(intent.getStringExtra("text1"));

        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            int resId=bundle.getInt("text2");
            img.setImageResource(resId);
        }
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthArticalsDetailsActivity.this,HealthArticalsActivity.class));
            }
        });

    }
}