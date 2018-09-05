package pl.patrykzygo.pocketleague.pojo;

import com.google.gson.annotations.SerializedName;

public class ItemsResponse {

	@SerializedName("data")
	private ItemData data;

	@SerializedName("type")
	private String type;

	@SerializedName("version")
	private String version;

	public ItemData getItemData() {
		return data;
	}

	public void setItemData(ItemData data) {
		this.data = data;
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
			"ItemsResponse{" +
			"data = '" + data + '\'' + 
			",type = '" + type + '\'' + 
			",version = '" + version + '\'' + 
			"}";
		}
}