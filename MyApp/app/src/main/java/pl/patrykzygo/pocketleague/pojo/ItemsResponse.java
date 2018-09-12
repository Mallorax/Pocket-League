package pl.patrykzygo.pocketleague.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class ItemsResponse {

	@SerializedName("tree")
	private List<TreeItem> tree;

	@SerializedName("itemMap")
	private Map<String, Item> itemMap;

	@SerializedName("type")
	private String type;

	@SerializedName("version")
	private String version;

	public List<TreeItem> getTree() {
		return tree;
	}

	public void setTree(List<TreeItem> tree) {
		this.tree = tree;
	}

	public Map<String, Item> getItemMap() {
		return itemMap;
	}

	public void setItemMap(Map<String, Item> itemMap) {
		this.itemMap = itemMap;
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