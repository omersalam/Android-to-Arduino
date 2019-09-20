package cn.devld.hc_05demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;

public class chart extends AppCompatActivity {
    LineChart dailyOilChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        dailyOilChart = (LineChart) findViewById(R.id.dailyOilChart);
        dailyOilChart.setTouchEnabled(true);
        dailyOilChart.setDragEnabled(true);
        dailyOilChart.setScaleEnabled(true);
        //dailyOilChart.animateX(3500);
        LineDataSet lineDataSet = new LineDataSet(dataValues(), "Acceleration");
        LineDataSet lineDataSet2 = new LineDataSet(dataValues1(), "Velocity");
        LineDataSet lineDataSet3 = new LineDataSet(dataValues2(), "Position");
        lineDataSet.setLineWidth(1.95f);
        lineDataSet.setColor(Color.BLUE);
        lineDataSet.setDrawCircles(true);
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setCircleColors(Color.BLACK);
        lineDataSet.setValueFormatter(new OilDataFormatter());
        lineDataSet2.setColor(Color.GREEN);
        lineDataSet2.setLineWidth(1.95f);
        lineDataSet2.setDrawCircles(true);
        lineDataSet2.setDrawCircleHole(true);
        lineDataSet2.setCircleColors(Color.BLACK);

        lineDataSet3.setColor(Color.RED);
        lineDataSet3.setDrawCircles(true);
        lineDataSet3.setLineWidth(1.95f);
        lineDataSet3.setDrawCircleHole(true);
        lineDataSet3.setCircleColors(Color.BLACK);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet);
        dataSets.add(lineDataSet2);
        dataSets.add(lineDataSet3);


        LineData lineData;
        lineData = new LineData(dataSets);
        dailyOilChart.setData(lineData);
        dailyOilChart.invalidate();


        XAxis xAxis = dailyOilChart.getXAxis();
        xAxis.setValueFormatter(new xAxisOilValueFormatter());

    }


    private ArrayList dataValues() {
        ArrayList<Entry> dataValues = new ArrayList<>();
        for(int i=0;i<10;i++){
            dataValues.add(new Entry(i, global.myarray1[i]));

        }
        return dataValues;
    }



    private ArrayList dataValues1() {
        ArrayList<Entry> dataValues = new ArrayList<>();

        dataValues.add(new Entry(0, 45));
        dataValues.add(new Entry(10, -45));
        dataValues.add(new Entry(20, 45));
        dataValues.add(new Entry(30, -45));
        dataValues.add(new Entry(40, 45));
        dataValues.add(new Entry(50, -45));
        dataValues.add(new Entry(60, 45));
        dataValues.add(new Entry(70, -45));
        return dataValues;
    }


    private ArrayList dataValues2() {
        ArrayList<Entry> dataValues = new ArrayList<>();

        dataValues.add(new Entry(0, 90));
        dataValues.add(new Entry(7, -90));
        dataValues.add(new Entry(17, 90));
        dataValues.add(new Entry(27, -90));
        dataValues.add(new Entry(37, 90));
        dataValues.add(new Entry(47, -90));
        dataValues.add(new Entry(57, 90));
        dataValues.add(new Entry(67, -90));
        return dataValues;
    }

    private class OilDataFormatter extends ValueFormatter implements IValueFormatter {


        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            return value + "ml";
        }
    }

    private class xAxisOilValueFormatter extends ValueFormatter implements IAxisValueFormatter {

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return "Day" + value;
        }
    }
}
