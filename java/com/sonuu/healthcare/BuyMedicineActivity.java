package com.sonuu.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][] packages=
            {
                    {"uprise-D3 1000IU Capsuke", "", "", "", "50"},
                    {"HealthVit Chromium Picolinate 200mcg Capsule", "", "", "", "305"},
                    {"Vitamin B Complex Capsules", "", "", "", "448"},
                    {"nlife Vitamin E Wheat Germ Oil Capsule", "", "", "", "539"},
                    {"Dolo 650 Advance Tablet", "", "", "", "50"},
                    {"Crocin 650 Advance Tablet", "", "", "", "50"},
                    {"Strepils Medicated Lozenges for Sore Throat", "", "", "", "40"},
                    {"Tata 1mg Calcium + Vitamin D3","","","","30"},
                    {"Feronia-XT Tablet","","","","130"},
            };

    private String[] package_details={
            "Buiding and keeping the bined & teeth strong\n" +
                    "Reducing Fatigue/Stress and Muscular pains\n"+
                    "Boosting immunity and increasing resistance against infection",
            "Chromiun is an essential trace mineral that plays an important role in helping insulin regulated",
            "Provide relief from vitamin B deficiencies\n"+
                    "helps in formation of red blood cells\n"+
                    "maintains healthy nervous system",
            "it promotes health as well as skin benifits\n"+
                    "it helps reduce skin blemish and pigmentation\n"+
                    "it acts as safeguard the skin from the harsh UVA and UVB sun rays",
            "Dolo 650 Tablets helps relieve pain and fever by blocking the releas of certain chemical",
            "helps relieve fever and bring down a high temperature\n"+
                    "suitable for people with heart cocndition or hogh blood pressure",
            "Relieves the symptom of a bacterial throat infectio and soothes the recovery process\n"+
                    "provides a warn and conforting feelings during sore throat",
            "reduce the risk of calcium deficiency,Rickets and osteoporosis\n"+
                    "Promotes mobability anf flexibility of joints",
            "helps to reduce the iron deficiency ue to chronic blood loss or low intake of iron"
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack,btnGoToCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        btnBack=findViewById(R.id.buttonBMDBack);
        btnGoToCart=findViewById(R.id.buttonBMDAddToCart);
        lst=findViewById(R.id.listViewBM);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });
        list=new ArrayList();
        for (int i = 0; i < packages.length; i++) {
            item=new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total Cost:"+packages[i][4]+"/-");
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e,});

        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it=new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });

    }
}