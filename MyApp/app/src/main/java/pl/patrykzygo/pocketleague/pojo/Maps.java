package pl.patrykzygo.pocketleague.pojo;

import com.google.gson.annotations.SerializedName;

public class Maps{

	@SerializedName("11")
	private boolean jsonMember11;

	@SerializedName("1")
	private boolean jsonMember1;

	@SerializedName("12")
	private boolean jsonMember12;

	@SerializedName("14")
	private boolean jsonMember14;

	@SerializedName("8")
	private boolean jsonMember8;

	@SerializedName("10")
	private boolean jsonMember10;

	public void setJsonMember11(boolean jsonMember11){
		this.jsonMember11 = jsonMember11;
	}

	public boolean isJsonMember11(){
		return jsonMember11;
	}

	public void setJsonMember1(boolean jsonMember1){
		this.jsonMember1 = jsonMember1;
	}

	public boolean isJsonMember1(){
		return jsonMember1;
	}

	public void setJsonMember12(boolean jsonMember12){
		this.jsonMember12 = jsonMember12;
	}

	public boolean isJsonMember12(){
		return jsonMember12;
	}

	public void setJsonMember14(boolean jsonMember14){
		this.jsonMember14 = jsonMember14;
	}

	public boolean isJsonMember14(){
		return jsonMember14;
	}

	public void setJsonMember8(boolean jsonMember8){
		this.jsonMember8 = jsonMember8;
	}

	public boolean isJsonMember8(){
		return jsonMember8;
	}

	public void setJsonMember10(boolean jsonMember10){
		this.jsonMember10 = jsonMember10;
	}

	public boolean isJsonMember10(){
		return jsonMember10;
	}

	@Override
 	public String toString(){
		return 
			"Maps{" + 
			"11 = '" + jsonMember11 + '\'' + 
			",1 = '" + jsonMember1 + '\'' + 
			",12 = '" + jsonMember12 + '\'' + 
			",14 = '" + jsonMember14 + '\'' + 
			",8 = '" + jsonMember8 + '\'' + 
			",10 = '" + jsonMember10 + '\'' + 
			"}";
		}
}