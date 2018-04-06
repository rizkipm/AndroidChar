package imastudio.id.co.androidcharexample.model.RssJ273GetAllIndikator;


import com.google.gson.annotations.SerializedName;


public class DataItemJ273TipeIndikator {

	@SerializedName("tipe_indikator")
	private String tipeIndikator;

	@SerializedName("id_indikator")
	private String idIndikator;

	public void setTipeIndikator(String tipeIndikator){
		this.tipeIndikator = tipeIndikator;
	}

	public String getTipeIndikator(){
		return tipeIndikator;
	}

	public void setIdIndikator(String idIndikator){
		this.idIndikator = idIndikator;
	}

	public String getIdIndikator(){
		return idIndikator;
	}

	@Override
 	public String toString(){
		return 
			"DataItemJ273TipeIndikator{" +
			"tipe_indikator = '" + tipeIndikator + '\'' + 
			",id_indikator = '" + idIndikator + '\'' + 
			"}";
		}
}