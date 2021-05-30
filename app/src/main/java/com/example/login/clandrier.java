package com.example.login;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;



public class clandrier extends AppCompatActivity {

    CompactCalendarView compactcalendar;
    private SimpleDateFormat dataFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clandrier);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle(null);

        compactcalendar = (CompactCalendarView) findViewById(R.id.compactcalendarview);
        compactcalendar.setUseThreeLetterAbbreviation(true);

        Event ev1 = new Event(Color.BLUE, 1622073600000L, "heloooooo dude");
        compactcalendar.addEvent(ev1);

        compactcalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Context context = getApplicationContext();
                if (dateClicked.toString().compareTo("Thu May 27 00:00:00 GMT+01:00 2021") == 0) {
                    Toast.makeText(context, "heloooooo dude", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "NoeventUstupid", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                actionBar.setTitle(dataFormatMonth.format(firstDayOfNewMonth));

            }
        });

    }
}