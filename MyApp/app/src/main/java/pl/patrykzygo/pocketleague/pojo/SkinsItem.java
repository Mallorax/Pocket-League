package pl.patrykzygo.pocketleague.pojo;

import com.google.gson.annotations.SerializedName;

public class SkinsItem{

	@SerializedName("chromas")
	private boolean chromas;

	@SerializedName("num")
	private int num;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	public void setChromas(boolean chromas){
		this.chromas = chromas;
	}

	public boolean isChromas(){
		return chromas;
	}

	public void setNum(int num){
		this.num = num;
	}

	public int getNum(){
		return num;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"SkinsItem{" + 
			"chromas = '" + chromas + '\'' + 
			",num = '" + num + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}