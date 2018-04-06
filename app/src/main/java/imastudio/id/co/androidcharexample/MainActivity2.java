package imastudio.id.co.androidcharexample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import imastudio.id.co.androidcharexample.Activity.MenuTipeIndikatorActivity;
import imastudio.id.co.androidcharexample.adapter.AdapterTipeIndikator;
import imastudio.id.co.androidcharexample.model.RssJ273GetAllIndikator.DataItemJ54GetAllIndikator;
import imastudio.id.co.androidcharexample.model.RssJ273GetAllIndikator.RssJ54GetAllIndikator;
import imastudio.id.co.androidcharexample.model.indikatorbyId.DataItemJ54ByIndikatorType;
import imastudio.id.co.androidcharexample.model.indikatorbyId.RssJ54GetIndikatorByTipe;
import imastudio.id.co.androidcharexample.network.MyRetrofitClient;
import imastudio.id.co.androidcharexample.network.RestApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {

    public static List<DataItemJ54ByIndikatorType> dataIndikator;
    public static List<DataItemJ54GetAllIndikator> dataItemJ23RiwayatLelangs;

    ArrayList<BarEntry> valueSet1;
    DataItemJ54GetAllIndikator dataItemGet;
    String idTipe;
    BarChart chart;
    Entries models;
    int start, end;
    int month, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         chart = (BarChart) findViewById(R.id.chart);
        models = new Entries();
        valueSet1 = new ArrayList<>();
        dataIndikator = new ArrayList<>();



        int posisi = getIntent().getIntExtra("posisi", 0);
        //get variable array dari request fragment
        dataItemGet =  MenuTipeIndikatorActivity.dataItemJ23RiwayatLelangs.get(posisi);

        idTipe = dataItemGet.getId();
        Toast.makeText(getApplicationContext(), "id " + idTipe, Toast.LENGTH_LONG).show();

        getIndikatorByTipe();

        getListData();

    }

    private void getListData() {
        try {
            RestApi api = MyRetrofitClient.getInstanceRetrofit2();


            Call<RssJ54GetIndikatorByTipe> call = api.getIndikatorByTipe(idTipe);
            call.enqueue(new Callback<RssJ54GetIndikatorByTipe>() {
                @Override
                public void onResponse(Call<RssJ54GetIndikatorByTipe> call, Response<RssJ54GetIndikatorByTipe> response) {
//                    Log.d("onResponse", response.body().toString());

                    String r = response.body().getResult();
//                String nData = response.body().getDataProfilUSer().getLevel();
                    Log.d("adaa22", response.body().toString());

                    if (r.equalsIgnoreCase("true")) {


//                        dataItemJ23RiwayatLelangs = response.body().getData();
////                    layoutManager = new LinearLayoutManager(getApplicationContext());
//                        AdapterTipeIndikator recyclerViewAdapter =
//                                new AdapterTipeIndikator(dataItemJ23RiwayatLelangs, MenuTipeIndikatorActivity.this);
//                        recyclerView.setLayoutManager(new LinearLayoutManager(MenuTipeIndikatorActivity.this));
//
////                    recyclerView.setLayoutManager(layoutManager);
//////                        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
//
//                        recyclerView.setAdapter(recyclerViewAdapter);

                    }else {

                    }



                }

                @Override
                public void onFailure(Call<RssJ54GetIndikatorByTipe> call, Throwable t) {

                }
            });

//
        } catch (Exception e) {
        }
    }

    private void  getIndikatorByTipe() {
        try {
            RestApi api = MyRetrofitClient.getInstanceRetrofit();


            Call<RssJ54GetIndikatorByTipe> call = api.getIndikatorByTipe(idTipe);
            call.enqueue(new Callback<RssJ54GetIndikatorByTipe>() {
                @Override
                public void onResponse(Call<RssJ54GetIndikatorByTipe> call, Response<RssJ54GetIndikatorByTipe> response) {

                    String r = response.body().getResult();
//                String nData = response.body().getDataProfilUSer().getLevel();
                    Log.d("adaa11", response.body().toString());

                    if (r.equalsIgnoreCase("true")) {


                        dataIndikator = response.body().getData();

                        BarData data = new BarData(getXAxisValues(), getDataSet());
                        chart.setData(data);
                        chart.setDescription("Grafik Potensi Wilayah ");
                        chart.animateXY(20000, 20000);
                        chart.invalidate();


                        for (int i = 0;  dataIndikator.size() > 0; i++) {
                            ArrayList<BarDataSet> dataSets = null;

                            ArrayList<BarEntry> valueSet1 = new ArrayList<>();
                            BarEntry v1e1 = new BarEntry(10, 1); // Jan
                            valueSet1.add(v1e1);

                            BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Potensi Wilayah");
                            barDataSet1.setColors(ColorTemplate.COLORFUL_COLORS);

                            dataSets = new ArrayList<>();
                            dataSets.add(barDataSet1);


                        }

                        for (int i = 0; i < dataIndikator.size(); i++) {
                            ArrayList<String> xAxis = new ArrayList<>();
//                            xAxis.add(dataItem.getThIndikator());
                            xAxis.add("thn");
                        }


                    }else {

                    }



                }

                @Override
                public void onFailure(Call<RssJ54GetIndikatorByTipe> call, Throwable t) {

                }
            });

//
        }catch (Exception e) {}
    }

    private ArrayList<BarDataSet> getDataSet() {
        ArrayList<BarDataSet> dataSets = null;

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry v1e1 = new BarEntry(37500.000f, 0); // Jan
        valueSet1.add(v1e1);
        BarEntry v1e2 = new BarEntry(8500.000f, 1); // Feb
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(53040.000f, 2); // Mar
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(16412.000f, 3); // Apr
        valueSet1.add(v1e4);
        BarEntry v1e5 = new BarEntry(635.000f, 4); // May
        valueSet1.add(v1e5);
        BarEntry v1e6 = new BarEntry(44062.000f, 5); // Jun
        valueSet1.add(v1e6);

        ArrayList<BarEntry> valueSet2 = new ArrayList<>();
        BarEntry v2e1 = new BarEntry(3010.000f, 0); // Jan
        valueSet2.add(v2e1);
        BarEntry v2e2 = new BarEntry(19208.000f, 1); // Feb
        valueSet2.add(v2e2);
        BarEntry v2e3 = new BarEntry(2546.000f, 2); // Mar
        valueSet2.add(v2e3);
        BarEntry v2e4 = new BarEntry(29754.000f, 3); // Apr
        valueSet2.add(v2e4);
        BarEntry v2e5 = new BarEntry(2293.000f, 4); // May
        valueSet2.add(v2e5);
        BarEntry v2e6 = new BarEntry(11189.000f, 5); // Jun
        valueSet2.add(v2e6);

        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Potensi Wilayah");
        barDataSet1.setColor(Color.rgb(0, 155, 0));
        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Produksi");
        barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);

        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);
        return dataSets;
    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("PT");
        xAxis.add("PB");
        xAxis.add("PS");
        xAxis.add("SDM");
        xAxis.add("KP");
        xAxis.add("PTN");
        return xAxis;
    }

    class Entries{
        List<BarEntry> entriesIncome = new ArrayList<>();
        List<BarEntry> entriesPayment = new ArrayList<>();

        public List<BarEntry> getEntriesIncome() {
            return entriesIncome;
        }

        public List<BarEntry> getEntriesPayment() {
            return entriesPayment;
        }

        public void setEntriesIncome(List<BarEntry> entriesIncome) {
            this.entriesIncome = entriesIncome;
        }

        public void setEntriesPayment(List<BarEntry> entriesPayment) {
            this.entriesPayment = entriesPayment;
        }
    }

    class Data{
        float sum;
        int date;

        public void setDate(int date) {
            this.date = date;
        }

        public void setSum(float sum) {
            this.sum = sum;
        }

        public float getSum() {
            return sum;
        }

        public int getDate() {
            return date;
        }
    }
}
