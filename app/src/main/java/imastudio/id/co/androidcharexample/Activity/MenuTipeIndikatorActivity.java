package imastudio.id.co.androidcharexample.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import imastudio.id.co.androidcharexample.R;
import imastudio.id.co.androidcharexample.adapter.AdapterTipeIndikator;
import imastudio.id.co.androidcharexample.model.RssJ273GetAllIndikator.DataItemJ54GetAllIndikator;
import imastudio.id.co.androidcharexample.model.RssJ273GetAllIndikator.RssJ54GetAllIndikator;
import imastudio.id.co.androidcharexample.network.MyRetrofitClient;
import imastudio.id.co.androidcharexample.network.RestApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuTipeIndikatorActivity extends AppCompatActivity {
    public static List<DataItemJ54GetAllIndikator> dataItemJ23RiwayatLelangs;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_wisata);
        ButterKnife.bind(this);
        dataItemJ23RiwayatLelangs = new ArrayList<>();



            getListData();

    }

    private void getListData() {
        try {
            RestApi api = MyRetrofitClient.getInstanceRetrofit2();


            Call<RssJ54GetAllIndikator> call = api.getAllTipeIndikator();
            call.enqueue(new Callback<RssJ54GetAllIndikator>() {
                @Override
                public void onResponse(Call<RssJ54GetAllIndikator> call, Response<RssJ54GetAllIndikator> response) {
//                    Log.d("onResponse", response.body().toString());

                    String r = response.body().getResult();
//                String nData = response.body().getDataProfilUSer().getLevel();
                    Log.d("adaa", response.body().toString());

                    if (r.equalsIgnoreCase("true")) {


                        dataItemJ23RiwayatLelangs = response.body().getData();
//                    layoutManager = new LinearLayoutManager(getApplicationContext());
                        AdapterTipeIndikator recyclerViewAdapter =
                                new AdapterTipeIndikator(dataItemJ23RiwayatLelangs, MenuTipeIndikatorActivity.this);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MenuTipeIndikatorActivity.this));

//                    recyclerView.setLayoutManager(layoutManager);
////                        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

                        recyclerView.setAdapter(recyclerViewAdapter);

                    }else {

                    }



                }

                @Override
                public void onFailure(Call<RssJ54GetAllIndikator> call, Throwable t) {

                }
            });

//
        } catch (Exception e) {
        }
    }

}
