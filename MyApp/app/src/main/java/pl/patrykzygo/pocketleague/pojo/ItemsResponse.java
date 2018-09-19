package pl.patrykzygo.pocketleague.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class ItemsResponse {

	@SerializedName("tree")
	private List<TreeItem> tree;

	@SerializedName("data")
	private Map<String, Item> data;

	@SerializedName("type")
	private String type;


	public List<TreeItem> getTree() {
		return tree;
	}

	public void setTree(List<TreeItem> tree) {
		this.tree = tree;
	}

	public Map<String, Item> getItemDataMap() {
		return data;
	}

	public void setItemDataMap(Map<String, Item> data) {
		this.data = data;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

}