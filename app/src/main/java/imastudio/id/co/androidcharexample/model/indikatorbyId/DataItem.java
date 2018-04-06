package imastudio.id.co.androidcharexample.model.indikatorbyId;


import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("jml_indikator")
	private String jmlIndikator;

	@SerializedName("id_tipe_indikator")
	private String idTipeIndikator;

	@SerializedName("th_indikator")
	private String thIndikator;

	@SerializedName("id_indikator")
	private String idIndikator;

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

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"jml_indikator = '" + jmlIndikator + '\'' + 
			",id_tipe_indikator = '" + idTipeIndikator + '\'' + 
			",th_indikator = '" + thIndikator + '\'' + 
			",id_indikator = '" + idIndikator + '\'' + 
			"}";
		}
}