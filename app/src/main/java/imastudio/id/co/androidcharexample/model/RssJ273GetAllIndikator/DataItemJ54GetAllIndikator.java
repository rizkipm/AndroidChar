package imastudio.id.co.androidcharexample.model.RssJ273GetAllIndikator;


import com.google.gson.annotations.SerializedName;


public class DataItemJ54GetAllIndikator {

	@SerializedName("tipe_indikator")
	private String tipeIndikator;

	@SerializedName("id")
	private String id;

	public void setTipeIndikator(String tipeIndikator){
		this.tipeIndikator = tipeIndikator;
	}

	public String getTipeIndikator(){
		return tipeIndikator;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"DataItemJ54GetAllIndikator{" +
			"tipe_indikator = '" + tipeIndikator + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}