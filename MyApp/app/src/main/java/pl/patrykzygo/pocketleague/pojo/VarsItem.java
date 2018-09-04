package pl.patrykzygo.pocketleague.pojo;

import com.google.gson.annotations.SerializedName;

public class VarsItem{

	@SerializedName("link")
	private String link;

	@SerializedName("coeff")
	private double coeff;

	@SerializedName("key")
	private String key;

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

	public void setCoeff(double coeff){
		this.coeff = coeff;
	}

	public double getCoeff(){
		return coeff;
	}

	public void setKey(String key){
		this.key = key;
	}

	public String getKey(){
		return key;
	}

	@Override
 	public String toString(){
		return 
			"VarsItem{" + 
			"link = '" + link + '\'' + 
			",coeff = '" + coeff + '\'' + 
			",key = '" + key + '\'' + 
			"}";
		}
}