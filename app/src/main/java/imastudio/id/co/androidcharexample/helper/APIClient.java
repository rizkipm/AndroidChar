package imastudio.id.co.androidcharexample.helper;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rizkisyaputra on 11/12/17.
 */

public class APIClient {

    private static Retrofit getRetrofit(){
        //insialisasi retrofit 2
        Retrofit r = new Retrofit.Builder()
                .baseUrl(VolunterHelper.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return r;
    }
    public static Retrofit setInit2() {

        return new Retrofit.Builder().baseUrl(VolunterHelper.GOOGLEMAP_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
//    public static InterfaceAPI getInstaceRetrofit(){
//        return getRetrofit().create(InterfaceAPI.class);
//    }
//
//    public static InterfaceAPI getInstaceRetrofit2(){
//        return setInit2().create(InterfaceAPI.class);
//    }

}
