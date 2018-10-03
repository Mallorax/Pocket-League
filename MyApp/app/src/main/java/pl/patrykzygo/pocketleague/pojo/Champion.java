package pl.patrykzygo.pocketleague.pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Champion{

	@SerializedName("image")
	private Image image;

	@SerializedName("lore")
	private String lore;

	@SerializedName("partype")
	private String partype;

	@SerializedName("title")
	private String title;

	@SerializedName("blurb")
	private String blurb;

	@SerializedName("allytips")
	private List<String> allytips;

	@SerializedName("passive")
	private Passive passive;

	@SerializedName("tags")
	private List<String> tags;

	@SerializedName("skins")
	private List<SkinsItem> skins;

	@SerializedName("stats")
	private Stats stats;

	@SerializedName("enemytips")
	private List<String> enemytips;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("spells")
	private List<SpellsItem> spells;

	@SerializedName("key")
	private String key;

	@SerializedName("info")
	private Info info;

	@SerializedName("alltips")
	private String allTips;

	public String getAllTips() {
		return allTips;
	}

	public void setAllTips(String allTips) {
		this.allTips = allTips;
	}

	public void setImage(Image image){
		this.image = image;
	}

	public Image getImage(){
		return image;
	}

	public void setLore(String lore){
		this.lore = lore;
	}

	public String getLore(){
		return lore;
	}

	public void setPartype(String partype){
		this.partype = partype;
	}

	public String getPartype(){
		return partype;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setBlurb(String blurb){
		this.blurb = blurb;
	}

	public String getBlurb(){
		return blurb;
	}

	public void setAllytips(List<String> allytips){
		this.allytips = allytips;
	}

	public List<String> getAllytips(){
		return allytips;
	}

	public void setPassive(Passive passive){
		this.passive = passive;
	}

	public Passive getPassive(){
		return passive;
	}

	public void setTags(List<String> tags){
		this.tags = tags;
	}

	public List<String> getTags(){
		return tags;
	}

	public void setSkins(List<SkinsItem> skins){
		this.skins = skins;
	}

	public List<SkinsItem> getSkins(){
		return skins;
	}

	public void setStats(Stats stats){
		this.stats = stats;
	}

	public Stats getStats(){
		return stats;
	}

	public void setEnemytips(List<String> enemytips){
		this.enemytips = enemytips;
	}

	public List<String> getEnemytips(){
		return enemytips;
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

	public void setSpells(List<SpellsItem> spells){
		this.spells = spells;
	}

	public List<SpellsItem> getSpells(){
		return spells;
	}

	public void setKey(String key){
		this.key = key;
	}

	public String getKey(){
		return key;
	}

	public void setInfo(Info info){
		this.info = info;
	}

	public Info getInfo(){
		return info;
	}

	@Override
 	public String toString(){
		return 
			"Champion{" + 
			"image = '" + image + '\'' + 
			",lore = '" + lore + '\'' + 
			",partype = '" + partype + '\'' + 
			",title = '" + title + '\'' + 
			",blurb = '" + blurb + '\'' + 
			",allytips = '" + allytips + '\'' + 
			",passive = '" + passive + '\'' + 
			",tags = '" + tags + '\'' + 
			",skins = '" + skins + '\'' + 
			",stats = '" + stats + '\'' + 
			",enemytips = '" + enemytips + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",spells = '" + spells + '\'' + 
			",key = '" + key + '\'' + 
			",info = '" + info + '\'' + 
			"}";
		}
}