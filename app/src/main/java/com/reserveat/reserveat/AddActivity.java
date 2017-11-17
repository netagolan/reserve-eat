package com.reserveat.reserveat;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import java.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class AddActivity extends AppCompatActivity {

    EditText edittext;
    EditText hourEdittext;
    Calendar current = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        //Calendar myCalendar = Calendar.getInstance();

        edittext= (EditText) findViewById(R.id.date);
        hourEdittext = (EditText) findViewById(R.id.hour);

        edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int year = current.get(Calendar.YEAR);
                int month  = current.get(Calendar.MONTH);
                int day  = current.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dpd = new DatePickerDialog(AddActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        edittext.setHint(i2+"/"+(i1+1)+"/"+i);
                        //Toast.makeText(MainActivity.this, i2+"/"+(i1+1)+"/"+i, Toast.LENGTH_SHORT).show();
                    }
                },year,month,day);
                dpd.show();
            }
        });

        hourEdittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour = current.get(Calendar.HOUR_OF_DAY);
                int minutes = current.get(Calendar.MINUTE);
                TimePickerDialog tpd = new TimePickerDialog(AddActivity.this , new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        hourEdittext.setHint(i+":"+i1);
                        //Toast.makeText(MainActivity.this, i+":"+i1, Toast.LENGTH_SHORT).show();
                    }
                },hour,minutes,true);
                tpd.show();
            }
        });

    }
}
