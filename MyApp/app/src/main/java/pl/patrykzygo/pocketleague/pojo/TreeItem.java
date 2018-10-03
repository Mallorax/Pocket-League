package pl.patrykzygo.pocketleague.pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TreeItem{

	@SerializedName("header")
	private String header;

	@SerializedName("tags")
	private List<String> tags;

	public void setHeader(String header){
		this.header = header;
	}

	public String getHeader(){
		return header;
	}

	public void setTags(List<String> tags){
		this.tags = tags;
	}

	public List<String> getTags(){
		return tags;
	}

	@Override
 	public String toString(){
		return 
			"TreeItem{" + 
			"header = '" + header + '\'' + 
			",tags = '" + tags + '\'' + 
			"}";
		}
}