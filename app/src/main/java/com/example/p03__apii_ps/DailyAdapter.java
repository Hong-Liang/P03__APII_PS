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

public class DailyAdapter extends ArrayAdapter<DailyGrade> {
    private ArrayList<DailyGrade> Secu;
    private Context context;
    private TextView tvDG, tvDate;
    private ImageView ivImage;

    public DailyAdapter(Context context, int resource, ArrayList<DailyGrade> objects){
        super(context, resource,objects);
        // Store the food that is passed to this adapter
        Secu = objects;
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
        View rowView = inflater.inflate(R.layout.row, parent, false);
        DailyGrade s = Secu.get(position);
        tvDG = (TextView) rowView.findViewById(R.id.tvDG);
        tvDG.setText(s.getDG());

        tvDate = (TextView) rowView.findViewById(R.id.tvDate);
        tvDate.setText("Week " + s.getDate());

        ivImage = (ImageView) rowView.findViewById(R.id.ivDG);
        ivImage.setImageResource(R.drawable.dg);

        return rowView;
    }
}
