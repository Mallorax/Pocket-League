package pl.patrykzygo.pocketleague.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class ChampionsResponse {

	@SerializedName("data")
	private Map<String, Champion> data;

	@SerializedName("format")
	private String format;

	@SerializedName("type")
	private String type;

	@SerializedName("version")
	private String version;

	public Map<String, Champion> getData() {
		return data;
	}

	public void setData(Map<String, Champion> data) {
		this.data = data;
	}

	public void setFormat(String format){
		this.format = format;
	}

	public String getFormat(){
		return format;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setVersion(String version){
		this.version = version;
	}

	public String getVersion(){
		return version;
	}


}