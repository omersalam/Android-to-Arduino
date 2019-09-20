package cn.devld.hc_05demo;

import com.github.mikephil.charting.components.AxisBase;

interface IAxisValueFormatter {



    /**
     * Called when a value from an axis is to be formatted
     * before being drawn. For performance reasons, avoid excessive calculations
     * and memory allocations inside this method.
     *
     * @param value the value to be formatted
     * @param axis  the axis the value belongs to
     * @return
     */
    String getFormattedValue(float value, AxisBase axis);
}

