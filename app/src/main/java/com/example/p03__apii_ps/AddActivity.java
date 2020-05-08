package com.example.p03__apii_ps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {

    TextView tvWeek;
    Button btnSubmit;
    ListView lv;
    ImageView iv;
    ArrayList<DailyGrade> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        btnSubmit = findViewById(R.id.btnSubmit);
        tvWeek = findViewById(R.id.tvDay);

        Intent i = getIntent();
        DailyGrade DG = (DailyGrade) i.getSerializableExtra("DG");

        tvWeek.setText("Week " + DG.getDate());

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the RadioGroup object
                RadioGroup rg = (RadioGroup) findViewById(R.id.rgChoice);
                // Get the Id of the selected radio button in the RadioGroup
                int selectedButtonId = rg.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                Intent i = new Intent();
                i.putExtra("chose", rb.getText().toString());
                setResult(RESULT_OK, i);
                finish();
            }
        });

    }
}
