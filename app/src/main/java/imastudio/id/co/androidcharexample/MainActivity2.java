package imastudio.id.co.androidcharexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import imastudio.id.co.androidcharexample.Activity.MenuTipeIndikatorActivity;
import imastudio.id.co.androidcharexample.model.RssJ273GetAllIndikator.DataItemJ54GetAllIndikator;
import imastudio.id.co.androidcharexample.model.indikatorbyId.DataItemJ554IndikatorByTipe;
import imastudio.id.co.androidcharexample.model.indikatorbyId.RssJ544IndikatorByTipe;
import imastudio.id.co.androidcharexample.network.MyRetrofitClient;
import imastudio.id.co.androidcharexample.network.RestApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {

    public static List<DataItemJ554IndikatorByTipe> dataIndikator;


    DataItemJ54GetAllIndikator dataItemGet;
    String idTipe;
    BarChart chart;
    ArrayList<BarDataSet> dataSets = null;

    int start, end;
    int month, year;
    String nYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         chart = (BarChart) findViewById(R.id.chart);

        dataIndikator = new ArrayList<>();



        int posisi = getIntent().getIntExtra("posisi", 0);
        //get variable array dari request fragment
        dataItemGet =  MenuTipeIndikatorActivity.dataItemJ23RiwayatLelangs.get(posisi);

        idTipe = dataItemGet.getId();
        Toast.makeText(getApplicationContext(), "id " + idTipe, Toast.LENGTH_LONG).show();



        getListData();

    }

    private void getListData() {
        try {
            RestApi api = MyRetrofitClient.getInstanceRetrofit2();


            Call<RssJ544IndikatorByTipe> call = api.getIndikatorByTipe(idTipe);
            call.enqueue(new Callback<RssJ544IndikatorByTipe>() {
                @Override
                public void onResponse(Call<RssJ544IndikatorByTipe> call, Response<RssJ544IndikatorByTipe> response) {
//                    Log.d("onResponse", response.body().toString());

                    String r = response.body().getResult();
//                String nData = response.body().getDataProfilUSer().getLevel();
                    Log.d("adaa22", response.body().toString());

                    if (r.equalsIgnoreCase("true")) {


                        dataIndikator = response.body().getData();
//                      nYear = dataIndikator.get(0).getThIndikator();

//                        BarData data = new BarData(getXAxisValues(), getDataSet());
//                        chart.setData(data);
//                        chart.setDescription(dataIndikator.get(0).getTipeIndikator());
//                        chart.animateXY(3000, 3000);
//                        chart.invalidate();
                        ArrayList<BarEntry> yVals = new ArrayList<BarEntry>();


                        for (int i = 0; i < dataIndikator.size(); i++){
                            DataItemJ554IndikatorByTipe x = dataIndikator.get(i);
                            float a12 = Float.parseFloat(x.getJmlIndikator());
                            int a22 = Integer.parseInt(x.getId());
                            yVals.add(new BarEntry(a12, i));
                        }


                        ArrayList<String> xVals = new ArrayList<String>();
                        for (int i = 0; i < dataIndikator.size(); i++){
                            DataItemJ554IndikatorByTipe x = dataIndikator.get(i);
                            float a12 = Float.parseFloat(x.getJmlIndikator());
                            String a22 = x.getThIndikator();

                            xVals.add(a22);

                        }
//                        for(int i = 0; i < mExpenseDB.queryXData().size(); i++)
//                            xVals.add(mExpenseDB.queryXData().get(i));

                        BarDataSet dataSet = new BarDataSet(yVals, dataIndikator.get(0).getTipeIndikator());
                        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

                        BarData data = new BarData(xVals, dataSet);


                        LimitLine line = new LimitLine(12f, dataIndikator.get(0).getTipeIndikator());
                        line.setTextSize(12f);
                        line.setLineWidth(4f);
                        YAxis leftAxis = chart.getAxisLeft();
                        leftAxis.addLimitLine(line);

                        chart.setData(data);
                        chart.setDescription(dataIndikator.get(0).getTipeIndikator());
                        chart.animateY(2000);



                    }else {

                    }



                }

                @Override
                public void onFailure(Call<RssJ544IndikatorByTipe> call, Throwable t) {

                }
            });

//
        } catch (Exception e) {
        }
    }





}
