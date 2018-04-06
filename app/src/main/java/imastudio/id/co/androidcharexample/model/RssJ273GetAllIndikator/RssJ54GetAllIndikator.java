package imastudio.id.co.androidcharexample.model.RssJ273GetAllIndikator;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RssJ54GetAllIndikator{

	@SerializedName("result")
	private String result;

	@SerializedName("msg")
	private String msg;

	@SerializedName("data")
	private List<DataItemJ54GetAllIndikator> data;

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

	public void setData(List<DataItemJ54GetAllIndikator> data){
		this.data = data;
	}

	public List<DataItemJ54GetAllIndikator> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"RssJ54GetAllIndikator{" + 
			"result = '" + result + '\'' + 
			",msg = '" + msg + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}