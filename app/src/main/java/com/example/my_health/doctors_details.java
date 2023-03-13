package com.example.my_health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class doctors_details extends AppCompatActivity {
    private String [][] PHYSICIAN = {
            {"Name : Dr. John Kamau ","Address : MD Health Center ","Experience : 5 Years ","Fees : Ksh. 2500"},
            {"Name : Dr. Sam mureithi ","Address : Central Park Teaching Hospital ","Experience : 7 Years ","Fees : ksh. 2500"},
            {"Name : Dr. Susan Wambui ","Address : MD Health Center ","Experience : 5 Years ","Fees : ksh. 2500"},
            {"Name : Dr. Joyce Wanjiru ","Address : MD Health Center ","Experience : 3 Years ","Fees : ksh. 2500"},
            {"Name : Dr. Titus Muchoki ","Address : Reactive Physio ","Experience : 5 Years ","Fees : ksh. 1000"},
            {"Name : Miss. Joy  ","Address : PhysioFitt Hospital ","Experience : 3 Years ","Fees : ksh. 2000"}
    };
    private String [][] DENTIST= {
            {"Name : Dr. Samuel Mburu ","Address : JA Aesthetics Dental Skin and Hair  ","Experience : 2 Years ","Fees : ksh. 2000"},
            {"Name : Dr. Simon Kamau ","Address : JA Aesthetics Dental Skin and Hair ","Experience : 4 Years ","Fees : ksh. 2000"},
            {"Name : Dr. David ONDIEK ","Address : Teeth and Gums - Best Veneers ","Experience : 4 Years ","Fees : Rs. 1000"},
            {"Name : Dr. Joel Sifuna","Address : Reliance Dental Care ","Experience : 12 Years ","Fees : ksh. 1800"},
            {"Name : Dr. David Kamau ","Address : Dental Care Clinic ","Experience : 27 Years ","Fees : ksh. 500"},
            {"Name : Dr. Silvia Muthoni","Address : Fatima Bai Hospital ","Experience : 1 Year ","Fees : ksh. 620"}
    };
    private String [][] SURGEON= {
            {"Name : Dr. Lee Mwega ","Address : kenyatta Memorial Trust Hospital ","Experience : 38 Years ","Fees : ksh. 3000"},
            {"Name : Dr. Tracy Wairinga","Address : Liaquat National Hospital ","Experience : 7 Years ","Fees : ksh. 1500"},
            {"Name : Dr. Faith Mukami","Address : Plasthetics ","Experience : 18 Years ","Fees : ksh. 2000"},
            {"Name : Prof. Dr. Onesmas Mbuchiri ","Address : Hill Park General Hospita ","Experience : 33 Years ","Fees : ksh. 1000"},
            {"Name : Dr. Titus Muchoki ","Address : Advanced International Hospital ","Experience : 15 Years ","Fees : ksh. 2000"},
            {"Name : Dr. Coby Wamae","Address : Sir Syed Hospital ","Experience : 20 Years ","Fees : ksh. 1000"}
    };
    private String [][] DIETITIAN= {
            {"Name : Ms. Rebecca Tariq ","Address : Omar Hospital & Cardiac Centre ","Experience : 13 Years ","Fees : ksh. 2500"},
            {"Name : Ms. Sarah Ikram ","Address : South City Hospital ","Experience : 14 Years ","Fees : ksh. 2500"},
            {"Name : Ms. Caroline Gathoni ","Address : Evon Aesthetic Center ","Experience : 7 Years ","Fees : ksh. 2000"},
            {"Name : Dr. Joel Kakai ","Address : Quick Care Clinic ","Experience : 25 Years ","Fees : ksh. 2500"},
            {"Name : Ms. Hilda Temo ","Address : Karachi Medical Complex ","Experience : 2 Years ","Fees : ksh. 2500"},
            {"Name : Dr. Noah Manacha","Address : Beautiholics Clinic ","Experience : 8 Years ","Fees : ksh. 1500"} } ;

    private String [][] CARDIOLOGIST={
            {"Name : Dr. Ibrahim Asif ","Address : Nairobi General Hospital ","Experience : 12 Years ","Fees : ksh. 1800"},
            {"Name : Dr. Abdul Wahab Shahid ","Address : Capital International Hospital ","Experience : 12 Years ","Fees : ksh. 1500"},
            {"Name : Dr. Asma Rauf ","Address : Newface Skin and Medical Center ","Experience : 7 Years ","Fees : ksh. 1500"},
            {"Name : Dr. Abdul Salam Wazir ","Address : HM Diagnostic Center  ","Experience : 25Years ","Fees : ksh. 2000"},
            {"Name : Dr. Paul Ngige ","Address : Smart Medical and Diagnostic ","Experience : 7 Years ","Fees : ksh. 2000"},
            {"Name : Assist. Prof. Dr. Ezekiel Kuria","Address : Mpisha Medical and Diagnostic ","Experience : 18 Years ","Fees : ksh. 1500"}
    };

    TextView doctext;
    ListView docdetails;
    Button backtomydoc;
    String [][] doc_details= {};
    ArrayList list;
    HashMap<String, String> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_details);
        doctext=findViewById(R.id.lab);
        docdetails=findViewById(R.id.cartdetails);
        backtomydoc=findViewById(R.id.backtomain);

        Intent it = getIntent();
        String title= it.getStringExtra("title");
        doctext.setText(title);

        if(title.compareTo("PHYSICIAN") == 0){
            doc_details = PHYSICIAN ;
        }
        if(title.compareTo("DENTIST") == 0){
            doc_details = DENTIST ;
        }
        if(title.compareTo("SURGEON") == 0){
            doc_details = SURGEON ;
        }
        if(title.compareTo("DIETITIAN") == 0){
            doc_details = DIETITIAN ;
        }
        if(title.compareTo("CARDIOLOGIST") == 0){
            doc_details = CARDIOLOGIST ;
        }
        

        backtomydoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(doctors_details.this,findmydoc.class));
            }
        });
        list = new ArrayList();
        for(int i = 0 ; i < doc_details.length;i++){
            item = new HashMap<String, String>();
            item.put("docname",doc_details[i][0]);
            item.put("docaddress",doc_details[i][1]);
            item.put("docexperience",doc_details[i][2]);
            item.put("docfees",doc_details[i][3]+" only");
            list.add(item);
        }
        SimpleAdapter adap = new SimpleAdapter(
                this,list,
                R.layout.detaildesign,
                new String[]{"docname","docaddress","docexperience","docfees"},
                new int[]{R.id.t_name, R.id.t_price,
                R.id.docexperience, R.id.docfees});
        docdetails.setAdapter(adap);
        docdetails.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(doctors_details.this,booking.class);
                intent.putExtra("docname",doc_details[i][0]);
                intent.putExtra("docaddress",doc_details[i][1]);
                intent.putExtra("docfees",doc_details[i][3]+" only");

                startActivity(intent);
            }
        });}


}