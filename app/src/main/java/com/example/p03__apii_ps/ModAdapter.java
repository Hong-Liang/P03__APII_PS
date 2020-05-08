package com.example.p03__apii_ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.p03__apii_ps.DailyGrade;

import java.util.ArrayList;

public class ModAdapter extends ArrayAdapter<Module> {
    private ArrayList<Module> Mod;
    private Context context;
    private TextView tvMC, tvMN;

    public ModAdapter(Context context, int resource, ArrayList<Module> objects){
        super(context, resource,objects);
        // Store the food that is passed to this adapter
        Mod = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
// "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.activity_main_row, parent, false);
        Module s = Mod.get(position);
        tvMC = (TextView) rowView.findViewById(R.id.tvModuleCode);
        tvMC.setText(s.getModuleCode());

        tvMN = (TextView) rowView.findViewById(R.id.tvModuleName);
        tvMN.setText(s.getModuleName());
        return rowView;
    }
}
