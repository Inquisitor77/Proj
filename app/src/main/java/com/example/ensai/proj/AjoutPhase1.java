package com.example.ensai.proj;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class AjoutPhase1 extends AppCompatActivity {

    String nom ;
    String descrip;
    EditText txtDate;
    EditText txtTime;
    private int mYear, mMonth, mDay,mHour, mMinute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_phase1);

        txtDate = (EditText) findViewById(R.id.date);
        txtTime = (EditText) findViewById(R.id.heure);

        nom = ((EditText) findViewById(R.id.nom)).getText().toString();
        descrip = ((EditText) findViewById(R.id.description)).getText().toString();
    }

    public void valider(View V){
        //Test au debut pour verifier la recuperation de date
        //String blabla= mDay+" " +mMonth+" " +mYear;
        //Toast.makeText(this, blabla, Toast.LENGTH_SHORT).show();
        //String blabla= mHour+" " +mMinute;
        //Toast.makeText(this, blabla, Toast.LENGTH_SHORT).show();

    }

    public void date(View v){
        // Process to get Current Date
        final Calendar c = Calendar.getInstance();
         mYear = c.get(Calendar.YEAR);
         mMonth = c.get(Calendar.MONTH);
         mDay = c.get(Calendar.DAY_OF_MONTH);

        // Launch Date Picker Dialog
        DatePickerDialog dpd = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // Display Selected date in textbox
                        txtDate.setText(dayOfMonth + "-"
                                + (monthOfYear + 1) + "-" + year);
                        mYear= year;
                        mMonth=monthOfYear+1;
                        mDay=dayOfMonth;
                    }
                }, mYear, mMonth, mDay);
        dpd.show();
    }

    public void heure(View v){
        // Process to get Current Date
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Date Picker Dialog
        TimePickerDialog tpd = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        // Display Selected time in textbox
                        txtTime.setText(hourOfDay + ":" + minute);
                        mHour= hourOfDay;
                        mMinute=minute;
                    }
                }, mHour, mMinute, false);
        tpd.show();
    }
}
