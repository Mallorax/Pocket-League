package pl.patrykzygo.pocketleague.pojo;

import com.google.gson.annotations.SerializedName;

public class Passive{

	@SerializedName("image")
	private Image image;

	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private String description;

	public void setImage(Image image){
		this.image = image;
	}

	public Image getImage(){
		return image;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	@Override
 	public String toString(){
		return 
			"Passive{" + 
			"image = '" + image + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			"}";
		}
}