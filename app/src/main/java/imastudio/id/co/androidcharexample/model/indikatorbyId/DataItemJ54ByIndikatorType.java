package imastudio.id.co.androidcharexample.model.indikatorbyId;


import com.google.gson.annotations.SerializedName;

public class DataItemJ54ByIndikatorType {

	@SerializedName("jml_indikator")
	private String jmlIndikator;

	@SerializedName("id_tipe_indikator")
	private String idTipeIndikator;

	@SerializedName("tipe_indikator")
	private String tipeIndikator;

	@SerializedName("th_indikator")
	private String thIndikator;

	@SerializedName("id_indikator")
	private String idIndikator;

	@SerializedName("id")
	private String id;

	public void setJmlIndikator(String jmlIndikator){
		this.jmlIndikator = jmlIndikator;
	}

	public String getJmlIndikator(){
		return jmlIndikator;
	}

	public void setIdTipeIndikator(String idTipeIndikator){
		this.idTipeIndikator = idTipeIndikator;
	}

	public String getIdTipeIndikator(){
		return idTipeIndikator;
	}

	public void setTipeIndikator(String tipeIndikator){
		this.tipeIndikator = tipeIndikator;
	}

	public String getTipeIndikator(){
		return tipeIndikator;
	}

	public void setThIndikator(String thIndikator){
		this.thIndikator = thIndikator;
	}

	public String getThIndikator(){
		return thIndikator;
	}

	public void setIdIndikator(String idIndikator){
		this.idIndikator = idIndikator;
	}

	public String getIdIndikator(){
		return idIndikator;
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
			"DataItemJ54ByIndikatorType{" +
			"jml_indikator = '" + jmlIndikator + '\'' + 
			",id_tipe_indikator = '" + idTipeIndikator + '\'' + 
			",tipe_indikator = '" + tipeIndikator + '\'' + 
			",th_indikator = '" + thIndikator + '\'' + 
			",id_indikator = '" + idIndikator + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}