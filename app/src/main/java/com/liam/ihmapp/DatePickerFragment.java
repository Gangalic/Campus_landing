package com.liam.ihmapp;

import android.app.DatePickerDialog;
import android.app.Dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker.
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it.

        DatePickerDialog datePick = new DatePickerDialog(getActivity(),R.style.DatePickerDialogTheme, this, year, month, day);
        datePick.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        return datePick;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        WantAThing activity = (WantAThing) getActivity();
        activity.processDatePickerResult(year, month, day);
    }
}