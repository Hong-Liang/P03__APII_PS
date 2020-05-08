package com.example.p03__apii_ps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DailyActivity extends AppCompatActivity {

    TextView tvDG, tvWeek;
    Button btnInfo, btnAdd, btnEmail;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<DailyGrade> al;
    int requestCodeForDGStats = 1;
    String info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dg);

        tvDG = findViewById(R.id.tvDG);
        tvWeek = findViewById(R.id.tvDate);
        btnInfo = findViewById(R.id.btnInfo);
        btnAdd = findViewById(R.id.btnAdd);
        btnEmail = findViewById(R.id.btnEmail);
        lv = findViewById(R.id.lvDG);

        Intent i = getIntent();
        //Get the String array named info we passed in
        info = i.getStringExtra("MC");
        al = new ArrayList<DailyGrade>();

        if (info.contentEquals("C302")) {
            al.add(new DailyGrade(1, "B", "C302"));
            al.add(new DailyGrade(2, "C", "C302"));
            al.add(new DailyGrade(3, "A", "C302"));
        } else {
            al.add(new DailyGrade(1, "A", "C347"));
            al.add(new DailyGrade(2, "C", "C347"));
            al.add(new DailyGrade(3, "B", "C347"));
            al.add(new DailyGrade(3, "A", "C347"));
        }
        aa = new DailyAdapter(this, R.layout.row, al);
        lv.setAdapter(aa);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DailyGrade DG = new DailyGrade(al.size() + 1, "", "C347");
                Intent i = new Intent(DailyActivity.this, AddActivity.class);
                i.putExtra("DG", DG);
                startActivityForResult(i, requestCodeForDGStats);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "Test Email from C347");
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                if (info.contentEquals("C302")) {
                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C302"));
                } else {
                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C347"));
                }
                startActivity(rpIntent);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Only handle when 2nd activity closed normally
        //  and data contains something
        if(resultCode == RESULT_OK){
            if (data != null) {
                // Get data passed back from 2nd activity
                String like = data.getStringExtra("chose");
                // If it is activity started by clicking
                //  Superman, create corresponding String
                if(requestCode == requestCodeForDGStats) {
                    al.add(new DailyGrade(al.size() + 1, like, ""));
                }
                aa = new DailyAdapter(this, R.layout.row, al);
                lv.setAdapter(aa);
            }
        }
    }
}
