package com.sonuu.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1={
            {"Doctor Name: Ajit Saste","Hospital AdDress : Pimpri","Exp : 5years","Mobile No.:9865241358","600"},
            {"Doctor Name: Prasad Pawar","Hospital Address : Nigdi","Exp : 15years","Mobile No.:6354897456","900"},
            {"Doctor Name: Swapnil kale","Hospital AdDress : Pune","Exp : 8years","Mobile No.:6956874512","300"},
            {"Doctor Name: Deepak Deshmukh","Hospital AdDress : Chinchwad","Exp : 6years","Mobile No.:8974589621","500"},
            {"Doctor Name: Ashok Panday","Hospital AdDress : Katraj","Exp : 7years","Mobile No.:8965231478","800"}};
    private String[][] doctor_details2={
            {"Doctor Name: Neelam Patil","Hospital AdDress : Pimpri","Exp : 5years","Mobile No.:9865241358","600"},
            {"Doctor Name: Swati Pawar","Hospital Address : Nigdi","Exp : 15years","Mobile No.:6354897456","900"},
            {"Doctor Name: Neeraj Samant","Hospital AdDress : Pune","Exp : 8years","Mobile No.:6956874512","300"},
            {"Doctor Name: Ajay Bachan","Hospital AdDress : Chinchwad","Exp : 6years","Mobile No.:8974589621","500"},
            {"Doctor Name: Alka Pandey","Hospital AdDress : Katraj","Exp : 7years","Mobile No.:8965231478","800"}};
    private String[][] doctor_details3={
            {"Doctor Name: Deepak Chandra","Hospital AdDress : Pimpri","Exp : 5years","Mobile No.:9865241358","600"},
            {"Doctor Name: Ashish Chauhan","Hospital Address : Nigdi","Exp : 15years","Mobile No.:6354897456","900"},
            {"Doctor Name: Preeti Malthotra","Hospital AdDress : Pune","Exp : 8years","Mobile No.:6956874512","300"},
            {"Doctor Name: Abhishek Sharma","Hospital AdDress : Chinchwad","Exp : 6years","Mobile No.:8974589621","500"},
            {"Doctor Name: Vishal Pathak","Hospital AdDress : Katraj","Exp : 7years","Mobile No.:8965231478","800"}};
    private String[][] doctor_details4={
            {"Doctor Name: Shreya Pathak","Hospital AdDress : Pimpri","Exp : 5years","Mobile No.:9865241358","600"},
            {"Doctor Name: Prashant Rawat","Hospital Address : Nigdi","Exp : 15years","Mobile No.:6354897456","900"},
            {"Doctor Name: Vivek Rawat","Hospital AdDress : Pune","Exp : 8years","Mobile No.:6956874512","300"},
            {"Doctor Name: Karan Singh","Hospital AdDress : Chinchwad","Exp : 6years","Mobile No.:8974589621","500"},
            {"Doctor Name: Kamlesh Mehra","Hospital AdDress : Katraj","Exp : 7years","Mobile No.:8965231478","800"}};
    private String[][] doctor_details5={
            {"Doctor Name: Sachin Joshi","Hospital AdDress : Pimpri","Exp : 5years","Mobile No.:9865241358","600"},
            {"Doctor Name: Abhikant terance","Hospital Address : Nigdi","Exp : 15years","Mobile No.:6354897456","900"},
            {"Doctor Name: Disha Patani","Hospital AdDress : Pune","Exp : 8years","Mobile No.:6956874512","300"},
            {"Doctor Name: Tiger Malik","Hospital AdDress : Chinchwad","Exp : 6years","Mobile No.:8974589621","500"},
            {"Doctor Name: Ananaya Panday","Hospital AdDress : Katraj","Exp : 7years","Mobile No.:8965231478","800"}};
    TextView tv;
    Button btn;
    String[][] doctor_details={};
    ArrayList list;
    HashMap<String,String>item;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv=findViewById(R.id.textViewDDTitle);
        btn=findViewById(R.id.buttonDDBack);
        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physicians")==0)
            doctor_details=doctor_details1;
        else
        if (title.compareTo("Dietician")==0)
            doctor_details=doctor_details2;
        else
        if (title.compareTo("Dentists")==0)
            doctor_details=doctor_details3;
        else
        if (title.compareTo("Surgeon")==0)
            doctor_details=doctor_details4;
        else
            doctor_details=doctor_details5;



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });
        list =new ArrayList();
        for (int i = 0; i <doctor_details.length ; i++) {
            item=new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons fees: "+doctor_details[i][4]+"/-"); // "/-" this is the symbol of rupees
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst=findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it=new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);//[2] is skipped because experience is not required to book appointment
                startActivity(it);
            }
        });

    }
}