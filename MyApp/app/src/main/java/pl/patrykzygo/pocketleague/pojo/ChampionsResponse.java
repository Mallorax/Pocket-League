package pl.patrykzygo.pocketleague.pojo;

import com.google.gson.annotations.SerializedName;

public class ChampionsResponse {

	@SerializedName("data")
	private ChampionData data;

	@SerializedName("format")
	private String format;

	@SerializedName("type")
	private String type;

	@SerializedName("version")
	private String version;

	public void setChampionData(ChampionData championData){
		this.data = championData;
	}

	public ChampionData getChampionData(){
		return data;
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

	@Override
 	public String toString(){
		return 
			"ChampionsResponse{" +
			"data = '" + data + '\'' + 
			",format = '" + format + '\'' + 
			",type = '" + type + '\'' + 
			",version = '" + version + '\'' + 
			"}";
		}
}