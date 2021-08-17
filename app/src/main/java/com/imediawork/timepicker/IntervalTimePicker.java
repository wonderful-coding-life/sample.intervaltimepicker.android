package com.imediawork.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.List;

public class IntervalTimePicker extends TimePicker {
    private static final String TAG = "IntervalTimePicker";
    private int minuteInterval;

    public IntervalTimePicker(Context context) {
        super(context);
        init(null, 0);
    }

    public IntervalTimePicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public IntervalTimePicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.IntervalTimePicker, defStyle, 0);
        minuteInterval = a.getInteger(R.styleable.IntervalTimePicker_minuteInterval, 1);
        setMinuteInterval(minuteInterval);
        a.recycle();
    }

    public int getMinuteInterval() {
        return minuteInterval;
    }

    public void setMinuteInterval(int minuteInterval) {
        minuteInterval = minuteInterval;
        try {
            NumberPicker minutePicker = findViewById(Resources.getSystem().getIdentifier("minute", "id", "android"));
            minutePicker.setMinValue(0);
            minutePicker.setMaxValue((60 / minuteInterval) - 1);
            List<String> displayedValues = new ArrayList<String>();
            for (int i = 0; i < 60; i += minuteInterval) {
                displayedValues.add(String.format("%02d", i));
            }
            minutePicker.setDisplayedValues(displayedValues.toArray(new String[0]));
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e);
        }
    }

    @Override
    public Integer getCurrentMinute() {
        return super.getCurrentMinute() * minuteInterval;
    }
}
