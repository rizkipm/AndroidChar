package imastudio.id.co.androidcharexample.network;


import imastudio.id.co.androidcharexample.model.RssJ273GetAllIndikator.RssJ273GetAllIndikator;
import imastudio.id.co.androidcharexample.model.indikatorbyId.RssJ54IndikatorByiD;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Blackswan on 9/12/2017.
 */

public interface RestApi {


//
//    @GET("menu/json")
//    Call<RssJ113Menu> getMenuHome();
//
//    @GET("wisata/json")
//    Call<RssJ113Wisata> getMenuWisata();

    @GET("getAllTipeIndikator")
    Call<RssJ273GetAllIndikator> getAllTipeIndikator();


    @FormUrlEncoded
    @POST("getIndikatorByTipe")
    Call<RssJ54IndikatorByiD> getIndikatorByTipe(
            @Field("id_tipe_indikator") String id_tipe_indikator

    );

//    @FormUrlEncoded
//    @POST("penawaranBarang")
//    Call<NewRssJ112Penawaran> penawaranBarang(
//            @Field("id_produk") String id_produk,
//            @Field("id_user") String id_user,
//
//            @Field("id_toko") String id_toko,
//            @Field("jml_pesanan") String jml_pesanan,
//            @Field("satuan_qty") String satuan_qty,
//            @Field("hrg_penawaran") String hrg_penawaran,
//            @Field("alamat_penawaran") String alamat_penawaran,
//            @Field("gmbr_penawaran") String gmbr_penawaran,
//            @Field("userfile") File userfile
//    );



}
