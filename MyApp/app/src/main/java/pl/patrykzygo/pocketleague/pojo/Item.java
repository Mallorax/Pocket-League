package pl.patrykzygo.pocketleague.pojo;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Item{

	@SerializedName("colloq")
	private String colloq;

	@SerializedName("gold")
	private Gold gold;

	@SerializedName("into")
	private List<String> into;

	@SerializedName("image")
	private Image image;

	@SerializedName("maps")
	private Maps maps;

	@SerializedName("itemStats")
	private ItemStats itemStats;

	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private String description;

	@SerializedName("plaintext")
	private String plaintext;

	@SerializedName("tags")
	private List<String> tags;

	public void setColloq(String colloq){
		this.colloq = colloq;
	}

	public String getColloq(){
		return colloq;
	}

	public void setGold(Gold gold){
		this.gold = gold;
	}

	public Gold getGold(){
		return gold;
	}

	public void setInto(List<String> into){
		this.into = into;
	}

	public List<String> getInto(){
		return into;
	}

	public void setImage(Image image){
		this.image = image;
	}

	public Image getImage(){
		return image;
	}

	public void setMaps(Maps maps){
		this.maps = maps;
	}

	public Maps getMaps(){
		return maps;
	}

	public void setItemStats(ItemStats itemStats){
		this.itemStats = itemStats;
	}

	public ItemStats getItemStats(){
		return itemStats;
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

	public void setPlaintext(String plaintext){
		this.plaintext = plaintext;
	}

	public String getPlaintext(){
		return plaintext;
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
			"JsonMember1001{" + 
			"colloq = '" + colloq + '\'' + 
			",gold = '" + gold + '\'' + 
			",into = '" + into + '\'' + 
			",image = '" + image + '\'' + 
			",maps = '" + maps + '\'' + 
			",itemStats = '" + itemStats + '\'' +
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",plaintext = '" + plaintext + '\'' + 
			",tags = '" + tags + '\'' + 
			"}";
		}
}