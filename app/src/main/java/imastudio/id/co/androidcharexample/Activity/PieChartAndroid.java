//package imastudio.id.co.androidcharexample.Activity;
//
//import android.graphics.Color;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//
//import com.github.mikephil.charting.charts.PieChart;
//import com.github.mikephil.charting.data.Entry;
//import com.github.mikephil.charting.data.PieData;
//import com.github.mikephil.charting.data.PieDataSet;
//import com.github.mikephil.charting.formatter.PercentFormatter;
//import com.github.mikephil.charting.highlight.Highlight;
//import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
//import com.github.mikephil.charting.utils.ColorTemplate;
//
//import java.util.ArrayList;
//
//import imastudio.id.co.androidcharexample.R;
//
//public class PieChartAndroid extends AppCompatActivity   implements OnChartValueSelectedListener {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_pie_chart_android);
//
//        PieChart pieChart = (PieChart) findViewById(R.id.piechart);
//        pieChart.setUsePercentValues(true);
//
//        // IMPORTANT: In a PieChart, no values (Entry) should have the same
//        // xIndex (even if from different DataSets), since no values can be
//        // drawn above each other.
//        ArrayList<Entry> yvalues = new ArrayList<Entry>();
//        yvalues.add(new Entry(8f, 0));
//        yvalues.add(new Entry(15f, 1));
//        yvalues.add(new Entry(12f, 2));
//        yvalues.add(new Entry(25f, 3));
//        yvalues.add(new Entry(23f, 4));
//        yvalues.add(new Entry(17f, 5));
//
//        PieDataSet dataSet = new PieDataSet(yvalues, "Election Results");
//
//        ArrayList<String> xVals = new ArrayList<String>();
//
//        xVals.add("January");
//        xVals.add("February");
//        xVals.add("March");
//        xVals.add("April");
//        xVals.add("May");
//        xVals.add("June");
//
//        PieData data = new PieData(xVals, dataSet);
//        // In Percentage
//        data.setValueFormatter(new PercentFormatter());
//        // Default value
//        //data.setValueFormatter(new DefaultValueFormatter(0));
//        pieChart.setData(data);
//        pieChart.setDescription("This is Pie Chart");
//        pieChart.setDrawHoleEnabled(true);
//        pieChart.setTransparentCircleRadius(58f);
//
//        pieChart.setHoleRadius(58f);
//        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
//
//        data.setValueTextSize(13f);
//        data.setValueTextColor(Color.DKGRAY);
//
//        pieChart.setOnChartValueSelectedListener(this);
//
//        pieChart.animateXY(1400, 1400);
//
//    }
//
//    @Override
//    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
//
//        if (e == null)
//            return;
//        Log.i("VAL SELECTED",
//                "Value: " + e.getVal() + ", xIndex: " + e.getXIndex()
//                        + ", DataSet index: " + dataSetIndex);
//    }
//
//    @Override
//    public void onNothingSelected() {
//        Log.i("PieChart", "nothing selected");
//    }
//
//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//
//    }
//}
