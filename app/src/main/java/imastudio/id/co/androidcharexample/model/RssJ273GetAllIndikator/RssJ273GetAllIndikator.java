package imastudio.id.co.androidcharexample.model.RssJ273GetAllIndikator;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class RssJ273GetAllIndikator{

	@SerializedName("result")
	private String result;

	@SerializedName("msg")
	private String msg;

	@SerializedName("data")
	private List<DataItemJ273TipeIndikator> data;

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

	public void setData(List<DataItemJ273TipeIndikator> data){
		this.data = data;
	}

	public List<DataItemJ273TipeIndikator> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"RssJ273GetAllIndikator{" + 
			"result = '" + result + '\'' + 
			",msg = '" + msg + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}