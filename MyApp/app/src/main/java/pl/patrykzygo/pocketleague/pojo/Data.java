package pl.patrykzygo.pocketleague.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Data{

	@SerializedName("championMap")
	Map<String, Champion> championsMap;

	public Map<String, Champion> getChampionsMap() {
		return championsMap;
	}

	public void setChampionsMap(Map<String, Champion> championsMap) {
		this.championsMap = championsMap;
	}

	@Override
	public String toString() {
		return "Data{" +
				"championsMap=" + championsMap +
				'}';
	}
}