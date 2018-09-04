package pl.patrykzygo.pocketleague.pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SpellsItem{

	@SerializedName("cooldownBurn")
	private String cooldownBurn;

	@SerializedName("image")
	private Image image;

	@SerializedName("cost")
	private List<Integer> cost;

	@SerializedName("maxammo")
	private String maxammo;

	@SerializedName("leveltip")
	private Leveltip leveltip;

	@SerializedName("resource")
	private String resource;

	@SerializedName("rangeBurn")
	private String rangeBurn;

	@SerializedName("tooltip")
	private String tooltip;

	@SerializedName("description")
	private String description;

	@SerializedName("range")
	private List<Integer> range;

	@SerializedName("maxrank")
	private int maxrank;

	@SerializedName("effect")
	private List<Object> effect;

	@SerializedName("costType")
	private String costType;

	@SerializedName("name")
	private String name;

	@SerializedName("cooldown")
	private List<Integer> cooldown;

	@SerializedName("id")
	private String id;

	@SerializedName("costBurn")
	private String costBurn;

	@SerializedName("vars")
	private List<VarsItem> vars;

	@SerializedName("effectBurn")
	private List<Object> effectBurn;

	public void setCooldownBurn(String cooldownBurn){
		this.cooldownBurn = cooldownBurn;
	}

	public String getCooldownBurn(){
		return cooldownBurn;
	}

	public void setImage(Image image){
		this.image = image;
	}

	public Image getImage(){
		return image;
	}

	public void setCost(List<Integer> cost){
		this.cost = cost;
	}

	public List<Integer> getCost(){
		return cost;
	}

	public void setMaxammo(String maxammo){
		this.maxammo = maxammo;
	}

	public String getMaxammo(){
		return maxammo;
	}

	public void setLeveltip(Leveltip leveltip){
		this.leveltip = leveltip;
	}

	public Leveltip getLeveltip(){
		return leveltip;
	}

	public void setResource(String resource){
		this.resource = resource;
	}

	public String getResource(){
		return resource;
	}

	public void setRangeBurn(String rangeBurn){
		this.rangeBurn = rangeBurn;
	}

	public String getRangeBurn(){
		return rangeBurn;
	}

	public void setTooltip(String tooltip){
		this.tooltip = tooltip;
	}

	public String getTooltip(){
		return tooltip;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setRange(List<Integer> range){
		this.range = range;
	}

	public List<Integer> getRange(){
		return range;
	}

	public void setMaxrank(int maxrank){
		this.maxrank = maxrank;
	}

	public int getMaxrank(){
		return maxrank;
	}

	public void setEffect(List<Object> effect){
		this.effect = effect;
	}

	public List<Object> getEffect(){
		return effect;
	}

	public void setCostType(String costType){
		this.costType = costType;
	}

	public String getCostType(){
		return costType;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCooldown(List<Integer> cooldown){
		this.cooldown = cooldown;
	}

	public List<Integer> getCooldown(){
		return cooldown;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setCostBurn(String costBurn){
		this.costBurn = costBurn;
	}

	public String getCostBurn(){
		return costBurn;
	}

	public void setVars(List<VarsItem> vars){
		this.vars = vars;
	}

	public List<VarsItem> getVars(){
		return vars;
	}

	public void setEffectBurn(List<Object> effectBurn){
		this.effectBurn = effectBurn;
	}

	public List<Object> getEffectBurn(){
		return effectBurn;
	}

	@Override
 	public String toString(){
		return 
			"SpellsItem{" + 
			"cooldownBurn = '" + cooldownBurn + '\'' + 
			",image = '" + image + '\'' + 
			",cost = '" + cost + '\'' + 
			",maxammo = '" + maxammo + '\'' + 
			",leveltip = '" + leveltip + '\'' + 
			",resource = '" + resource + '\'' + 
			",rangeBurn = '" + rangeBurn + '\'' + 
			",tooltip = '" + tooltip + '\'' + 
			",description = '" + description + '\'' + 
			",range = '" + range + '\'' + 
			",maxrank = '" + maxrank + '\'' + 
			",effect = '" + effect + '\'' + 
			",costType = '" + costType + '\'' + 
			",name = '" + name + '\'' + 
			",cooldown = '" + cooldown + '\'' + 
			",id = '" + id + '\'' + 
			",costBurn = '" + costBurn + '\'' + 
			",vars = '" + vars + '\'' + 
			",effectBurn = '" + effectBurn + '\'' + 
			"}";
		}
}