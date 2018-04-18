package imastudio.id.co.androidcharexample;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BarChart chart = (BarChart) findViewById(R.id.chart);

        BarData data = new BarData(getXAxisValues(), (IBarDataSet) getDataSet());
        chart.setData(data);
        chart.setDescription("Angka Harapan Hidup");
        chart.animateXY(150, 150);
        chart.invalidate();
    }

    private ArrayList<BarDataSet> getDataSet() {
        ArrayList<BarDataSet> dataSets = null;

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry v1e1 = new BarEntry(69.80f, 0); // Jan
        valueSet1.add(v1e1);
        BarEntry v1e2 = new BarEntry(69.61f, 1); // Feb
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(69.69f, 2); // Mar
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(69.76f, 3); // Apr
        valueSet1.add(v1e4);
        BarEntry v1e5 = new BarEntry(69.80f, 4); // May
        valueSet1.add(v1e5);
        BarEntry v1e6 = new BarEntry(69.90f, 5); // Jun
        valueSet1.add(v1e6);
        BarEntry v1e7 = new BarEntry(69.97f, 6); // Jun
        valueSet1.add(v1e7);


        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Angka Harapan Hidup");
//        barDataSet1.setColor(Color.rgb(0, 155, 0));
//        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Produksi");
        barDataSet1.setColors(ColorTemplate.COLORFUL_COLORS);

        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
//        dataSets.add(barDataSet2);
        return dataSets;
    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("2010");
        xAxis.add("2011");
        xAxis.add("2012");
        xAxis.add("2013");
        xAxis.add("2014");
        xAxis.add("2015");
        xAxis.add("2016");
        return xAxis;
    }
}
