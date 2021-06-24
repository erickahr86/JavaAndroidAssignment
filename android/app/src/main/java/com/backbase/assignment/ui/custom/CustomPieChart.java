package com.backbase.assignment.ui.custom;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.StyleableRes;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.backbase.assignment.R;


public class CustomPieChart extends ConstraintLayout
{
    @StyleableRes
    int index0      = 0;
    int inputValue  = 0;

    private TextView    valueText   ;
    private ProgressBar progressBar ;

    public CustomPieChart (Context context,  AttributeSet attrs)
    {
        super ( context, attrs );

        init ( context, attrs );
    }

    private void init( Context context, AttributeSet attrs )
    {
        inflate( context, R.layout.custom_pie_chart, this );

        int[] sets = { R.attr.value_progress };

        TypedArray   typedArray = context.obtainStyledAttributes( attrs, sets );
        inputValue = typedArray.getInt (index0, 0);

        typedArray.recycle();

        initComponents();
    }

    private void initComponents()
    {
        progressBar = findViewById( R.id.circularProgressbar );
        valueText   = findViewById( R.id.value               );

        setValue ( inputValue );
    }

    public void setValue( int value )
    {
        inputValue = value;

        valueText  .setText     ( value + "%" );
        progressBar.setProgress ( inputValue  );

        progressBar.setProgressTintList (ColorStateList.valueOf (getResources ().getColor (R.color.cool_rate)));

        if ( value < progressBar.getMax () / 2 )
        {
            progressBar.setProgressTintList (ColorStateList.valueOf (getResources ().getColor (R.color.poor_rate)));
        }
    }
}