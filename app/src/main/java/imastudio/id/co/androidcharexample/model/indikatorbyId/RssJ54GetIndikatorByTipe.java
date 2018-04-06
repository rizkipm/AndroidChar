package imastudio.id.co.androidcharexample.model.indikatorbyId;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class RssJ54GetIndikatorByTipe{

	@SerializedName("result")
	private String result;

	@SerializedName("msg")
	private String msg;

	@SerializedName("data")
	private List<DataItemJ54ByIndikatorType> data;

	public void setResult(String result){
		this.result = result;
	}

	public String getResult(){
		return result;
	}

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setData(List<DataItemJ54ByIndikatorType> data){
		this.data = data;
	}

	public List<DataItemJ54ByIndikatorType> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"RssJ54GetIndikatorByTipe{" + 
			"result = '" + result + '\'' + 
			",msg = '" + msg + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}