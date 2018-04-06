package imastudio.id.co.androidcharexample.model.indikatorbyId;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class RssJ544IndikatorByTipe{

	@SerializedName("result")
	private String result;

	@SerializedName("msg")
	private String msg;

	@SerializedName("data")
	private List<DataItemJ554IndikatorByTipe> data;

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

	public void setData(List<DataItemJ554IndikatorByTipe> data){
		this.data = data;
	}

	public List<DataItemJ554IndikatorByTipe> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"RssJ544IndikatorByTipe{" + 
			"result = '" + result + '\'' + 
			",msg = '" + msg + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}