package com.example.p03__apii_ps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Module> al;
    TextView tvMC, tvMN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lvModules);
        tvMC = findViewById(R.id.tvModuleCode);
        tvMN = findViewById(R.id.tvModuleName);

        al = new ArrayList<Module>();
        al.add(new Module("Web Services", "C302"));
        al.add(new Module("Android Programming II", "C347"));

        aa = new ModAdapter(this, R.layout.activity_main_row, al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String MC = al.get(position).getModuleCode();
                Intent i = new Intent(MainActivity.this, DailyActivity.class);
                i.putExtra("MC", MC);
                startActivity(i);
            }
        });
    }
}
