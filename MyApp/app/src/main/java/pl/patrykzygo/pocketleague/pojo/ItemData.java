package pl.patrykzygo.pocketleague.pojo;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;


public class ItemData{

	@SerializedName("itemMap")
	private Map<String, Item> itemMap;

	@SerializedName("tree")
	private List<TreeItem> tree;

	public Map<String, Item> getItemMap() {
		return itemMap;
	}

	public void setItemMap(Map<String, Item> itemMap) {
		this.itemMap = itemMap;
	}

	public void setTree(List<TreeItem> tree){
		this.tree = tree;
	}

	public List<TreeItem> getTree(){
		return tree;
	}

	@Override
	public String toString() {
		return "ItemData{" +
				"itemMap=" + itemMap +
				", tree=" + tree +
				'}';
	}
}